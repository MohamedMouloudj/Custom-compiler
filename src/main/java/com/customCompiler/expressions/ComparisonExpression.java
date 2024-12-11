package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

/**
 * Comparison expression for handling operations like >, <, >=, etc.
 */
public class ComparisonExpression extends Expression {
    private final Expression left;
    private final Expression right;
    private final String operator;

    public ComparisonExpression(Expression left, Expression right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        Object leftVal = left.evaluate(symbolTable);
        Object rightVal = right.evaluate(symbolTable);

        if (!(leftVal instanceof Number) || !(rightVal instanceof Number)) {
            throw new RuntimeException("Incompatible types for comparison");
        }

        float leftNum = ((Number) leftVal).floatValue();
        float rightNum = ((Number) rightVal).floatValue();

        // Perform the comparison based on the operator
        return switch (operator) {
            case ">" -> leftNum > rightNum;
            case "<" -> leftNum < rightNum;
            case ">=" -> leftNum >= rightNum;
            case "<=" -> leftNum <= rightNum;
            case "==" -> leftNum == rightNum;
            case "!=" -> leftNum != rightNum;
            default -> throw new RuntimeException("Invalid comparison operator: " + operator);
        };
    }

    @Override
    public ExpressionType getType() {
        return ExpressionType.BOOLEAN; // Comparison results in a boolean type
    }

    @Override
    public String toString() {
        return "(" + left + " " + operator + " " + right + ")";
    }
}
