package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

public class StringExpression extends Expression {
    private final String value;

    public StringExpression(String value) {
        this.value = value;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return value;
    }

    @Override
    public ExpressionType getType(){
        return ExpressionType.CHAR;
    }
}
