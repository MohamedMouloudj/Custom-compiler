package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

public class ConstantExpression extends Expression {
    private final Object value;
    private final ExpressionType type;
    private final String constantName;

    public ConstantExpression(String constantName,ExpressionType type,Object value) {
        this.value = value;
        this.type = type;
        this.constantName = constantName;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return value;
    }

    @Override
    public ExpressionType getType() {
        return type;
    }

    @Override
    public String toString() {
        return constantName+"("+value+")";
    }
}
