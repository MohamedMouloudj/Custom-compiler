package com.customCompiler;

import com.customCompiler.expressions.Expression;
import org.stringtemplate.v4.ST;



import java.io.Serializable;

public class Symbol implements Serializable {
    public enum Scope {
        GLOBAL
    }

    private String name;
    private Expression.ExpressionType type;
    private Object value;
    private Scope scope;
    private boolean isConstant;
    private int size;

    public Symbol(String name, Expression.ExpressionType type, Object value, Scope scope, boolean isConstant, int size) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Le nom du symbole ne peut pas être nul ou vide.");
        }
        this.name = name;
        this.type = type;
        this.value = value;
        this.scope = scope;
        this.isConstant = isConstant;
        this.size = size;
    }

    public String getName() {
        return name;
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
                "name='" + name + '\'' +
                ", type=" + type +
                ", value=" + value +
                ", scope=" + scope +
                ", isConstant=" + isConstant +
                ", size=" + size +
                '}';
    }
}
