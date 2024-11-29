package com.customCompiler.expressions;


import com.customCompiler.SymbolTable;

import java.util.Objects;

/**
 * Abstract base class for all expressions in the MinING language
 */
public abstract class Expression {
    /**
     * Evaluates the expression and returns its value
     * @param symbolTable The symbol table used for variable lookups
     * @return The computed value of the expression
     */
    public abstract Object evaluate(SymbolTable symbolTable);

    /**
     * Gets the type of the expression
     * @return The type of the expression (INTEGER, FLOAT, CHAR)
     */
    public abstract String getType();

    // Enum to represent different expression types
    public enum ExpressionType {
        INTEGER,
        FLOAT,
        CHARACTER,
        VARIABLE,
        ARITHMETIC,
        PARENTHESIZED
    }
}

