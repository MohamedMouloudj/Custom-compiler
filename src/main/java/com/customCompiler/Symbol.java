package com.customCompiler;

// class symbol of table added by brahim

import com.customCompiler.expressions.Expression;

public class Symbol {
    private Expression.ExpressionType type;
    private Object value;
    private String scope;
    private boolean isConstant;
    private String memoryAddress;
    private String dimension;

    public Symbol(Expression.ExpressionType type, Object value, String scope, boolean isConstant, String memoryAddress, String dimension) {
        this.type = type;
        this.value = value;
        this.scope = scope;
        this.isConstant = isConstant;
        this.memoryAddress = memoryAddress;
        this.dimension = dimension;
    }


    public Expression.ExpressionType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public String getScope() {
        return scope;
    }

    public boolean isConstant() {
        return isConstant;
    }

    public String getMemoryAddress() {
        return memoryAddress;
    }

    public String getDimension() {
        return dimension;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                ", type='" + type.toString() + '\'' +
                ", value='" + value + '\'' +
                ", scope='" + scope + '\'' +
                ", isConstant=" + isConstant +
                ", memoryAddress='" + memoryAddress + '\'' +
                ", dimension='" + dimension + '\'' +
                '}';
    }
}
