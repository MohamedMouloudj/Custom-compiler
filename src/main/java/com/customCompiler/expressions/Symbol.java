package com.customCompiler.expressions;

// class symbol of table added by brahim

public class Symbol {
    private String name;
    private String type;
    private String value;
    private String scope;
    private boolean isConstant;
    private String memoryAddress;
    private String dimension;

    public Symbol(String name, String type, String value, String scope, boolean isConstant, String memoryAddress, String dimension) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.scope = scope;
        this.isConstant = isConstant;
        this.memoryAddress = memoryAddress;
        this.dimension = dimension;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
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
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", scope='" + scope + '\'' +
                ", isConstant=" + isConstant +
                ", memoryAddress='" + memoryAddress + '\'' +
                ", dimension='" + dimension + '\'' +
                '}';
    }
}
