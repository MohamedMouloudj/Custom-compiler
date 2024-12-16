package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

import java.util.List;

public class DeclarationExpression extends Expression{
    private final List<Expression> declarations;

    public DeclarationExpression( List<Expression> declarations) {
        this.declarations=declarations;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return null;
    }

    @Override
    public ExpressionType getType() {
        return null;
    }

    @Override
    public String toString() {
        return "DeclarationExpression{" +
                "Declarations=" + declarations +
                "}\n";
    }
}
