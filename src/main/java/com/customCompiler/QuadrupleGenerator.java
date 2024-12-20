package com.customCompiler;
import java.util.ArrayList;
import java.util.List;

public class QuadrupleGenerator extends MinINGParserBaseVisitor<String> {
    private int tempCount = 0;
    private List<String> quadruples = new ArrayList<>();

    private String newTemp() {
        tempCount++;
        return "t" + tempCount;
    }

    public List<String> getQuadruples() {
        return quadruples;
    }

    @Override
    public String visitAssignmentExpression(MinINGParser.AssignmentExpressionContext ctx) {
        String variable = ctx.IDF().getText();
        String value = visit(ctx.expression());
        quadruples.add(String.format("(=, %s, , %s)", value, variable));
        return variable;
    }

    @Override
    public String visitAddition(MinINGParser.AdditionContext ctx) {
        String left = visit(ctx.term());
        String result = left;

        for (int i = 1; i < ctx.expression().size(); i++) {
            String right = visit(ctx.expression(i));
            result = newTemp();
            quadruples.add(String.format("(+, %s, %s, %s)", left, right, result));
            left = result;
        }
        return result;
    }

    @Override
    public String visitSubtraction(MinINGParser.SubtractionContext ctx) {
        String left = visit(ctx.term());
        String result = left;

        for (int i = 1; i < ctx.expression().size(); i++) {
            String right = visit(ctx.expression(i));
            result = newTemp();
            quadruples.add(String.format("(-, %s, %s, %s)", left, right, result));
            left = result;
        }
        return result;
    }

    @Override
    public String visitMultiplication(MinINGParser.MultiplicationContext ctx) {
        String left = visit(ctx.factor());
        String result = left;

        for (int i = 1; i < ctx.expression().size(); i++) {
            String right = visit(ctx.expression(i));
            result = newTemp();
            quadruples.add(String.format("(*, %s, %s, %s)", left, right, result));
            left = result;
        }
        return result;
    }

    @Override
    public String visitDivision(MinINGParser.DivisionContext ctx) {
        String left = visit(ctx.factor());
        String result = left;

        for (int i = 1; i < ctx.expression().size(); i++) {
            String right = visit(ctx.expression(i));
            result = newTemp();
            quadruples.add(String.format("(/, %s, %s, %s)", left, right, result));
            left = result;
        }
        return result;
    }

    @Override
    public String visitParenthesis(MinINGParser.ParenthesisContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public String visitInteger(MinINGParser.IntegerContext ctx) {
        return ctx.INT().getText();
    }

    @Override
    public String visitVariable(MinINGParser.VariableContext ctx) {
        return ctx.IDF().getText();
    }

    @Override
    public String visitConditionalStatement(MinINGParser.ConditionalStatementContext ctx) {
        String condition = visit(ctx.conditionExpr());
        String trueLabel = "L" + (quadruples.size() + 1);
        String falseLabel = "L" + (quadruples.size() + 2);

        quadruples.add(String.format("(IF, %s, , %s)", condition, trueLabel));
        visit(ctx.statement(0)); // If-block
        quadruples.add(String.format("(GOTO, , , %s)", falseLabel));

        quadruples.add(String.format("(LABEL, , , %s)", trueLabel));
        if (ctx.ELSE() != null) {
            visit(ctx.statement(1)); // Else-block
        }
        quadruples.add(String.format("(LABEL, , , %s)", falseLabel));
        return null;
    }
}
