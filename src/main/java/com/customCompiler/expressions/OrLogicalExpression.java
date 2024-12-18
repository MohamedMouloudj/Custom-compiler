package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

public class OrLogicalExpression extends Expression implements LogicalExpression {
    private final Expression left;
    private final Expression right;
    private final LogicalOperator operator = LogicalOperator.OR;

    public OrLogicalExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
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
        return "Or{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public LogicalOperator getOperator() {
        return operator;
    }
}
