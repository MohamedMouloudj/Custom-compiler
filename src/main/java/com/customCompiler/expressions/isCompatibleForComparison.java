package com.customCompiler.expressions;

public class isCompatibleForComparison {
    Expression left ;
    Expression right ;
    public isCompatibleForComparison(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public boolean checkCompatibility(){
        if (left.getType() == right.getType()) {
            return true;
        }
        if (left.getType() == Expression.ExpressionType.INTEGER &&
                right.getType() == Expression.ExpressionType.FLOAT) {
            return true;
        }
        if (left.getType() == Expression.ExpressionType.FLOAT &&
                right.getType() == Expression.ExpressionType.INTEGER) {
            return true;
        }
       if (left.getType() == Expression.ExpressionType.BOOLEAN ||
                right.getType() == Expression.ExpressionType.BOOLEAN) {
            return false;
       }
       if (left.getType() == Expression.ExpressionType.CHAR ||
                right.getType() == Expression.ExpressionType.CHAR) {
            return false;
       }
       return false;
    }
}
