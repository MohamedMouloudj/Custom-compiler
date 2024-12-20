package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

import java.util.List;

public class CompositeArrayDeclarationExpression extends Expression {
    private final List<ArrayDeclarationExpression> expressions;

    public CompositeArrayDeclarationExpression(List<ArrayDeclarationExpression> expressions) {
        this.expressions = expressions;
//        System.out.println(expressions);
//        System.out.println("returning new CompositeArrayDeclarationExpression");
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        for (ArrayDeclarationExpression expression : expressions) {
            expression.evaluate(symbolTable);
        }
        return null;
    }

    @Override
    public ExpressionType getType() {
        return expressions.isEmpty() ? null : expressions.getFirst().getType();
    }

    @Override
    public String toString() {
        return "CompositeArrayDeclarationExpression{" +
                "expressions=" + expressions +
                "}\n";
    }
}
