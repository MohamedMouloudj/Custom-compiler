// Generated from C:/Users/Ramzi/Desktop/ProjetCompile/Custom-compiler/src/main/java/com/customCompiler/MinINGParser.g4 by ANTLR 4.13.2
package com.customCompiler;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MinINGParser}.
 */
public interface MinINGParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Program}
	 * labeled alternative in {@link MinINGParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MinINGParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link MinINGParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MinINGParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableGlobalSegment}
	 * labeled alternative in {@link MinINGParser#varGlobal}.
	 * @param ctx the parse tree
	 */
	void enterVariableGlobalSegment(MinINGParser.VariableGlobalSegmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableGlobalSegment}
	 * labeled alternative in {@link MinINGParser#varGlobal}.
	 * @param ctx the parse tree
	 */
	void exitVariableGlobalSegment(MinINGParser.VariableGlobalSegmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclarationSegment}
	 * labeled alternative in {@link MinINGParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationSegment(MinINGParser.DeclarationSegmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclarationSegment}
	 * labeled alternative in {@link MinINGParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationSegment(MinINGParser.DeclarationSegmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstructionSegment}
	 * labeled alternative in {@link MinINGParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstructionSegment(MinINGParser.InstructionSegmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstructionSegment}
	 * labeled alternative in {@link MinINGParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstructionSegment(MinINGParser.InstructionSegmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableDeclaration}
	 * labeled alternative in {@link MinINGParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(MinINGParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableDeclaration}
	 * labeled alternative in {@link MinINGParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(MinINGParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayDeclaration}
	 * labeled alternative in {@link MinINGParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclaration(MinINGParser.ArrayDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayDeclaration}
	 * labeled alternative in {@link MinINGParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclaration(MinINGParser.ArrayDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstDeclaration}
	 * labeled alternative in {@link MinINGParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstDeclaration(MinINGParser.ConstDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstDeclaration}
	 * labeled alternative in {@link MinINGParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstDeclaration(MinINGParser.ConstDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#arrayList}.
	 * @param ctx the parse tree
	 */
	void enterArrayList(MinINGParser.ArrayListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#arrayList}.
	 * @param ctx the parse tree
	 */
	void exitArrayList(MinINGParser.ArrayListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void enterArrayDecl(MinINGParser.ArrayDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void exitArrayDecl(MinINGParser.ArrayDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentStatement}
	 * labeled alternative in {@link MinINGParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(MinINGParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentStatement}
	 * labeled alternative in {@link MinINGParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(MinINGParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionStatement}
	 * labeled alternative in {@link MinINGParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(MinINGParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionStatement}
	 * labeled alternative in {@link MinINGParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(MinINGParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionStatement}
	 * labeled alternative in {@link MinINGParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterConditionStatement(MinINGParser.ConditionStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionStatement}
	 * labeled alternative in {@link MinINGParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitConditionStatement(MinINGParser.ConditionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LoopStatement}
	 * labeled alternative in {@link MinINGParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(MinINGParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoopStatement}
	 * labeled alternative in {@link MinINGParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(MinINGParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IOStatement}
	 * labeled alternative in {@link MinINGParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIOStatement(MinINGParser.IOStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IOStatement}
	 * labeled alternative in {@link MinINGParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIOStatement(MinINGParser.IOStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentExpression}
	 * labeled alternative in {@link MinINGParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(MinINGParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentExpression}
	 * labeled alternative in {@link MinINGParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(MinINGParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayElementAssignment}
	 * labeled alternative in {@link MinINGParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterArrayElementAssignment(MinINGParser.ArrayElementAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayElementAssignment}
	 * labeled alternative in {@link MinINGParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitArrayElementAssignment(MinINGParser.ArrayElementAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionalStatement}
	 * labeled alternative in {@link MinINGParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterConditionalStatement(MinINGParser.ConditionalStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionalStatement}
	 * labeled alternative in {@link MinINGParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitConditionalStatement(MinINGParser.ConditionalStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LoopDefinition}
	 * labeled alternative in {@link MinINGParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoopDefinition(MinINGParser.LoopDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoopDefinition}
	 * labeled alternative in {@link MinINGParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoopDefinition(MinINGParser.LoopDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#loopAssignment}.
	 * @param ctx the parse tree
	 */
	void enterLoopAssignment(MinINGParser.LoopAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#loopAssignment}.
	 * @param ctx the parse tree
	 */
	void exitLoopAssignment(MinINGParser.LoopAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReadOperation}
	 * labeled alternative in {@link MinINGParser#ioOperation}.
	 * @param ctx the parse tree
	 */
	void enterReadOperation(MinINGParser.ReadOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReadOperation}
	 * labeled alternative in {@link MinINGParser#ioOperation}.
	 * @param ctx the parse tree
	 */
	void exitReadOperation(MinINGParser.ReadOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReadArrayOperation}
	 * labeled alternative in {@link MinINGParser#ioOperation}.
	 * @param ctx the parse tree
	 */
	void enterReadArrayOperation(MinINGParser.ReadArrayOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReadArrayOperation}
	 * labeled alternative in {@link MinINGParser#ioOperation}.
	 * @param ctx the parse tree
	 */
	void exitReadArrayOperation(MinINGParser.ReadArrayOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WriteOperation}
	 * labeled alternative in {@link MinINGParser#ioOperation}.
	 * @param ctx the parse tree
	 */
	void enterWriteOperation(MinINGParser.WriteOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WriteOperation}
	 * labeled alternative in {@link MinINGParser#ioOperation}.
	 * @param ctx the parse tree
	 */
	void exitWriteOperation(MinINGParser.WriteOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Substraction}
	 * labeled alternative in {@link MinINGParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubstraction(MinINGParser.SubstractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Substraction}
	 * labeled alternative in {@link MinINGParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubstraction(MinINGParser.SubstractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link MinINGParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddition(MinINGParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link MinINGParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddition(MinINGParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleTerm}
	 * labeled alternative in {@link MinINGParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTerm(MinINGParser.SimpleTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleTerm}
	 * labeled alternative in {@link MinINGParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTerm(MinINGParser.SimpleTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link MinINGParser#term}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(MinINGParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link MinINGParser#term}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(MinINGParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Division}
	 * labeled alternative in {@link MinINGParser#term}.
	 * @param ctx the parse tree
	 */
	void enterDivision(MinINGParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link MinINGParser#term}.
	 * @param ctx the parse tree
	 */
	void exitDivision(MinINGParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleOp}
	 * labeled alternative in {@link MinINGParser#term}.
	 * @param ctx the parse tree
	 */
	void enterSimpleOp(MinINGParser.SimpleOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleOp}
	 * labeled alternative in {@link MinINGParser#term}.
	 * @param ctx the parse tree
	 */
	void exitSimpleOp(MinINGParser.SimpleOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinINGParser#operation_gf}.
	 * @param ctx the parse tree
	 */
	void enterOperation_gf(MinINGParser.Operation_gfContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinINGParser#operation_gf}.
	 * @param ctx the parse tree
	 */
	void exitOperation_gf(MinINGParser.Operation_gfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link MinINGParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterInteger(MinINGParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link MinINGParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitInteger(MinINGParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Float}
	 * labeled alternative in {@link MinINGParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFloat(MinINGParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Float}
	 * labeled alternative in {@link MinINGParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFloat(MinINGParser.FloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Char}
	 * labeled alternative in {@link MinINGParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterChar(MinINGParser.CharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Char}
	 * labeled alternative in {@link MinINGParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitChar(MinINGParser.CharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link MinINGParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterVariable(MinINGParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link MinINGParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitVariable(MinINGParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayElement}
	 * labeled alternative in {@link MinINGParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterArrayElement(MinINGParser.ArrayElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayElement}
	 * labeled alternative in {@link MinINGParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitArrayElement(MinINGParser.ArrayElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesisCondition}
	 * labeled alternative in {@link MinINGParser#conditionExpr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisCondition(MinINGParser.ParenthesisConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesisCondition}
	 * labeled alternative in {@link MinINGParser#conditionExpr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisCondition(MinINGParser.ParenthesisConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link MinINGParser#conditionExpr}.
	 * @param ctx the parse tree
	 */
	void enterNegation(MinINGParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link MinINGParser#conditionExpr}.
	 * @param ctx the parse tree
	 */
	void exitNegation(MinINGParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link MinINGParser#conditionExpr}.
	 * @param ctx the parse tree
	 */
	void enterComparison(MinINGParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link MinINGParser#conditionExpr}.
	 * @param ctx the parse tree
	 */
	void exitComparison(MinINGParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrCondition}
	 * labeled alternative in {@link MinINGParser#conditionExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrCondition(MinINGParser.OrConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrCondition}
	 * labeled alternative in {@link MinINGParser#conditionExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrCondition(MinINGParser.OrConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndCondition}
	 * labeled alternative in {@link MinINGParser#conditionExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndCondition(MinINGParser.AndConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndCondition}
	 * labeled alternative in {@link MinINGParser#conditionExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndCondition(MinINGParser.AndConditionContext ctx);
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
	 * Enter a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link MinINGParser#stringOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(MinINGParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link MinINGParser#stringOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(MinINGParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionInWrite}
	 * labeled alternative in {@link MinINGParser#stringOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionInWrite(MinINGParser.ExpressionInWriteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionInWrite}
	 * labeled alternative in {@link MinINGParser#stringOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionInWrite(MinINGParser.ExpressionInWriteContext ctx);
}