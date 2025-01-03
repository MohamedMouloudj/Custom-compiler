package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

public class AndLogicalExpression extends Expression implements LogicalExpression {
    private final Expression left;
    private final Expression right;
    private final LogicalOperator operator = LogicalOperator.AND;

    public AndLogicalExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return null;
    }

    @Override
    public ExpressionType getType() {
        return ExpressionType.BOOLEAN;
    }

    @Override
    public String toString() {
        return "And{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public LogicalOperator getOperator() {
        return operator;
    }
}
