package com.customCompiler.quadruplet;

public class QuadElement {
    private String operator;
    private String operand1;
    private String operand2;
    private String result;
    private int num;

    public QuadElement(String operator, String operand1, String operand2, String result, int num) {
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
        this.num = num;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperand1() {
        return operand1;
    }

    public void setOperand1(String operand1) {
        this.operand1 = operand1;
    }

    public String getOperand2() {
        return operand2;
    }

    public void setOperand2(String operand2) {
        this.operand2 = operand2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return num + ": (" + operator + ", " + operand1 + ", " + operand2 + ", " + result + ")";
    }
}
