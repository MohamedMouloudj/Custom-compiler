/* package com.customCompiler;

// class symbol of table added by brahim

import com.customCompiler.expressions.Expression;

public class Symbol {
    private Expression.ExpressionType type;
    private Object value;
    private String scope="";
    private boolean isConstant;
    private String memoryAddress;
    private int size;

    public Symbol(Expression.ExpressionType type, Object value, boolean isConstant, String memoryAddress, int size) {
        this.type = type;
        this.value = value;
        this.isConstant = isConstant;
        this.memoryAddress = memoryAddress;
        this.size = size;
    }


    public Expression.ExpressionType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public String getScope() {
        return scope;
    }

    public boolean isConstant() {
        return isConstant;
    }

    public String getMemoryAddress() {
        return memoryAddress;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                ", type='" + type.toString() + '\'' +
                ", value='" + value + '\'' +
                ", scope='" + scope + '\'' +
                ", isConstant=" + isConstant +
                ", memoryAddress='" + memoryAddress + '\'' +
                ", dimension='" + size + '\'' +
                '}';
    }
} */


package com.customCompiler;

import com.customCompiler.expressions.Expression;
//import org.stringtemplate.v4.ST;




public class Symbol {
    public enum Scope {
        GLOBAL
    }

    private String name; // Nom du symbole (ajouté)
    private Expression.ExpressionType type;
    private Object value;
    private Scope scope;
    private boolean isConstant;
    private int size;

    // Constructeur modifié pour inclure le nom
    public Symbol(String name, Expression.ExpressionType type, Object value, Scope scope, boolean isConstant, int size) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.scope = scope;
        this.isConstant = isConstant;
        this.size = size;
    }


    // Méthode pour récupérer le nom
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
                "name='" + name +
                ", type=" + type +
                ", value=" + value +
                ", scope=" + scope +
                ", isConstant=" + isConstant +
                ", size=" + size +
                '}';
    }
}