package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

import java.util.List;

public class BigAddExpression extends Expression {
    List<Expression> expressions;
    public BigAddExpression(List<Expression> expressions) {
        this.expressions = expressions;
    }
    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return null;
    }

    @Override
    public ExpressionType getType() {
        return expressions.get(0).getType();
    }
}
