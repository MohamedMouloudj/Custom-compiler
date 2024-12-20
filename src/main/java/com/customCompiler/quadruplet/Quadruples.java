package com.customCompiler.quadruplet;

import java.util.ArrayList;

public class Quadruples {
    private final ArrayList<QuadElement> quadruples;

    public Quadruples() {
        this.quadruples = new ArrayList<>();
    }

    public QuadElement addQuad(String operator, String op1, String op2, String result) {
        QuadElement quad = new QuadElement(operator, op1, op2, result, quadruples.size());
        quadruples.add(quad);
        return quad;
    }

    public void updateQuad(int index, String operator, String op1, String op2, String result) {
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
