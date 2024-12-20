package com.customCompiler.quadruplet;

import com.customCompiler.*;
import com.customCompiler.expressions.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuadrupleGenerator extends MinINGParserBaseVisitor<Expression> {
    private final Quadruples quadruples;
    private final Stack<Integer> loopStack;
    private static HashMap<String, String> comparators;
    private int tempCounter = 0;

    public QuadrupleGenerator() {
        this.quadruples = new Quadruples();
        this.loopStack = new Stack<>();
        initComparators();
    }

    private String newTemp() {
        return "T" + (++tempCounter);
    }

    public List<QuadElement> getQuadruples() {
        return quadruples.getQuadruples();
    }

    @Override
    public Expression visitAssignmentExpression(MinINGParser.AssignmentExpressionContext ctx) {
        Expression operande = visit(ctx.expression());
        String IDF = ctx.IDF().getText();
        System.out.println(quadruples.addQuad("=", operande.toString(), "null", IDF).toString());
        return new TempExpression();
    }


    @Override
    public Expression visitConditionalStatement(MinINGParser.ConditionalStatementContext ctx) {
        Expression condition = visit(ctx.conditionExpr());

        int branchIfFalseIndex = quadruples.size();
        quadruples.addQuad("BZ", condition.toString(), null, "?");


        visit(ctx.statement(0));

        if (ctx.ELSE() != null) {

            int jumpToEndIndex = quadruples.size();
            quadruples.addQuad("BR", null, null, "?");


            int elseStart = quadruples.size();
            quadruples.updateQuad(branchIfFalseIndex, "BZ", condition.toString(), null, String.valueOf(elseStart));

            visit(ctx.statement(1));


            int afterElse = quadruples.size();
            quadruples.updateQuad(jumpToEndIndex, "BR", null, null, String.valueOf(afterElse));
        } else {

            int afterIf = quadruples.size();
            quadruples.updateQuad(branchIfFalseIndex, "BZ", condition.toString(), null, String.valueOf(afterIf));
        }

        return null;
    }

    @Override
    public Expression visitAddition(MinINGParser.AdditionContext ctx) {
        //(+,G,D,T)
        //5+3 => (+,5,3,T1)  (5+4-2) => (+,5,T1,T2),(-,4,2,T1)   ((5+4)-(3+4))
        Expression left = visit(ctx.term());

        if(!ctx.expression().isEmpty()) {
            System.out.println("in addition left: " + left.toString());
            Expression temp = new TempExpression();
            for (int i = 0; i < ctx.expression().size(); i++) {
                Expression right = visit(ctx.expression(i));
                System.out.println("right : " + right.toString()  + " i " + i);
                System.out.println(quadruples.addQuad("+", left.toString(), right.toString(), temp.toString()).toString());
            }
            return temp;
        }else{
            return left;
        }

    }


    @Override
    public Expression visitSubtraction(MinINGParser.SubtractionContext ctx) {
        Expression left = visit(ctx.term());
        if(!ctx.expression().isEmpty()) {
            Expression temp = new TempExpression();
            for (int i = 0; i < ctx.expression().size(); i++) {
                Expression right = visit(ctx.expression(i));
                System.out.println(quadruples.addQuad("-", left.toString(), right.toString(), temp.toString()).toString());
            }
            return temp;
        }else {
            return left;
        }
    }


    @Override
    public Expression visitMultiplication(MinINGParser.MultiplicationContext ctx) {
        Expression left = visit(ctx.factor());
        System.out.println("left in multiplication " + left.toString());
        if(!ctx.expression().isEmpty()) {
            Expression temp = new TempExpression();
            for (int i = 0; i < ctx.expression().size(); i++) {
                Expression right = visit(ctx.expression(i));
                System.out.println("right in multiplication " + right.toString());
                System.out.println(quadruples.addQuad("*", left.toString(), right.toString(), temp.toString()).toString());
            }
            return temp;
        }else{
            return left;
        }
    }

    @Override
    public Expression visitDivision(MinINGParser.DivisionContext ctx) {
        Expression left = visit(ctx.factor());
        System.out.println("left in Div " + left.toString());

        if(!ctx.expression().isEmpty()) {
            Expression temp = new TempExpression();
            for (int i = 0; i < ctx.expression().size(); i++) {
                Expression right = visit(ctx.expression(i));
                System.out.println(quadruples.addQuad("/", left.toString(), right.toString(), temp.toString()).toString());

            }
            return temp;
        }else {
            return left;
        }
    }

    @Override
    public Expression visitLoopDefinition(MinINGParser.LoopDefinitionContext ctx) {
        visit(ctx.loopAssignment());

        int loopStart = quadruples.size();
        loopStack.push(loopStart);

        Expression condition = visit(ctx.expression(2));

        int branchToEndIndex = quadruples.size();
        quadruples.addQuad("BZ", condition.toString(), null, "?");


        visit((ParseTree) ctx.statement());

        visit(ctx.expression(1));

        quadruples.addQuad("BR", null, null, String.valueOf(loopStart));


        int afterLoop = quadruples.size();
        quadruples.updateQuad(branchToEndIndex, "BZ", condition.toString(), null, String.valueOf(afterLoop));

        loopStack.pop();
        return null;
    }

    private static void initComparators() {
        comparators = new HashMap<>();
        comparators.put("==", "BE");
        comparators.put("!=", "BNE");
        comparators.put(">", "BG");
        comparators.put(">=", "BGE");
        comparators.put("<", "BL");
        comparators.put("<=", "BLE");
    }


    @Override
    public Expression visitParenthesis(MinINGParser.ParenthesisContext ctx) {
        //(5+6+(5+6)) => (+,5,6,T1),(+,6,T1,T2),(+,5,T2,T3)
        return visit(ctx.expression());
    }

    @Override
    public Expression visitInteger(MinINGParser.IntegerContext ctx) {
        String integerString = ctx.INT().getText();
        System.out.println("in integer " + integerString);
        return new LeafExpression(integerString);
    }

    @Override
    public Expression visitFloat(MinINGParser.FloatContext ctx) {
        String floatString = ctx.FLOAT().getText();
        return new LeafExpression((floatString));
    }

    @Override
    public Expression visitChar(MinINGParser.CharContext ctx) {
        String valueString = ctx.CHAR().getText();
        return new LeafExpression(valueString);
    }

    @Override
    public Expression visitVariable(MinINGParser.VariableContext ctx) {
        String variableName = ctx.IDF().getText();

        return new LeafExpression(variableName);
    }

}

