package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

import java.util.List;

public class LoopExpression extends Expression {

    private final Expression initialization;
    private final int rangeEnd;
    private final String loopVariable;
    private final List<Expression> body;
    private final int stepValue; // Optional, default is 1


    public LoopExpression(Expression initialization, int rangeEnd, String loopVariable, List<Expression> body, int stepValue) {
        this.initialization = initialization;
        this.rangeEnd = rangeEnd;
        this.loopVariable = loopVariable;
        this.body = body;
        this.stepValue = stepValue;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        initialization.evaluate(symbolTable);
        Object loopStartValue = initialization.evaluate(symbolTable);
        if (!(loopStartValue instanceof Integer)) {
            throw new RuntimeException("Loop variable must be an integer.");
        }
        int currentValue = (int) loopStartValue;
        while (currentValue <= rangeEnd) {
            // Update the loop variable in the symbol table
            symbolTable.setValue(loopVariable, currentValue);

            // Evaluate all statements in the loop body
            for (Expression stmt : body) {
                stmt.evaluate(symbolTable);
            }

            // Increment the loop variable by the step value
            currentValue += stepValue;
        }
        return null;
    }

    @Override
    public String getType(){
        return "VOID";
    }
}
