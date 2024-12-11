package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

import java.util.Objects;

/**
 * Represents an integer expression
 */
public class IntegerExpression extends Expression {
    private final int value;

    public IntegerExpression(int value) {
        this.value = value;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return value;
    }

    @Override
    public ExpressionType getType() {
        return ExpressionType.INTEGER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerExpression that = (IntegerExpression) o;
        return value == that.value;
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
