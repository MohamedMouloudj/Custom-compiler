package com.customCompiler.expressions;

public class LoopExpression extends Expression {

    private final Expression initialization;
    private final int rangeEnd;
    private final String loopVariable;
    private final List<Expression> body;
    private final int stepValue; // Optional, default is 1

    public LoopExpression(Expression initialization, int rangeEnd, String loopVariable, List<Expression> body) {
        this(initialization, rangeEnd, loopVariable, body, 1); // Default step is 1
    }

    public LoopExpression(Expression initialization, int rangeEnd, String loopVariable, List<Expression> body, int stepValue) {
        this.initialization = initialization;
        this.rangeEnd = rangeEnd;
        this.loopVariable = loopVariable;
        this.body = body;
        this.stepValue = stepValue;
    }
}
