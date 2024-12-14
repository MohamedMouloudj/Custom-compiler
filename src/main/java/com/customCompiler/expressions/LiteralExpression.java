package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

public class LiteralExpression extends Expression {
    private final String value;

    public LiteralExpression(String value) {
        this.value = value;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return value;
    }
    @Override
    public Expression.ExpressionType getType() {
       return Expression.ExpressionType.UNKNOWN;
       //TODO : CHECK THIS ?
    }


    @Override
    public String toString() {
        return value;
    }
}
