package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

public class GreaterThanExpression extends Expression {

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return null;
    }

    @Override
    public String getType(){
        return ExpressionType.ARITHMETIC.toString();
    }
    public String toString() {
        return ">";
    }
}
