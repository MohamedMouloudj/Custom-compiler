package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

public class ArrayElementExpression extends Expression {
    private final String arrayName;
    private final int index;
    private ExpressionType type;

    public ArrayElementExpression(String arrayName, int index) {
        this.arrayName = arrayName;
        this.index = index;

    }


    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return symbolTable.getSymbol(arrayName).getValue();
    }

    @Override
    public ExpressionType getType() {
        return null;
    }
    public ExpressionType getType(SymbolTable symbolTable) {
        return symbolTable.getSymbol(arrayName).getType();
    }

    @Override
    public String toString() {
        return "ArrayElementExpression{" +
                arrayName + "[" + index + "]=" + value +
                '}';
    }
}
