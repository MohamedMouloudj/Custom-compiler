package com.customCompiler.expressions;
import com.customCompiler.SymbolTable;

import java.util.List;
public class IfBlocksExpression extends Expression {
    private final Expression condition;
    private final List<Expression> ifStatements;
    private final List<Expression> elseStatements;

    public IfBlocksExpression(Expression condition, List<Expression> ifStatements, List<Expression> elseStatements) {
        this.condition = condition;
        this.ifStatements = ifStatements;
        this.elseStatements = elseStatements;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        return null;
    }

    @Override
    public ExpressionType getType(){
        return null;
    }


    public Expression getCondition() {
        return condition;
    }

    public List<Expression> getIfStatements() {
        return ifStatements;
    }

    public List<Expression> getElseStatements() {
        return elseStatements;
    }

    @Override
    public String toString() {
        return "IfBlocksExpression{" +
                "condition=" + condition +
                ", ifStatements=" + ifStatements +
                ", elseStatements=" + elseStatements +
                '}';
    }
}
