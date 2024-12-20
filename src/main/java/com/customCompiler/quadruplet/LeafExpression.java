package com.customCompiler.quadruplet;

import com.customCompiler.SymbolTable;
import com.customCompiler.expressions.Expression;

public class LeafExpression extends Expression {
    private String expression;
    public LeafExpression(String expression) {
        this.expression = expression;
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
        return expression;
    }

}


