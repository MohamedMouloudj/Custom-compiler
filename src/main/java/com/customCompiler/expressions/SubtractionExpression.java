package com.customCompiler.expressions;

import com.customCompiler.SymbolTable; /**
 * Subtraction expression
 */
public class SubtractionExpression extends BinaryExpression {
    public SubtractionExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        Object leftVal = left.evaluate(symbolTable);
        Object rightVal = right.evaluate(symbolTable);

        if (leftVal instanceof Integer && rightVal instanceof Integer) {
            return (Integer) leftVal - (Integer) rightVal;
        } else if (leftVal instanceof Float || rightVal instanceof Float) {
            return ((Number) leftVal).floatValue() - ((Number) rightVal).floatValue();
        }

        throw new RuntimeException("Incompatible types for subtraction");
    }

    @Override
    public ExpressionType getType() {
        // Determine type based on operands
        if (left.getType().equals(ExpressionType.FLOAT) || right.getType().equals(ExpressionType.FLOAT)) {
            return ExpressionType.FLOAT;
        }
        return ExpressionType.INTEGER;
    }

    @Override
    public String toString() {
        return "(" + left + " - " + right + ")";
    }
}
