package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

public class VariableDeclarationExpression extends Expression {
    private String identifier;
    private Expression.ExpressionType type;


    public VariableDeclarationExpression(String type,String identifier) {
        this.identifier = identifier;
        this.type = Expression.ExpressionType.valueOf(type.toUpperCase());
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return null;
    }

    @Override
    public String getType() {
        return type.toString();
    }

    @Override
    public String toString() {
        return type + " " + identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VariableDeclarationExpression that = (VariableDeclarationExpression) o;
        return identifier.equals(that.identifier) && type == that.type;
    }

    @Override
    public int hashCode() {
        return identifier.hashCode() + type.hashCode();
    }

}
