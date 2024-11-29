package com.customCompiler.expressions;

import java.util.ArrayList;
import java.util.List;

public class Program {
    // A list of expressions in the program (each expression is a line in the program)
    public List<Expression> expressions;

    public Program() {
        this.expressions = new ArrayList<>();
    }

    public void addExpression(Expression e) {
        this.expressions.add(e);
    }
}
