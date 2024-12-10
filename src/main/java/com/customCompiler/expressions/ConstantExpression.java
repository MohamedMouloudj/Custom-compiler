package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

public class ConstantExpression extends Expression {
    private final String name;
    private final Expression value;
    private final String type;

    public ConstantExpression(String name,  String type,Expression value) {
        if (value == null || type == null) {
            throw new IllegalArgumentException("Value and type cannot be null");
        }
        this.name = name;
        this.value = value;
        this.type = type;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        this.value.evaluate(symbolTable);
        return value;
    }

    @Override
    public String getType() {
        return type;
    }
}
