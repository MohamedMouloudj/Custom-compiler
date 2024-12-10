package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

import java.util.List;

public class CompositeArrayDeclarationExpression extends Expression {
    private final List<ArrayDeclarationExpression> expressions;

    public CompositeArrayDeclarationExpression(List<ArrayDeclarationExpression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        for (ArrayDeclarationExpression expression : expressions) {
            expression.evaluate(symbolTable);
        }
        return null;
    }

    @Override
    public ExpressionType getType() {
        return expressions.isEmpty() ? null : expressions.getFirst().getType();
    }
}
