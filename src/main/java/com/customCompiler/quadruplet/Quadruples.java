package com.customCompiler.quadruplet;

import com.customCompiler.expressions.Expression;

import java.util.ArrayList;

public class Quadruples {
    private final ArrayList<QuadElement> quadruples;

    public Quadruples() {
        this.quadruples = new ArrayList<>();
    }

    public QuadElement addQuad(String operator, Expression op1, Expression op2, Expression result) {
        QuadElement quad = new QuadElement(operator, op1, op2, result, quadruples.size());
        quadruples.add(quad);
        return quad;
    }

    public void updateQuad(int index, String operator, Expression op1, Expression op2, Expression result) {
        QuadElement quad = new QuadElement(operator, op1, op2, result, index);
        quadruples.set(index, quad);
    }

    public int size() {
        return quadruples.size();
    }

    public ArrayList<QuadElement> getQuadruples() {
        return quadruples;
    }
}
