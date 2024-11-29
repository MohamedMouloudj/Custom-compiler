package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

import java.util.Objects; /**
 * Represents a variable expression
 */
public class VariableExpression extends Expression {
    private final String identifier;
    private final SymbolTable symbolTable;

    public VariableExpression(String identifier, SymbolTable symbolTable) {
        this.identifier = identifier;
        this.symbolTable = symbolTable;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return symbolTable.getValue(identifier);
    }

    @Override
    public String getType() {
        return symbolTable.getType(identifier);
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VariableExpression that = (VariableExpression) o;
        return Objects.equals(identifier, that.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }

    @Override
    public String toString() {
        return identifier;
    }
}
