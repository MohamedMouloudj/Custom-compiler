// Generated from src/main/java/com/customCompiler/MinINGParser.g4 by ANTLR 4.13.2

    package com.customCompiler;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MinINGParser}.
 */
public interface MinINGParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MinINGParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MinINGParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MinINGParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#varGlobal}.
	 * @param ctx the parse tree
	 */
	void enterVarGlobal(MinINGParser.VarGlobalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#varGlobal}.
	 * @param ctx the parse tree
	 */
	void exitVarGlobal(MinINGParser.VarGlobalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(MinINGParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(MinINGParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(MinINGParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(MinINGParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(MinINGParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(MinINGParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MinINGParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MinINGParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MinINGParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MinINGParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(MinINGParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(MinINGParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(MinINGParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(MinINGParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#ioOperation}.
	 * @param ctx the parse tree
	 */
	void enterIoOperation(MinINGParser.IoOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#ioOperation}.
	 * @param ctx the parse tree
	 */
	void exitIoOperation(MinINGParser.IoOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MinINGParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MinINGParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(MinINGParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(MinINGParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(MinINGParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(MinINGParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#conditionExpr}.
	 * @param ctx the parse tree
	 */
	void enterConditionExpr(MinINGParser.ConditionExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#conditionExpr}.
	 * @param ctx the parse tree
	 */
	void exitConditionExpr(MinINGParser.ConditionExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#comparisonOp}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOp(MinINGParser.ComparisonOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#comparisonOp}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOp(MinINGParser.ComparisonOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#stringOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterStringOrExpression(MinINGParser.StringOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#stringOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitStringOrExpression(MinINGParser.StringOrExpressionContext ctx);
}