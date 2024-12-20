package com.customCompiler.quadruplet;

import com.customCompiler.SymbolTable;
import com.customCompiler.expressions.*;

public class TempExpression extends Expression {
    static private int nbTemp = 0;
    private int num;

    public TempExpression() {
        this.num = nbTemp;
        nbTemp++;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "T" + num;
    }

    public static void deleteLastTemp(){
        nbTemp--;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return null;
    }

    @Override
    public ExpressionType getType() {
        return null;
    }
}


