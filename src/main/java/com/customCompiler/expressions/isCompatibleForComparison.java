package com.customCompiler.expressions;

public class isCompatibleForComparison {
    Expression left ;
    Expression right ;
    public isCompatibleForComparison(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public boolean checkCompatibilityComparision(){
       if(this.left != null && this.right != null){
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
       }else{
           return false;
       }
    }

    public boolean checkCompatibilityArithmetic(){
        // If the types are the same, they are compatible for addition
        if (left.getType() == right.getType()) {
            return true;
        }

        // If either of the operands is of type BOOLEAN, return false (since booleans can't be added)
        if (left.getType() == Expression.ExpressionType.BOOLEAN ||
                right.getType() == Expression.ExpressionType.BOOLEAN) {
            return false;
        }

        // If the types are different but compatible (e.g., integer + float), return true
        if ((left.getType() == Expression.ExpressionType.INTEGER && right.getType() == Expression.ExpressionType.FLOAT) ||
                (left.getType() == Expression.ExpressionType.FLOAT && right.getType() == Expression.ExpressionType.INTEGER)) {
            return true;
        }

        // For other cases, return false ( string + int,..)
        return false;

    }
}
