package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

import java.util.List;

public class DeclarationsExpression extends Expression{
    private final List<Expression> variableDeclarations;

    public DeclarationsExpression(List<Expression> declarations) {
        if (declarations == null) {
            throw new IllegalArgumentException("Declarations list cannot be null");
        }
        this.variableDeclarations = declarations;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        for (Expression declaration : variableDeclarations) {
            declaration.evaluate(symbolTable);
        }
        return null;
    }

    @Override
    public String getType() {
        return "VOID"; // Declarations themselves don't have a specific type
    }
}
