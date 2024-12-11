package com.customCompiler;

import com.customCompiler.expressions.Expression;

import java.util.List;

// QUESTION: Do we need this?
public class ExpressionProcessor {
    public static void evaluate(List<Expression> expressions,SymbolTable symbolTable) {
        for (Expression expression : expressions) {
            expression.evaluate(symbolTable);
        }
    }
}
