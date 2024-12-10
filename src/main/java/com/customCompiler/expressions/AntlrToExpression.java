package com.customCompiler.expressions;

import com.customCompiler.*;
import org.antlr.v4.runtime.atn.ATNConfig;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;


public class AntlrToExpression extends MinINGParserBaseVisitor<Expression> {
    private  SymbolTable symbolTable; // store all the variables declared in the program
    private final List<String> semanticErrors;


    public AntlrToExpression(List<String> semanticErrors) {
        ArrayList variables = new ArrayList<>();
        this.semanticErrors = semanticErrors;
    }

    @Override
    public Expression visitVariableGlobalSegment(MinINGParser.VariableGlobalSegmentContext ctx) {
        List<Expression> globalVariables = new ArrayList<>();

        for(MinINGParser.VarDeclarationContext var : ctx.varDeclaration()){
            Expression varDeclaration = visit(var);
            if(varDeclaration != null){
                globalVariables.add(varDeclaration);
            }
        }
        return new GlobalVariablesExpression(globalVariables);
    }

    @Override
    public Expression visitDeclarationSegment(MinINGParser.DeclarationSegmentContext ctx) {
        List<Expression> declarations = new ArrayList<>();

        for (MinINGParser.VarDeclarationContext varCtx : ctx.varDeclaration()) {
            Expression declaration = visit(varCtx);
            if (declaration != null) {
                declarations.add(declaration);
            }
        }

        return new DeclarationsExpression(declarations);
    }

    @Override
    public Expression visitInstructionSegment(MinINGParser.InstructionSegmentContext ctx) {
        List<Expression> instructions = new ArrayList<>();

        for (MinINGParser.StatementContext stmtCtx : ctx.statement()) {
            Expression statement = visit(stmtCtx);
            if (statement != null) {
                instructions.add(statement);
            }
        }

        return new InstructionsExpression(instructions);
    }

    @Override
    public Expression visitVariableDeclaration(MinINGParser.VariableDeclarationContext ctx) {
        String type = ctx.TYPE().getText(); // Variable type
        int line = ctx.getStart().getLine(); // Line number
        int column = ctx.getStart().getCharPositionInLine() + 1; // Column number

        // List of identifiers
        List<TerminalNode> idfs = ctx.IDF();

        // Set to track declared variable names
        Set<String> declaredVariables = new HashSet<>();

        // List to store all variable declaration expressions
        List<VariableDeclarationExpression> variableDeclarations = new ArrayList<>();

        for (TerminalNode idf : idfs) {
            String varName = idf.getText();

            // Check for duplicate variable declarations
            if (declaredVariables.contains(varName)) {
                semanticErrors.add("Error: Duplicate variable declaration '" + varName + "' at " + line + ":" + column);
            } else {
                declaredVariables.add(varName);
                VariableDeclarationExpression varDecl = new VariableDeclarationExpression(type, varName);
                variableDeclarations.add(varDecl);
            }
        }
        if (variableDeclarations.isEmpty()) {
            return null;
        }
        if (variableDeclarations.size() == 1) {
            return variableDeclarations.getFirst();
        }
        return new CompositeVariableDeclarationExpression(variableDeclarations);
    }

    @Override
    public Expression visitArrayDeclaration(MinINGParser.ArrayDeclarationContext ctx) {
        String type = ctx.TYPE().getText();
        String arrayName = ctx.IDF().getText();
        int size = Integer.parseInt(ctx.INT().getText());
        return new ArrayDeclarationExpression(type,arrayName,size);
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


        return new ConstantExpression(constantName,type,value);
    }

    @Override
    public Expression visitAssignmentStatement(MinINGParser.AssignmentStatementContext ctx) {
        return visit(ctx.assignment());
    }

    @Override
    public Expression visitConditionStatement(MinINGParser.ConditionStatementContext ctx) {
        return visit(ctx.condition());
    }

    @Override
    public Expression visitLoopStatement(MinINGParser.LoopStatementContext ctx) {
        return visit(ctx.loop());
    }

    @Override
    public Expression visitIOStatement(MinINGParser.IOStatementContext ctx) {
        return visit(ctx.ioOperation());
    }

    @Override
    public Expression visitAssignmentExpression(MinINGParser.AssignmentExpressionContext ctx) {
        String variableName = ctx.IDF().getText();
        Expression expressionValue = visit(ctx.expression());
        return new AssignmentExpression(variableName,expressionValue);
    }

    @Override
    public Expression visitConditionalStatement(MinINGParser.ConditionalStatementContext ctx) {
        Expression condition = visit(ctx.conditionExpr());
        List<Expression> ifStatements = new ArrayList<>();
        for(MinINGParser.StatementContext statement : ctx.statement()){
            ifStatements.add(visit(statement));
        }
        List<Expression> elseStatements = new ArrayList<>();
        if (ctx.ELSE() != null) {
            for (MinINGParser.StatementContext statement : ctx.statement()) {
                elseStatements.add(visit(statement));
            }
        }
        return new ConditionExpression(condition,ifStatements,elseStatements);
//TODO : check how to select statment of if block and else block
    }

    @Override
    public Expression visitLoopDefinition(MinINGParser.LoopDefinitionContext ctx) {
        Expression initialization = visit(ctx.assignment());
        int rangeEnd = Integer.parseInt(ctx.INT().getText());
        String loopVariable = ctx.IDF().getText();
        List<Expression> statements = new ArrayList<>();
        for(MinINGParser.StatementContext statement : ctx.statement()){
            statements.add(visit(statement));
        }
        return new LoopExpression(initialization,rangeEnd,loopVariable,statements,1);
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
        int value = Integer.parseInt(ctx.INT().getText());
        return new IntegerExpression(value);
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
        int line = ctx.getStart().getLine(); // Line number
        int column = ctx.getStart().getCharPositionInLine() + 1; // Column number
        if (ctx.GREATER() != null) {
            // Handle the 'greater than' operator
            return new GreaterThanExpression();
        } else if (ctx.GREATEREQUAL() != null) {
            // Handle the 'greater than or equal to' operator
            return new GreaterThanOrEqualExpression();
        } else if (ctx.LESS() != null) {
            // Handle the 'less than' operator
            return new LessThanExpression();
        } else if (ctx.LESSEQUAL() != null) {
            // Handle the 'less than or equal to' operator
            return new LessThanOrEqualExpression();
        } else if (ctx.EQUAL() != null) {
            // Handle the 'equal to' operator
            return new EqualExpression();
        } else if (ctx.NOTEQUAL() != null) {
            // Handle the 'not equal to' operator
            return new NotEqualExpression();
        }else {
            semanticErrors.add("Error: Unknown comparison operator at " + line + ":" + column);
            return null;
        }
    }

    @Override
    public Expression visitStringLiteral(MinINGParser.StringLiteralContext ctx) {
        String value = ctx.STRING_LITERAL().getText();
        value = value.substring(1, value.length()-1);
        return new StringExpression(value);
    }

    @Override
    public Expression visitExpressionInWrite(MinINGParser.ExpressionInWriteContext ctx) {
        return visit(ctx.expression());
    }
}
