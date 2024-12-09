package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

public class ArrayDeclarationExpression extends Expression {
    private String type;
    private String name;
    private int size;

    public ArrayDeclarationExpression(String type, String name, int size) {
        this.type = type;
        this.name = name;
        this.size = size;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        symbolTable.addVariable(type, name);
        return 1;
    }

     @Override
    public String getType() {
        if(type.equals("INTEGER")){
            return ExpressionType.INTEGER.toString();
        }else if(type.equals("FLOAT")) {
            return ExpressionType.FLOAT.toString();
        }else if(type.equals("CHAR")){
            return ExpressionType.CHARACTER.toString();
        }else{
            return null;
        }
    }
}
