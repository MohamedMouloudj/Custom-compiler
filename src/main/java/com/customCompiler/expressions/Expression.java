package com.customCompiler.expressions;


import com.customCompiler.SymbolTable;

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
     *
     * @return The type of the expression (INTEGER, FLOAT, CHAR)
     */
    public abstract ExpressionType getType();

    /**
     * Enum to represent different expression types.<br>
     * Note: BOOLEAN is used for comparison expressions. Its usage is just for compilation purpose, user cannot use it.
     * */
    public enum ExpressionType {
        INTEGER,
        FLOAT,
        CHAR,
        BOOLEAN,
    }
    public enum LogicalOperator{
        AND,
        OR,
        NOT,
    }
}

