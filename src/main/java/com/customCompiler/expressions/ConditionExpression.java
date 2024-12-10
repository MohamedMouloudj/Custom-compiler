package com.customCompiler.expressions;

import java.util.List;
import com.customCompiler.SymbolTable;

public class ConditionExpression extends Expression{
    private final Expression condition;
    private final List<Expression> ifBody;
    private final List<Expression> elseBody;

    public ConditionExpression(Expression condition, List<Expression> ifBody, List<Expression> elseBody) {
        if (condition == null || ifBody == null) {
            throw new IllegalArgumentException("Condition and ifBody cannot be null");
        }
        this.condition = condition;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }
    @Override
    public Object evaluate(SymbolTable symbolTable) {
        // Evaluate the condition
        Object conditionValue = condition.evaluate(symbolTable);

        if (conditionValue instanceof Boolean) {
            if ((Boolean) conditionValue) {
                for (Expression expr : ifBody) {
                    expr.evaluate(symbolTable);
                }
            } else if (elseBody != null) {
                for (Expression expr : elseBody) {
                    expr.evaluate(symbolTable);
                }
            }
        } else {
            throw new RuntimeException("Condition must evaluate to a boolean value");
        }

        return null;
    }
    @Override
    public String getType() {
        return "VOID"; // Conditions do not return a specific type
    }
}
