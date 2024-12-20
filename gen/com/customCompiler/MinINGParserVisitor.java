// Generated from D:/University/2024-09_Semester-5/Compilator-project/CustomCompiler/src/main/java/com/customCompiler/MinINGParser.g4 by ANTLR 4.13.2
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
	 * Visit a parse tree produced by {@link MinINGParser#arrayList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayList(MinINGParser.ArrayListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#arrayDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDecl(MinINGParser.ArrayDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentStatement}
	 * labeled alternative in {@link MinINGParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(MinINGParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionStatement}
	 * labeled alternative in {@link MinINGParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(MinINGParser.ExpressionStatementContext ctx);
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
	 * Visit a parse tree produced by the {@code ArrayElementAssignment}
	 * labeled alternative in {@link MinINGParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElementAssignment(MinINGParser.ArrayElementAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionalStatement}
	 * labeled alternative in {@link MinINGParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalStatement(MinINGParser.ConditionalStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#ifstatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstatements(MinINGParser.IfstatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#elsestatments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsestatments(MinINGParser.ElsestatmentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopDefinition}
	 * labeled alternative in {@link MinINGParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopDefinition(MinINGParser.LoopDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#loopAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopAssignment(MinINGParser.LoopAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReadOperation}
	 * labeled alternative in {@link MinINGParser#ioOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadOperation(MinINGParser.ReadOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReadArrayOperation}
	 * labeled alternative in {@link MinINGParser#ioOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadArrayOperation(MinINGParser.ReadArrayOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WriteOperation}
	 * labeled alternative in {@link MinINGParser#ioOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteOperation(MinINGParser.WriteOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Substraction}
	 * labeled alternative in {@link MinINGParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstraction(MinINGParser.SubstractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link MinINGParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(MinINGParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleTerm}
	 * labeled alternative in {@link MinINGParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTerm(MinINGParser.SimpleTermContext ctx);
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
	 * Visit a parse tree produced by the {@code SimpleOp}
	 * labeled alternative in {@link MinINGParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleOp(MinINGParser.SimpleOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinINGParser#operation_gf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation_gf(MinINGParser.Operation_gfContext ctx);
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
	 * Visit a parse tree produced by the {@code ArrayElement}
	 * labeled alternative in {@link MinINGParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElement(MinINGParser.ArrayElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesisCondition}
	 * labeled alternative in {@link MinINGParser#conditionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisCondition(MinINGParser.ParenthesisConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link MinINGParser#conditionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(MinINGParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link MinINGParser#conditionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(MinINGParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrCondition}
	 * labeled alternative in {@link MinINGParser#conditionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrCondition(MinINGParser.OrConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndCondition}
	 * labeled alternative in {@link MinINGParser#conditionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndCondition(MinINGParser.AndConditionContext ctx);
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