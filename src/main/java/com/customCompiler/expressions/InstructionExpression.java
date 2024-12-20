package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

import java.util.List;

public class InstructionExpression extends Expression{
    private final List<Expression> instrustions;

    public InstructionExpression(List<Expression> instructions) {
        this.instrustions = instructions;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return null;
    }

    @Override
    public ExpressionType getType() {
        return null;
    }

    @Override
    public String toString() {
        return "InstructionExpression{" +
                "instrustions=" + instrustions +
                '}';
    }
}
