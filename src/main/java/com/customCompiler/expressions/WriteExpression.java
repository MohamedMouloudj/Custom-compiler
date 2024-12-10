package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

import java.util.List;

public class WriteExpression extends Expression {
    private List<Expression> expressions;

    public WriteExpression(List<Expression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        for (Expression expr : expressions) {
            System.out.print(expr.evaluate(symbolTable) + " ");
        }
        System.out.println();  // Print a new line after the output
        return null;  // WRITE does not return a value
    }



    @Override
    public ExpressionType getType() {
        return ExpressionType.;  // No return value for WRITE
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("WRITE ");
        s.append(" ");
        for (Expression expr : expressions) {
            s.append(expr).append(" ");
        };
        return s.toString();
    }
}
