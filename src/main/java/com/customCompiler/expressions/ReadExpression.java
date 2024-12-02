package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

public class ReadExpression extends Expression {
    private String varName;  // The variable name to which the input is assigned

    public ReadExpression(String varName) {
        this.varName = varName;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {

        System.out.println("Enter value for " + varName + ": ");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int value = scanner.nextInt();

        symbolTable.addVariable(varName,value);

        return value;
    }

    @Override
    public String toString() {
        return "Read operation for " + varName;
    }

    @Override
    public String getType() {
        return "void";
    }
}
