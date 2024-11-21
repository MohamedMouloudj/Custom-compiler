// Generated from src/main/java/com/customCompiler/MinINGParser.g4 by ANTLR 4.13.2

    package com.customCompiler.generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MinINGParser}.
 */
public interface MinINGParserListener extends ParseTreeListener {
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
	 * Enter a parse tree produced by {@link MinINGParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(MinINGParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(MinINGParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(MinINGParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(MinINGParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#table_decl}.
	 * @param ctx the parse tree
	 */
	void enterTable_decl(MinINGParser.Table_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#table_decl}.
	 * @param ctx the parse tree
	 */
	void exitTable_decl(MinINGParser.Table_declContext ctx);
}