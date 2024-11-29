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
    public String getType() {
        // Determine type based on operands
        if (left.getType().equals(ExpressionType.FLOAT.toString()) || right.getType().equals(ExpressionType.FLOAT.toString())) {
            return ExpressionType.FLOAT.toString();
        }
        return ExpressionType.INTEGER.toString();
    }

    @Override
    public String toString() {
        return "(" + left + " - " + right + ")";
    }
}
