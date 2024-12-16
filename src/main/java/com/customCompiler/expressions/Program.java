package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

import java.util.ArrayList;
import java.util.List;

public class Program {
    // A list of expressions in the program (each expression is a line in the program)
    public List<Expression> expressions;
    public SymbolTable symbolTable;

    public Program() {
        this.expressions = new ArrayList<>();
        this.symbolTable = new SymbolTable();
    }

    public void addExpression(Expression e) {
        this.expressions.add(e);
//        System.out.println(e);
//        System.out.println("Adding exp");
    }
}
