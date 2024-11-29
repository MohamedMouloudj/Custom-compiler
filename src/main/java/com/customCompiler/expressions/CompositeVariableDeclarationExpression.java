package com.customCompiler.expressions;

import com.customCompiler.SymbolTable;

import java.util.List;
import java.util.stream.Collectors;

public class CompositeVariableDeclarationExpression extends Expression {
    private final List<VariableDeclarationExpression> declarations;

    public CompositeVariableDeclarationExpression(List<VariableDeclarationExpression> declarations) {
        this.declarations = declarations;
    }

    @Override
    public Object evaluate(SymbolTable symbolTable) {
        // Evaluate each declaration (Idk if necessary)
        for (VariableDeclarationExpression decl : declarations) {
            decl.evaluate(symbolTable);
        }
        return null;
    }


    @Override
    public String getType() {
        // All declarations are of the same type, return that type
        return declarations.isEmpty() ? null : declarations.get(0).getType();
    }

    @Override
    public String toString() {
        return declarations.stream()
                .map(VariableDeclarationExpression::toString)
                .collect(Collectors.joining(", "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeVariableDeclarationExpression that = (CompositeVariableDeclarationExpression) o;
        return declarations.equals(that.declarations);
    }

    @Override
    public int hashCode() {
        return declarations.hashCode();
    }

    public List<VariableDeclarationExpression> getDeclarations() {
        return declarations;
    }
}
