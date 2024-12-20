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
        // Visit and evaluate the condition expression
        Expression condition = visit(ctx.conditionExpr());

        // Extract the left and right operands and operator from the condition
        String[] parts = extractConditionParts(ctx.conditionExpr().getText());
        String leftOperand = parts[0];
        String operator = parts[1];
        String rightOperand = parts[2];

        // Get the appropriate comparison operator
        String compareOp = comparators.getOrDefault(operator, "BG");

        // Generate comparison quadruple directly without temporary variable
        int branchIfFalseIndex = quadruples.size();
        quadruples.addQuad(compareOp, leftOperand, rightOperand, "?");

        // Visit the 'if' block
        visit(ctx.statement(0));

        // Check if there's an 'else' block
        if (ctx.statement().size() > 1) {
            // Add jump instruction to skip else block after completing if block
            int jumpToEndIndex = quadruples.size();
            quadruples.addQuad("BR", null, null, "?");

            // Mark the start of else block
            int elseStart = quadruples.size();

            // Update the false branch to jump to else block
            quadruples.updateQuad(branchIfFalseIndex, compareOp, leftOperand, rightOperand, String.valueOf(elseStart));

            // Visit the 'else' block
            visit(ctx.statement(1));

            // Mark the end of conditional statement
            int afterConditional = quadruples.size();

            // Update the jump after if block to skip else
            quadruples.updateQuad(jumpToEndIndex, "BR", null, null, String.valueOf(afterConditional));
        } else {
            // If no else block, update false branch to jump to end
            int afterConditional = quadruples.size();
            quadruples.updateQuad(branchIfFalseIndex, compareOp, leftOperand, rightOperand, String.valueOf(afterConditional));
        }

        return null;
    }

    // Helper method to extract condition parts (left operand, operator, right operand)
    private String[] extractConditionParts(String condition) {
        String[] parts = new String[3];
        Pattern pattern = Pattern.compile("(.*?)(==|!=|<=|>=|<|>)(.*)");
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

