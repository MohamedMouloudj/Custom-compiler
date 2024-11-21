// Generated from src/main/java/com/customCompiler/MinINGParser.g4 by ANTLR 4.13.2

    package com.customCompiler.generated;

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
	 * Visit a parse tree produced by {@link MinINGParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MinINGParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(MinINGParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(MinINGParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#table_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_decl(MinINGParser.Table_declContext ctx);
}