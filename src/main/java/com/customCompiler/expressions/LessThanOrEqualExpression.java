package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

public class LessThanOrEqualExpression extends Expression {
    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return null;
    }

    @Override
    public String getType(){
        return Expression.ExpressionType.ARITHMETIC.toString();
    }
    public String toString() {
        return "<=";
    }
}
