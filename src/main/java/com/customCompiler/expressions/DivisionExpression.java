package com.customCompiler.expressions;

import com.customCompiler.Symbol;
import com.customCompiler.SymbolTable; /**
 * Division expression
 */
public class DivisionExpression extends BinaryExpression {
    public DivisionExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        Object leftVal = ((Symbol)left.evaluate(symbolTable)).getValue();
        Object rightVal = ((Symbol)right.evaluate(symbolTable)).getValue();

        if (rightVal instanceof Number && ((Number) rightVal).doubleValue() == 0) {
            throw new ArithmeticException("Division by zero");
        }

        if (leftVal instanceof Integer && rightVal instanceof Integer) {
            return (Integer) leftVal / (Integer) rightVal;
        } else if (leftVal instanceof Float || rightVal instanceof Float) {
            assert rightVal instanceof Number;
            return ((Number) leftVal).floatValue() / ((Number) rightVal).floatValue();
        }

        throw new RuntimeException("Incompatible types for division");
    }

    @Override
    public ExpressionType getType() {
        // Division always results in a float
        return ExpressionType.FLOAT;
    }

    @Override
    public String toString() {
        return "(" + left + " / " + right + ")";
    }
}
