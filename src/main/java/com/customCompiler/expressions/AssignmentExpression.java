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

    @@Override
    public String getType(){
        if (value instanceof VariableDeclarationExpression) {
            return ((VariableDeclarationExpression) value).getType();
        } else if (value instanceof ConstantExpression) {
            return ((ConstantExpression) value).getType(); // If constants are handled in a separate class
        }else{
            return null;
        }
    }
}
