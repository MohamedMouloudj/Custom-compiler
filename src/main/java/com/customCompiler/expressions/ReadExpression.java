package com.customCompiler.expressions;

import com.customCompiler.Symbol;
import com.customCompiler.SymbolTable;

public class ReadExpression extends Expression {
    private String varName;  // The variable name to which the input is assigned

    public ReadExpression(String varName) {
        this.varName = varName;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int value = scanner.nextInt();
        Symbol readSymbol = new Symbol(ExpressionType.INTEGER, value, "GLOBAL", false, "0", "0");

        symbolTable.addSymbol(varName,readSymbol);

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
