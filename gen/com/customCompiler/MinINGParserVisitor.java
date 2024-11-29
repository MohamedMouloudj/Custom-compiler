// Generated from D:/University/2024-09_Semester-5/Random-projects/Compilator-project/CustomCompiler/src/main/java/com/customCompiler/MinINGParser.g4 by ANTLR 4.13.2
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
	 * Visit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link MinINGParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MinINGParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableGlobalSegment}
	 * labeled alternative in {@link MinINGParser#varGlobal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableGlobalSegment(MinINGParser.VariableGlobalSegmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclarationSegment}
	 * labeled alternative in {@link MinINGParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationSegment(MinINGParser.DeclarationSegmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstructionSegment}
	 * labeled alternative in {@link MinINGParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructionSegment(MinINGParser.InstructionSegmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableDeclaration}
	 * labeled alternative in {@link MinINGParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(MinINGParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayDeclaration}
	 * labeled alternative in {@link MinINGParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclaration(MinINGParser.ArrayDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstDeclaration}
	 * labeled alternative in {@link MinINGParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDeclaration(MinINGParser.ConstDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentStatement}
	 * labeled alternative in {@link MinINGParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(MinINGParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionStatement}
	 * labeled alternative in {@link MinINGParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionStatement(MinINGParser.ConditionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopStatement}
	 * labeled alternative in {@link MinINGParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(MinINGParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IOStatement}
	 * labeled alternative in {@link MinINGParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIOStatement(MinINGParser.IOStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentExpression}
	 * labeled alternative in {@link MinINGParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(MinINGParser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionalStatement}
	 * labeled alternative in {@link MinINGParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalStatement(MinINGParser.ConditionalStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopDefinition}
	 * labeled alternative in {@link MinINGParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopDefinition(MinINGParser.LoopDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReadOperation}
	 * labeled alternative in {@link MinINGParser#ioOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadOperation(MinINGParser.ReadOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WriteOperation}
	 * labeled alternative in {@link MinINGParser#ioOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteOperation(MinINGParser.WriteOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link MinINGParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(MinINGParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link MinINGParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtraction(MinINGParser.SubtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link MinINGParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(MinINGParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link MinINGParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(MinINGParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link MinINGParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(MinINGParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link MinINGParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(MinINGParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Float}
	 * labeled alternative in {@link MinINGParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat(MinINGParser.FloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Char}
	 * labeled alternative in {@link MinINGParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar(MinINGParser.CharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link MinINGParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(MinINGParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link MinINGParser#conditionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(MinINGParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#comparisonOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOp(MinINGParser.ComparisonOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link MinINGParser#stringOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(MinINGParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionInWrite}
	 * labeled alternative in {@link MinINGParser#stringOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionInWrite(MinINGParser.ExpressionInWriteContext ctx);
}