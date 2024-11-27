// Generated from src/main/java/com/customCompiler/MinINGParser.g4 by ANTLR 4.13.2

    package com.customCompiler;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MinINGParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MinINGParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MinINGParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MinINGParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#varGlobal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarGlobal(MinINGParser.VarGlobalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(MinINGParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(MinINGParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(MinINGParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MinINGParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MinINGParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(MinINGParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(MinINGParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#ioOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIoOperation(MinINGParser.IoOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MinINGParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(MinINGParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(MinINGParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#conditionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionExpr(MinINGParser.ConditionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#comparisonOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOp(MinINGParser.ComparisonOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#stringOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringOrExpression(MinINGParser.StringOrExpressionContext ctx);
}