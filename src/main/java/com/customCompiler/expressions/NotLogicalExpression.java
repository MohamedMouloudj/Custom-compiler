package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

public class NotLogicalExpression extends Expression implements LogicalExpression {
    private final Expression expression;
    private final LogicalOperator operator = LogicalOperator.NOT;

    public NotLogicalExpression(Expression expression) {
        this.expression = expression;
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
        return "Not{" +
                "expression=" + expression +
                '}';
    }

    @Override
    public LogicalOperator getOperator() {
        return operator;
    }
}
