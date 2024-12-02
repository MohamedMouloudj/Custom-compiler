package com.customCompiler.expressions;

import com.customCompiler.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AntlrToExpression extends MinINGParserBaseVisitor<Expression> {
    private ArrayList<> variables;
    private  SymbolTable symbolTable; // store all the variables declared in the program
    private final List<String> semanticErrors;


    public AntlrToExpression(List<String> semanticErrors) {
        this.variables = new ArrayList<>();
        this.semanticErrors = semanticErrors;
    }

    @Override
    public Expression visitVariableGlobalSegment(MinINGParser.VariableGlobalSegmentContext ctx) {
        return super.visitVariableGlobalSegment(ctx);
    }

    @Override
    public Expression visitDeclarationSegment(MinINGParser.DeclarationSegmentContext ctx) {
        return super.visitDeclarationSegment(ctx);
    }

    @Override
    public Expression visitInstructionSegment(MinINGParser.InstructionSegmentContext ctx) {
        return super.visitInstructionSegment(ctx);
    }

    @Override
    public Expression visitVariableDeclaration(MinINGParser.VariableDeclarationContext ctx) {
        String type = ctx.TYPE().getText();
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine() + 1;

        List<TerminalNode> idfs = ctx.IDF();

        // List to store all variable declaration expressions
        List<VariableDeclarationExpression> variableDeclarations = new ArrayList<>();

        // Check and process each identifier
        for (TerminalNode idf : idfs) {
            String varName = idf.getText();

            // Check for duplicate variables
            ATNConfigSet variables = null;
            if (variables.contains(varName)) {
                semanticErrors.add("Error: Duplicate variable declaration " + varName + " at " + line + ":" + column);
            } else {
                variables.add(varName);

                // Create a variable declaration expression for each variable
                VariableDeclarationExpression varDecl = new VariableDeclarationExpression(type, varName);
                variableDeclarations.add(varDecl);
            }
        }

        if (variableDeclarations.isEmpty()) {
            return null;
        }

        // If only one variable, return that single declaration
        if (variableDeclarations.size() == 1) {
            return variableDeclarations.getFirst();
        }

        // If multiple variables, you might want to create a composite expression
        // This depends on your language's specific requirements
        return new CompositeVariableDeclarationExpression(variableDeclarations);
    }

    @Override
    public Expression visitArrayDeclaration(MinINGParser.ArrayDeclarationContext ctx) {

        return super.visitArrayDeclaration(ctx);
    }

    @Override
    public Expression visitConstDeclaration(MinINGParser.ConstDeclarationContext ctx) {
        String type = ctx.TYPE().getText();
        String constantName = ctx.IDF().getText();
        Expression value = null;

        if(type.equals("INT")){
            int valueInt = Integer.parseInt(ctx.INT().getText());
            value = new IntegerExpression(valueInt);
        } else if (type.equals("FLOAT")) {
            float valueFloat = Float.parseFloat(ctx.FLOAT().getText());
            value = new FloatExpression(valueFloat);
        } else if (type.equals("CHAR")) {
            char valueChar = ctx.CHAR().getText().charAt(0);
            value = new CharExpression(valueChar);
        }

        symbolTable.setValue(constantName, value);
        return value;
    }

    @Override
    public Expression visitAssignmentStatement(MinINGParser.AssignmentStatementContext ctx) {
        return super.visitAssignmentStatement(ctx);
    }

    @Override
    public Expression visitConditionStatement(MinINGParser.ConditionStatementContext ctx) {

        return super.visitConditionStatement(ctx);
    }

    @Override
    public Expression visitLoopStatement(MinINGParser.LoopStatementContext ctx) {
//        visit(ctx.assignment());
//        String varName = ctx.assignement().IDF().getText();
//
//        int endVal = Integer.parseInt(ctx.INT().getText());
//        String stepVar = ctx.IDF().getText();
//        while(symboleTable.get(varName)<endVal){
//            for(MinINGParser.StatementContext statement : ctx.statement){
//                visit(statement);
//            }
//
//            symbolTable.put(varName,symbolTable.get(varName)+1);
//        }
        return super.visitLoopStatement(ctx);
    }

    @Override
    public Expression visitIOStatement(MinINGParser.IOStatementContext ctx) {
        return super.visitIOStatement(ctx);
    }

    @Override
    public Expression visitAssignmentExpression(MinINGParser.AssignmentExpressionContext ctx) {
        String variableName = ctx.IDF().getText();
        Expression expressionValue = visit(ctx.expression());
        //TODO : check if we calculate the expression or not
        return super.visitAssignmentExpression(ctx);
    }

    @Override
    public Expression visitConditionalStatement(MinINGParser.ConditionalStatementContext ctx) {

        return null;

    }

    @Override
    public Expression visitLoopDefinition(MinINGParser.LoopDefinitionContext ctx) {
        return super.visitLoopDefinition(ctx);
    }

    @Override
    public Expression visitReadOperation(MinINGParser.ReadOperationContext ctx) {
//        String variableName = ctx.IDF().getText();
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
//        Object value = parseInput(input);
//        symbolTable.setValue(variableName,value);
//
//        return new ReadExpression(variableName);

        //DEPEND ON WHAT U WANT : The difference is that calling evaluate() immediately triggers the input operation and stores the value right away, while deferring evaluation allows you to construct the AST first and evaluate it later, providing more control over when side effects (like user input) occur.

        String variableName = ctx.IDF().getText();
        Expression r = new ReadExpression(variableName);
        r.evaluate(symbolTable);
        return r;
    }

    private Object parseInput(String input) {
        if (input.contains(".")){
            return Float.parseFloat(input);
        } else{
            return Integer.parseInt(input);
        }
    }

    @Override
    public Expression visitWriteOperation(MinINGParser.WriteOperationContext ctx) {
        List<MinINGParser.StringOrExpressionContext> expressions = ctx.stringOrExpression();
        List<Expression> expressionList = new ArrayList<>();
        for (MinINGParser.StringOrExpressionContext exprContext : expressions) {
            // Visit the context to get the corresponding Expression
            Expression expr = visit(exprContext);
            expressionList.add(expr);
        }

        // Create a WriteExpression with the list of Expressions
        WriteExpression w = new WriteExpression(expressionList);
        return w;
    }

    @Override
    public Expression visitAddition(MinINGParser.AdditionContext ctx) {
        Expression result = visit(ctx.term(0));
        for(int i = 1;i<ctx.term().size();i++){
            Expression right = visit(ctx.term(i));
            result = new AdditionExpression(result, right);
        }
        return result;
    }

    @Override
    public Expression visitSubtraction(MinINGParser.SubtractionContext ctx) {
        Expression result = visit(ctx.term(0));
        for(int i = 1;i<ctx.term().size();i++){
            Expression right = visit(ctx.term(i));
            result = new SubtractionExpression(result, right);
        }
        return result;
    }

    @Override
    public Expression visitMultiplication(MinINGParser.MultiplicationContext ctx) {
        Expression result = visit(ctx.factor(0));
        for (int i = 1; i < ctx.factor().size(); i++) {
            Expression right = visit(ctx.factor(i));
            result = new MultiplicationExpression(result, right);
        }
        return result;
    }


    @Override
    public Expression visitDivision(MinINGParser.DivisionContext ctx) {
        List<MinINGParser.FactorContext> factors = ctx.factor(); //Car : (MUL factor)*
        Expression left = visit(factors.get(0));
        Expression right = visit(factors.get(1));

        return new DivisionExpression(left, right);
    }

    @Override
    public Expression visitParenthesis(MinINGParser.ParenthesisContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Expression visitInteger(MinINGParser.IntegerContext ctx) {
        Integer value = Integer.parseInt(ctx.INT().getText());
        return super.visitInteger(ctx);
    }

    @Override
    public Expression visitFloat(MinINGParser.FloatContext ctx) {
        float value = Float.parseFloat(ctx.FLOAT().getText());
        return new FloatExpression(value);
    }

    @Override
    public Expression visitChar(MinINGParser.CharContext ctx) {
        String valueString = ctx.CHAR().getText();
        return new CharExpression(valueString.charAt(0));
    }

    @Override
    public Expression visitVariable(MinINGParser.VariableContext ctx) {
        String variableName = ctx.IDF().getText();
        return new VariableExpression(variableName,symbolTable);
    }

    @Override
    public Expression visitComparison(MinINGParser.ComparisonContext ctx) {
        // Evaluate the left and right expressions
        Expression left = visit(ctx.expression(0));
        Expression right = visit(ctx.expression(1));

        // Retrieve the comparison operator
        String op = ctx.comparisonOp().getText();

        // Wrap the comparison logic into a ComparisonExpression object
        return new ComparisonExpression(left, right, op);
    }

    @Override
    public Expression visitComparisonOp(MinINGParser.ComparisonOpContext ctx) {

        return super.visitComparisonOp(ctx);
    }

    @Override
    public Expression visitStringLiteral(MinINGParser.StringLiteralContext ctx) {

        return super.visitStringLiteral(ctx);
    }

    @Override
    public Expression visitExpressionInWrite(MinINGParser.ExpressionInWriteContext ctx) {
        return super.visitExpressionInWrite(ctx);
    }
}
