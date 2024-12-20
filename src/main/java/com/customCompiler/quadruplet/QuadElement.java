package com.customCompiler.quadruplet;

import com.customCompiler.expressions.Expression;

public class QuadElement {
    private Expression operator;
    private Expression operand1;
    private Expression operand2;
    private Expression result;
    private int num;

    public QuadElement(Expression operator, Expression operand1, Expression operand2, Expression result, int num) {
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
        this.num = num;
    }

    public Expression getOperator() {
        return operator;
    }

    public void setOperator(Expression operator) {
        this.operator = operator;
    }

    public Expression getOperand1() {
        return operand1;
    }

    public void setOperand1(Expression operand1) {
        this.operand1 = operand1;
    }

    public Expression getOperand2() {
        return operand2;
    }

    public void setOperand2(Expression operand2) {
        this.operand2 = operand2;
    }

    public Expression getResult() {
        return result;
    }

    public void setResult(Expression result) {
        this.result = result;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public  String toString() {
        return num + ": (" + operator + ", " + operand1 + ", " + operand2 + ", " + result + ")";
    }
}