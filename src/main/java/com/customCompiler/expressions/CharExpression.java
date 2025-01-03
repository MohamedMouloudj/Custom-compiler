package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

import java.util.Objects; /**
 * Represents a character expression
 */
public class CharExpression extends Expression {
    private final String value;

    public CharExpression(String value) {
        this.value = value;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return value;
    }

    @Override
    public ExpressionType getType() {
        return ExpressionType.CHAR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharExpression that = (CharExpression) o;
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
