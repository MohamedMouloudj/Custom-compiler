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
    private static HashMap<String, String> comparators;

    public static HashMap<String, String> getComparators() {
        return comparators;
    }

    public QuadrupleGenerator() {
        this.quadruples = new Quadruples();
        initComparators();
    }


    public List<QuadElement> getQuadruples() {
        return quadruples.getQuadruples();
    }

    /**
     * Add a quadruple at the end, if the last block of code is a jump to the end of the program
     * */
    public void needsExtraQuadruple(SymbolTable symbolTable) {
        int size = quadruples.size();
        boolean needsExtraQuad=quadruples.getQuadruples().stream()
                .filter(quadElement -> quadElement.getOperator().startsWith("B"))
                .anyMatch(quadElement -> {
                    int num = Integer.parseInt((quadElement.getOperand1()).evaluate(symbolTable).toString());
                    return num == size;
                });
        if (needsExtraQuad) quadruples.addQuad(null, null, null, null);
    }

    @Override
    public Expression visitAssignmentExpression(MinINGParser.AssignmentExpressionContext ctx) {
        Expression operand= visit(ctx.expression());
        String IDF = ctx.IDF().getText();
        QuadElement quad= quadruples.addQuad("=", operand, null, new LeafExpression(IDF));
        return quad.getResult();
    }

    @Override
    public Expression visitArrayElementAssignment(MinINGParser.ArrayElementAssignmentContext ctx) {
        String arrayName = ctx.IDF().getText();
        Object index = visit(ctx.expression(0)); // Get the index expression
        Expression value = visit(ctx.expression(1)); // Get the value expression
        QuadElement quad = quadruples.addQuad("=", value, null, new LeafExpression(arrayName+"["+index+"]"));
        return quad.getResult();
    }


    @Override
    public Expression visitConditionalStatement(MinINGParser.ConditionalStatementContext ctx) {
        Expression conditionTemp= visit(ctx.conditionExpr());
        QuadElement condQuad=quadruples.addQuad("BZ",null, conditionTemp,null);
        QuadElement breakQuad=null;
        // If block
        for(MinINGParser.StatementContext statement : ctx.ifstatements().statement()){
            visit(statement);
        }
        if (ctx.ELSE() != null) {
            breakQuad=quadruples.addQuad("BR", null, null,null);
            quadruples.updateQuad(condQuad.getNum(), "BZ", new LeafExpression(Integer.toString(quadruples.size())), conditionTemp, null);
            for(MinINGParser.StatementContext statement : ctx.elsestatments().statement()){
                visit(statement);
            }
            quadruples.updateQuad(breakQuad.getNum(), "BR", new LeafExpression(Integer.toString(quadruples.size())), null, null);
        }else {
            quadruples.updateQuad(condQuad.getNum(), "BZ", new LeafExpression(Integer.toString(quadruples.size())), conditionTemp, null);
        }
        return null;
    }

    /**
     *  1: true<br>
     *  0: false
     * */
    @Override
    public Expression visitComparison(MinINGParser.ComparisonContext ctx) {
        Expression left = visit(ctx.expression(0));
        Expression right = visit(ctx.expression(1));
        String comparator = ctx.getChild(1).getText();
        TempExpression compTemp = new TempExpression();
        quadruples.addQuad(getReverse(comparator),null ,left , right);
        quadruples.addQuad("=", new LeafExpression("0"), null, compTemp);
        quadruples.addQuad("BR", null, null, null);
        quadruples.addQuad("=", new LeafExpression("1"), null, compTemp);
        quadruples.updateQuad(quadruples.size()-2,"BR",new LeafExpression(Integer.toString(quadruples.size())),null,null);
        quadruples.updateQuad(quadruples.size()-4,getReverse(comparator),new LeafExpression(Integer.toString(quadruples.size()-1)),left,right);
        return compTemp;
    }

    @Override
    public Expression visitParenthesisCondition(MinINGParser.ParenthesisConditionContext ctx) {
        return visit(ctx.conditionExpr());
    }

    @Override
    public Expression visitNegation(MinINGParser.NegationContext ctx) {
        Expression condition = visit(ctx.conditionExpr());
        quadruples.addQuad("BNZ", null, condition, null);
        TempExpression notTemp = new TempExpression();
        quadruples.addQuad("=", new LeafExpression("1"), null, notTemp);
        quadruples.addQuad("BR", null, null, null);
        quadruples.addQuad("=", new LeafExpression("0"), null, notTemp);
        quadruples.updateQuad(quadruples.size()-4,"BNZ",new LeafExpression(Integer.toString(quadruples.size()-1)),condition,null);
        quadruples.updateQuad(quadruples.size()-2,"BR",new LeafExpression(Integer.toString(quadruples.size())),null,null);
        return notTemp;
    }

    @Override
    public Expression visitOrCondition(MinINGParser.OrConditionContext ctx) {
        Expression left = visit(ctx.conditionExpr(0));
        Expression right = visit(ctx.conditionExpr(1));
        quadruples.addQuad("BNZ", null, left, null);
        quadruples.addQuad("BNZ", null, right, null);
        TempExpression orTemp = new TempExpression();
        quadruples.addQuad("=", new LeafExpression("0"), null, orTemp);
        quadruples.addQuad("BR", null, null, null);
        quadruples.addQuad("=", new LeafExpression("1"), null, orTemp);
        quadruples.updateQuad(quadruples.size()-5,"BNZ",new LeafExpression(Integer.toString(quadruples.size()-1)),left,null);
        quadruples.updateQuad(quadruples.size()-4,"BNZ",new LeafExpression(Integer.toString(quadruples.size()-1)),right,null);
        quadruples.updateQuad(quadruples.size()-2,"BR",new LeafExpression(Integer.toString(quadruples.size())),null,null);
        return orTemp;
    }

    @Override
    public Expression visitAndCondition(MinINGParser.AndConditionContext ctx) {
        Expression left = visit(ctx.conditionExpr(0));
        Expression right = visit(ctx.conditionExpr(1));
        quadruples.addQuad("BZ", null, left, null);
        quadruples.addQuad("BZ", null, right, null);
        TempExpression andTemp = new TempExpression();
        quadruples.addQuad("=", new LeafExpression("1"), null, andTemp);
        quadruples.addQuad("BR", null, null, null);
        quadruples.addQuad("=", new LeafExpression("0"), null, andTemp);
        quadruples.updateQuad(quadruples.size()-5,"BZ",new LeafExpression(Integer.toString(quadruples.size()-1)),left,null);
        quadruples.updateQuad(quadruples.size()-4,"BZ",new LeafExpression(Integer.toString(quadruples.size()-1)),right,null);
        quadruples.updateQuad(quadruples.size()-2,"BR",new LeafExpression(Integer.toString(quadruples.size())),null,null);
        return andTemp;
    }


    @Override
    public Expression visitAddition(MinINGParser.AdditionContext ctx) {
        Expression left = visit(ctx.expression());
        Expression right = visit(ctx.term());
        QuadElement quad=quadruples.addQuad("+", left, right, new TempExpression());
        return quad.getResult() ;

    }


    @Override
    public Expression visitSubstraction(MinINGParser.SubstractionContext ctx) {
        Expression left = visit(ctx.expression());
        Expression right = visit(ctx.term());
        QuadElement quad =quadruples.addQuad("-", left, right, new TempExpression());
        return quad.getResult() ;
    }


    @Override
    public Expression visitMultiplication(MinINGParser.MultiplicationContext ctx) {
        Expression left = visit(ctx.term());
        Expression right = visit(ctx.operation_gf());
        QuadElement quad=quadruples.addQuad("*", left, right, new TempExpression());
        return quad.getResult() ;

    }

    @Override
    public Expression visitDivision(MinINGParser.DivisionContext ctx) {
        Expression left = visit(ctx.term());
        Expression right = visit(ctx.operation_gf());
        QuadElement quad=quadruples.addQuad("/", left, right, new TempExpression());
        return quad.getResult() ;

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
            QuadElement quad = quadruples.addQuad(ctx.getChild(0).getText(), operande1, null, new TempExpression());
            return quad.getResult() ;
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
    private static String getReverse(String comparator) {
        return switch (comparator) {
            case "==" -> "BNE";
            case "!=" -> "BE";
            case ">" -> "BLE";
            case ">=" -> "BL";
            case "<" -> "BGE";
            case "<=" -> "BG";
            default -> null;
        };
    }


    @Override
    public Expression visitLoopDefinition(MinINGParser.LoopDefinitionContext ctx) {
        Expression initValue = visit(ctx.loopAssignment().expression());
        quadruples.addQuad("=", initValue, null, new LeafExpression(ctx.loopAssignment().IDF().getText()));
        Expression stopCondition = visit(ctx.expression(0));
        Expression step = visit(ctx.expression(1));
        QuadElement condition=quadruples.addQuad(comparators.get(">="), null, new LeafExpression(ctx.loopAssignment().IDF().getText()), stopCondition);
        for (MinINGParser.StatementContext statement : ctx.statement()) {
            visit(statement);
        }
        quadruples.addQuad("+", new LeafExpression(ctx.loopAssignment().IDF().getText()), step, new LeafExpression(ctx.loopAssignment().IDF().getText()));
        quadruples.addQuad("BR",new LeafExpression(Integer.toString(condition.getNum())) , null, null);
        quadruples.updateQuad(condition.getNum(), comparators.get(">="), new LeafExpression(Integer.toString(quadruples.size())), new LeafExpression(ctx.loopAssignment().IDF().getText()), stopCondition);
        return null;
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

