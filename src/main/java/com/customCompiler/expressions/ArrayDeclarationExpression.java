package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

public class ArrayDeclarationExpression extends Expression {
    private ExpressionType type;
    private String name;
    private int size;

    public ArrayDeclarationExpression(String type, String name, int size) {
        this.type = ExpressionType.valueOf(type.toUpperCase());
        this.name = name;
        this.size = size;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {

        return null;
    }

     @Override
    public ExpressionType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ArrayDeclarationExpression{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
