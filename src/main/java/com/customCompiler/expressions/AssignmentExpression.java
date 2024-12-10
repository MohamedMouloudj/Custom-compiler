package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

public class AssignmentExpression extends Expression {
    private final String variableName;
    private final Expression value;

    public AssignmentExpression(String variableName, Expression value) {
        this.variableName = variableName;
        this.value = value;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        symbolTable.addVariable(variableName, value);
        return value;
    }

    @Override
    public ExpressionType getType(){
        return value.getType();
    }
}
