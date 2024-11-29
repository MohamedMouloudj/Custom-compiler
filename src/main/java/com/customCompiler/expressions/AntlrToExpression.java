package com.customCompiler.expressions;

import com.customCompiler.MinINGParser;
import com.customCompiler.MinINGParserBaseVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class AntlrToExpression extends MinINGParserBaseVisitor<Expression> {

    private final List<String> variables; // store all the variables declared in the program
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
            return variableDeclarations.get(0);
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
        return super.visitConstDeclaration(ctx);
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
        return super.visitLoopStatement(ctx);
    }

    @Override
    public Expression visitIOStatement(MinINGParser.IOStatementContext ctx) {
        return super.visitIOStatement(ctx);
    }

    @Override
    public Expression visitAssignmentExpression(MinINGParser.AssignmentExpressionContext ctx) {
        return super.visitAssignmentExpression(ctx);
    }

    @Override
    public Expression visitConditionalStatement(MinINGParser.ConditionalStatementContext ctx) {
        return super.visitConditionalStatement(ctx);
    }

    @Override
    public Expression visitLoopDefinition(MinINGParser.LoopDefinitionContext ctx) {
        return super.visitLoopDefinition(ctx);
    }

    @Override
    public Expression visitReadOperation(MinINGParser.ReadOperationContext ctx) {
        return super.visitReadOperation(ctx);
    }

    @Override
    public Expression visitWriteOperation(MinINGParser.WriteOperationContext ctx) {
        return super.visitWriteOperation(ctx);
    }

    @Override
    public Expression visitAddition(MinINGParser.AdditionContext ctx) {
        return super.visitAddition(ctx);
    }

    @Override
    public Expression visitSubtraction(MinINGParser.SubtractionContext ctx) {
        return super.visitSubtraction(ctx);
    }

    @Override
    public Expression visitMultiplication(MinINGParser.MultiplicationContext ctx) {
        return super.visitMultiplication(ctx);
    }

    @Override
    public Expression visitDivision(MinINGParser.DivisionContext ctx) {
        return super.visitDivision(ctx);
    }

    @Override
    public Expression visitParenthesis(MinINGParser.ParenthesisContext ctx) {
        return super.visitParenthesis(ctx);
    }

    @Override
    public Expression visitInteger(MinINGParser.IntegerContext ctx) {
        return super.visitInteger(ctx);
    }

    @Override
    public Expression visitFloat(MinINGParser.FloatContext ctx) {
        return super.visitFloat(ctx);
    }

    @Override
    public Expression visitChar(MinINGParser.CharContext ctx) {
        return super.visitChar(ctx);
    }

    @Override
    public Expression visitVariable(MinINGParser.VariableContext ctx) {
        return super.visitVariable(ctx);
    }

    @Override
    public Expression visitComparison(MinINGParser.ComparisonContext ctx) {
        return super.visitComparison(ctx);
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
