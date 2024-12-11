package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

import java.util.Objects; /**
 * Represents a float expression
 */
public class FloatExpression extends Expression {
    private final float value;

    public FloatExpression(float value) {
        this.value = value;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return value;
    }

    @Override
    public ExpressionType getType() {
        return ExpressionType.FLOAT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FloatExpression that = (FloatExpression) o;
        return Float.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
