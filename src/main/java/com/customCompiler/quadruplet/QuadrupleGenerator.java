package com.customCompiler.quadruplet;

import com.customCompiler.*;
import com.customCompiler.expressions.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.math.BigDecimal;
import java.util.ArrayList;
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
return null;
    }

    @Override
    public Expression visitComparison(MinINGParser.ComparisonContext ctx) {
        Expression left = visit(ctx.expression(0));
        Expression right = visit(ctx.expression(1));
        Expression op = visit(ctx.comparisonOp());
        Expression temp = new TempExpression();
        if(op.toString().equals( "==")){
            quadruples.addQuad("BE",right.toString(),left.toString(),temp.toString());
        }else if(op.toString().equals( "!=")){
            quadruples.addQuad("BNE",left.toString(),right.toString(),temp.toString());
        } else if (op.toString().equals( ">")) {
            quadruples.addQuad("BG",left.toString(),right.toString(),temp.toString());
        } else if (op.toString().equals( "<")) {
            quadruples.addQuad("BL",left.toString(),right.toString(),temp.toString());
        } else if (op.toString().equals( ">=")) {
            quadruples.addQuad("BGE",left.toString(),right.toString(),temp.toString());
        } else if (op.toString().equals( "<=")) {
            quadruples.addQuad("BLE",left.toString(),right.toString(),temp.toString());
        }
        return temp;
    }

    @Override
    public Expression visitParenthesisCondition(MinINGParser.ParenthesisConditionContext ctx) {
        return super.visitParenthesisCondition(ctx);
    }

    @Override
    public Expression visitNegation(MinINGParser.NegationContext ctx) {
        Expression condition = visit(ctx.conditionExpr());
        Expression temp = new TempExpression();
//        quadruples.addQuad();
        //
        return super.visitNegation(ctx);
    }

    @Override
    public Expression visitOrCondition(MinINGParser.OrConditionContext ctx) {
        Expression condition = visit(ctx.conditionExpr(0));
        Expression temp = new TempExpression();
        Expression condition2 = visit(ctx.conditionExpr(1));
        quadruples.addQuad("BNZ",condition.toString(),condition2.toString(),null);

return null;
    }

    @Override
    public Expression visitAndCondition(MinINGParser.AndConditionContext ctx) {
        Expression condition = visit(ctx.conditionExpr(0));
        Expression temp = new TempExpression();
        Expression condition2 = visit(ctx.conditionExpr(1));
//        quadruples.addQuad();
        return null;
    }

    @Override
    public Expression visitComparisonOp(MinINGParser.ComparisonOpContext ctx) {
        if(ctx.GREATER() != null) {
            return visit(ctx.GREATER());
        } else if (ctx.LESS() != null) {
            return visit(ctx.LESS());
        } else if (ctx.GREATEREQUAL() != null) {
            return visit(ctx.GREATEREQUAL());
        } else if (ctx.LESSEQUAL() != null) {
            return visit(ctx.LESSEQUAL());
        } else if (ctx.EQUAL() != null) {
            return visit(ctx.EQUAL());
        } else if (ctx.NOTEQUAL() != null) {
            return visit(ctx.NOTEQUAL());
        }else{
            return  null;
        }
    }

    @Override
    public Expression visitAddition(MinINGParser.AdditionContext ctx) {
        //(+,G,D,T)
        //5+3 => (+,5,3,T1)  (5+4-2) => (+,5,T1,T2),(-,4,2,T1)   ((5+4)-(3+4))
        Expression left = visit(ctx.expression());
        System.out.println("in addition left: " + left.toString());
        Expression temp = new TempExpression();
        Expression right = visit(ctx.term());
        System.out.println("right in addition: " + right.toString()  );
        System.out.println(quadruples.addQuad("+", left.toString(), right.toString(), temp.toString()).toString());
        return temp;


    }


    @Override
    public Expression visitSubstraction(MinINGParser.SubstractionContext ctx) {
        Expression left = visit(ctx.expression());
        Expression temp = new TempExpression();
        Expression right = visit(ctx.term());
        System.out.println(quadruples.addQuad("-", left.toString(), right.toString(), temp.toString()).toString());
        return temp;
    }


    @Override
    public Expression visitMultiplication(MinINGParser.MultiplicationContext ctx) {
        Expression left = visit(ctx.term());
        Expression temp = new TempExpression();
        Expression right = visit(ctx.operation_gf());
        quadruples.addQuad("*", left.toString(), right.toString(), temp.toString());
        return temp;

    }

    @Override
    public Expression visitDivision(MinINGParser.DivisionContext ctx) {
        Expression left = visit(ctx.term());
        Expression temp = new TempExpression();
        Expression right = visit(ctx.operation_gf());
        quadruples.addQuad("/", left.toString(), right.toString(), temp.toString());
        return temp;

    }

    @Override
    public Expression visitSimpleTerm(MinINGParser.SimpleTermContext ctx) {
        return visit(ctx.term());
    }

    @Override
    public Expression visitSimpleOp(MinINGParser.SimpleOpContext ctx) {
        return visit(ctx.operation_gf());
    }

    @Override
    public Expression visitOperation_gf(MinINGParser.Operation_gfContext ctx) {
        if (ctx.operation_gf() != null){
            Expression operande1 = visitOperation_gf(ctx.operation_gf());
            Expression temp = new TempExpression();
            QuadElement quad = quadruples.addQuad(ctx.getChild(0).getText(), operande1.toString(), null, temp.toString());
            return temp;
        } else if (ctx.expression() != null){
            return visit(ctx.expression());
        } else {
            return visit(ctx.factor());
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

