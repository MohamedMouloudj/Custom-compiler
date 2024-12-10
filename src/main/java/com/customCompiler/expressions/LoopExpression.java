package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

import java.util.List;

public class LoopExpression extends Expression {

    private final Expression initialization;
    private final Expression rangeEnd;
    private final String loopVariable;
    private final List<Expression> body;
    private final Expression step;

    public LoopExpression(Expression initialization,Expression step, Expression rangeEnd, String loopVariable, List<Expression> body) {
        this.initialization = initialization;
        this.rangeEnd = rangeEnd;
        this.loopVariable = loopVariable;
        this.body = body;
        this.step = step;
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
