package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

public class GreaterThanOrEqualExpression extends Expression {
    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return null;
    }

    @Override
    public String getType(){
        return Expression.ExpressionType.ARITHMETIC.toString();
    }
    public String toString() {
        return ">=";
    }
}
