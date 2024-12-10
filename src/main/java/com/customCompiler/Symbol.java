package com.customCompiler;

// class symbol of table added by brahim

import com.customCompiler.expressions.Expression;

public class Symbol {
    private Expression.ExpressionType type;
    private Object value;
    private String scope="";
    private boolean isConstant;
    private String memoryAddress;
    private int size;

    public Symbol(Expression.ExpressionType type, Object value, boolean isConstant, String memoryAddress, int size) {
        this.type = type;
        this.value = value;
        this.isConstant = isConstant;
        this.memoryAddress = memoryAddress;
        this.size = size;
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

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                ", type='" + type.toString() + '\'' +
                ", value='" + value + '\'' +
                ", scope='" + scope + '\'' +
                ", isConstant=" + isConstant +
                ", memoryAddress='" + memoryAddress + '\'' +
                ", dimension='" + size + '\'' +
                '}';
    }
}
