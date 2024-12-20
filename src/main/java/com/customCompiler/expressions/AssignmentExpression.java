package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

public class AssignmentExpression extends Expression {
    private final String variableName;
    private final Expression value;

    public AssignmentExpression(String variableName, Expression value) {
        this.variableName = variableName;
        this.value = value;
//        System.out.println("returning new AssignmentExpression");
//        System.out.println(variableName);
//        System.out.println(value);
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        symbolTable.setValue(variableName, value);
        return value;
    }

    @Override
    public ExpressionType getType(){
        return value.getType();
    }

    @Override
    public String toString() {
        return "AssignmentExpression{" +
                "variableName='" + variableName + '\'' +
                ", value=" + value +
                '}';
    }
}
