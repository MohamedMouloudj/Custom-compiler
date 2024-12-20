package com.customCompiler.expressions;

import com.customCompiler.Symbol;
import com.customCompiler.SymbolTable;

public class ArrayElementExpression extends Expression {
    private final String arrayName;
    private final int index;
    private ExpressionType type;
    private SymbolTable symbolTable;

    public ArrayElementExpression(String arrayName, int index, SymbolTable symbolTable) {
        this.arrayName = arrayName;
        this.index = index;
        this.symbolTable = symbolTable;

    }


    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return symbolTable.getSymbol(arrayName).getValue();
    }

    @Override
    public ExpressionType getType() {
        return symbolTable.getSymbol(arrayName).getType();
    }

    @Override
    public String toString() {
        return "ArrayElementExpression{" +
                arrayName + "[" + index + "]="  +
                '}';
    }
}
