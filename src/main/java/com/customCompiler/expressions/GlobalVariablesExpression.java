package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

import java.util.List;

public class GlobalVariablesExpression extends Expression {
    private List<Expression> globalVariables;

    public GlobalVariablesExpression(List<Expression> globalVariables) {
        this.globalVariables = globalVariables;
    }
    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return globalVariables;
    }

    @Override
    public String getType(){
        for(Expression e : globalVariables){
            return e.getType();
            //TODO : Check this
        }
        return null;
    }

    @Override
    public String toString() {
        return "GlobalVariables(" + globalVariables + ")";
    }
}
