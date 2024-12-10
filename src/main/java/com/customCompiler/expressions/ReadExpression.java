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
        Symbol readSymbol = symbolTable.getSymbol(varName);

//        if (readSymbol.getType().equals(ExpressionType.INTEGER)) {
//            int value = scanner.nextInt();
//            readSymbol.setValue(value);
//        } else if (readSymbol.getType().equals(ExpressionType.FLOAT)) {
//            float value = scanner.nextFloat();
//            readSymbol.setValue(value);
//        } else if (readSymbol.getType().equals(ExpressionType.CHAR)) {
//            char value = scanner.next().charAt(0);
//            readSymbol.setValue(value);
//        } else {
//            throw new RuntimeException("Invalid type for read operation");
//        }
        return null;
    }

    @Override
    public String toString() {
        return "Read operation for " + varName;
    }

    @Override
    public ExpressionType getType() {
        return null;
    }
}
