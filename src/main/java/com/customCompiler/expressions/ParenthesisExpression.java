package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

public class ParenthesisExpression extends Expression{
    private final Expression expression;

    public ParenthesisExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return null;
    }

    @Override
    public ExpressionType getType() {
        return expression.getType();
    }

    @Override
    public String toString() {
        return "ParenthesisExpression{" +
                "expression=" + expression +
                '}';
    }
}
