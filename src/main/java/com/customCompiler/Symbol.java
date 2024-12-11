package com.customCompiler;

import com.customCompiler.expressions.Expression;



import java.io.Serializable;

/**
 * Represent a symbol in the symbol table.
 * It implements Serializable just for encoding purpose
 */
public class Symbol implements Serializable {
    public enum Scope {
        GLOBAL
    }

    private Expression.ExpressionType type;
    private Object value;
    private Scope scope;
    private boolean isConstant;
    // if variable: size=0
    private int size;

    public Symbol(Expression.ExpressionType type, Object value, Scope scope, boolean isConstant, int size) {
        this.type = type;
        this.value = value;
        this.scope = scope;
        this.isConstant = isConstant;
        this.size = size;
    }


    public Expression.ExpressionType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Scope getScope() {
        return scope;
    }

    public boolean isConstant() {
        return isConstant;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                ", type=" + type +
                ", value=" + value +
                ", scope=" + scope +
                ", isConstant=" + isConstant +
                ", size=" + size +
                '}';
    }
}
