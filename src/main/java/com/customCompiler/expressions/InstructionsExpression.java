package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

import java.util.List;
public class InstructionsExpression extends Expression {
    private final List<Expression> instructions;

    public InstructionsExpression(List<Expression> instructions) {
        if (instructions == null) {
            throw new IllegalArgumentException("Instructions list cannot be null");
        }
        this.instructions = instructions;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        Object result = null;

        for (Expression instruction : instructions) {
            result = instruction.evaluate(symbolTable);
        }
        return null;
    }

    @Override
    public String getType() {
        return "VOID";
    }
}
