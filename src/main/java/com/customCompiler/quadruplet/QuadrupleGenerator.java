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
        quadruples.addQuad("=", operande.toString(), "null", IDF);
        return new TempExpression();
    }


    @Override
    public Expression visitConditionalStatement(MinINGParser.ConditionalStatementContext ctx) {
        return super.visitConditionalStatement(ctx);
    }

    private String[] extractConditionParts(String condition) {
        String[] parts = new String[3];
        Pattern pattern = Pattern.compile("(.?)(==|!=|<=|>=|<|>)(.)");
        Matcher matcher = pattern.matcher(condition.trim());

        if (matcher.find()) {
            parts[0] = matcher.group(1).trim();
            parts[1] = matcher.group(2).trim();
            parts[2] = matcher.group(3).trim();
        } else {
            // Default if no operator found
            parts[0] = condition.trim();
            parts[1] = ">";
            parts[2] = "0";
        }
        return parts;
    }

    @Override
    public Expression visitComparison(MinINGParser.ComparisonContext ctx) {
        return super.visitComparison(ctx);
    }

    @Override
    public Expression visitParenthesisCondition(MinINGParser.ParenthesisConditionContext ctx) {
        return super.visitParenthesisCondition(ctx);
    }

    @Override
    public Expression visitNegation(MinINGParser.NegationContext ctx) {
        return super.visitNegation(ctx);
    }

    @Override
    public Expression visitOrCondition(MinINGParser.OrConditionContext ctx) {
        return super.visitOrCondition(ctx);
    }

    @Override
    public Expression visitAndCondition(MinINGParser.AndConditionContext ctx) {
        return super.visitAndCondition(ctx);
    }



    @Override
    public Expression visitAddition(MinINGParser.AdditionContext ctx) {
        //(+,G,D,T)
        //5+3 => (+,5,3,T1)  (5+4-2) => (+,5,T1,T2),(-,4,2,T1)   ((5+4)-(3+4))
        Expression left = visit(ctx.expression());
        Expression temp = new TempExpression();
        Expression right = visit(ctx.term());
        quadruples.addQuad("+", left.toString(), right.toString(), temp.toString());
        return temp;

    }


    @Override
    public Expression visitSubstraction(MinINGParser.SubstractionContext ctx) {
        Expression left = visit(ctx.expression());
        Expression temp = new TempExpression();
        Expression right = visit(ctx.term());
        quadruples.addQuad("-", left.toString(), right.toString(), temp.toString());
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

