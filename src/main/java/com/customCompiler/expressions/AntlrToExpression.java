package com.customCompiler.expressions;

import com.customCompiler.*;
import com.customCompiler.SymbolTable;
import com.customCompiler.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.*;


public class AntlrToExpression extends MinINGParserBaseVisitor<Expression> {

    private SymbolTable symbolTable; // store all the variables declared in the program
    private final List<String> semanticErrors;


    public AntlrToExpression(List<String> semanticErrors, SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        this.semanticErrors = semanticErrors;
    }
////////// Declarations //////////
    @Override
    public Expression visitVariableDeclaration(MinINGParser.VariableDeclarationContext ctx) {
        String type = ctx.TYPE().getText(); // Variable type
        int line = ctx.getStart().getLine(); // Line number
        int column = ctx.getStart().getCharPositionInLine() + 1; // Column number

        // List of identifiers
        List<TerminalNode> idfs = ctx.IDF();
        // List to store all variable declaration expressions
        List<VariableDeclarationExpression> variableDeclarations = new ArrayList<>();

        for (TerminalNode idf : idfs) {
            String varName = idf.getText();

            // Check for duplicate variables
            if (symbolTable.containsSymbol(varName)) {
                semanticErrors.add("Error: Duplicate variable declaration " + varName + " at " + line + ":" + column);
            } else {
//                symbolTable.addSymbol(varName, type);
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
        // If multiple variables, I should create a composite expression
        return new CompositeVariableDeclarationExpression(variableDeclarations);
    }

    @Override
    public Expression visitArrayDeclaration(MinINGParser.ArrayDeclarationContext ctx) {
        String type = ctx.TYPE().getText();
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine() + 1;
        List<ArrayDeclarationExpression> arrayDeclarations = new ArrayList<>();
        for (MinINGParser.ArrayDeclContext idf : ctx.arrayList().arrayDecl()) {
            String varName = idf.getText();
            if (symbolTable.containsSymbol(varName)) {
                semanticErrors.add("Error: Duplicate array declaration " + varName + " at " + line + ":" + column);
            } else {
                symbolTable.addSymbol(varName, new Symbol(Expression.ExpressionType.valueOf(type),null, Symbol.Scope.GLOBAL,false,0));
                int size = Integer.parseInt(idf.INT().getText());
                if (size <= 0) {
                    semanticErrors.add("Error: Array size must be greater than 0 at " + line + ":" + column);
                } else {
                    ArrayDeclarationExpression arrayDecl = new ArrayDeclarationExpression(type, varName, size);
                    arrayDeclarations.add(arrayDecl);
                }
            }
        }
        if (arrayDeclarations.isEmpty()) {
            return null;
        }
        if (arrayDeclarations.size() == 1) {
            return arrayDeclarations.getFirst();
        }
        return new CompositeArrayDeclarationExpression(arrayDeclarations);
    }

    @Override
    public Expression visitConstDeclaration(MinINGParser.ConstDeclarationContext ctx) {
        Expression.ExpressionType type = Expression.ExpressionType.valueOf(ctx.TYPE().getText());
        String constantName = ctx.IDF().getText();
        Expression value;
        if (type == Expression.ExpressionType.INTEGER) {
            value = new IntegerExpression(Integer.parseInt(ctx.INT().getText()));
        } else if (type == Expression.ExpressionType.FLOAT) {
            value = new FloatExpression(Float.parseFloat(ctx.FLOAT().getText()));
        } else if (type == Expression.ExpressionType.CHAR) {
            value = new CharExpression(ctx.CHAR().getText().charAt(0));
        } else {
            throw new RuntimeException("Invalid constant type");
        }
//        symbolTable.addSymbol(constantName, new Symbol(type, value.evaluate(symbolTable)));
        return new ConstantExpression(constantName,type,value);
    }

////////// Statements //////////
    /**
     * For explicit array element assignment
     * */
    @Override
    public Expression visitArrayElementAssignment(MinINGParser.ArrayElementAssignmentContext ctx) {
        String arrayName = ctx.IDF().getText();
        Object index = visit(ctx.expression(0)); // Get the index expression
        Expression value = visit(ctx.expression(1)); // Get the value expression
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine() + 1;

        // Check if the array exists and get its type and size
        if (symbolTable.containsSymbol(arrayName)) {
            Symbol arraySymbol = symbolTable.getSymbol(arrayName);
            int arraySize = arraySymbol.getSize();
            if (arraySize>0) {
                int indexValue = (int)((IntegerExpression) index).evaluate(symbolTable);

                // Check if the index is within bounds
                if (indexValue < arraySize) {
                    // Check if the type of the value matches the array type
                    if (arraySymbol.getType().equals(value.getType())) {
                        // Perform the assignment
//                        arraySymbol.setValue(indexValue, value);
                    } else {
                        semanticErrors.add("Error: Type mismatch in array assignment " + line + ":" + column);
                    }
                } else {
                    semanticErrors.add("Error: Array index out of bounds " + line + ":" + column);
                }
            } else {
                semanticErrors.add(arrayName + " is not an array");
            }
        } else {
            semanticErrors.add("Array not declared at " + line + ":" + column);
        }

        return null;
    }

    /**
     * For array element Read operation
     * */
    @Override
    public Expression visitReadArrayOperation(MinINGParser.ReadArrayOperationContext ctx) {
        String arrayName = ctx.IDF().getText();
        Object index = visit(ctx.expression()); // Get the index expression
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine() + 1;

        if (symbolTable.containsSymbol(arrayName)) {
            Symbol arraySymbol = symbolTable.getSymbol(arrayName);
            int arraySize = arraySymbol.getSize();
            if (arraySize>0) {
                int indexValue = (int)((IntegerExpression) index).evaluate(symbolTable);

                if (indexValue < arraySize) {
                    // bject inputValue = readInput(); //TODO: This method should read input from the user

                    // Check if the type of the input matches the array type
                    if (arraySymbol.getType().equals(Expression.ExpressionType.INTEGER)) {
//                        arraySymbol.setValue(indexValue, inputValue);
                    } else {
                        semanticErrors.add("Error: Type mismatch in array assignment " + line + ":" + column);
                    }
                } else {
                    semanticErrors.add("Error: Array index out of bounds " + line + ":" + column);
                }
            } else {
                semanticErrors.add("Error: " + arrayName + " is not an array");
            }
        } else {
            semanticErrors.add("Error: Array not declared at " + line + ":" + column);
        }

        return null;
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
        if(!symbolTable.containsSymbol(variableName)) {
            semanticErrors.add("Error: Variable " + variableName + " is not defined at line " + ctx.getStart().getLine() + " column " + ctx.getStart().getCharPositionInLine());

        }else{
            String variableType  = symbolTable.getType(variableName);

            Expression expressionValue = visit(ctx.expression());
            String expressionType = expressionValue.getType().toString();

            if(!Objects.equals(variableType, expressionType)){
                semanticErrors.add("Error : "+ variableName + " is type " + variableType + " not "+ expressionType + " at line " + ctx.getStart().getLine() + " column " + ctx.getStart().getCharPositionInLine() + 1);

            }
            return new AssignmentExpression(variableName,expressionValue);
        }
        return  null;
    }

    @Override
    public Expression visitConditionalStatement(MinINGParser.ConditionalStatementContext ctx) {
        Expression condition = visit(ctx.conditionExpr());
        if (!Objects.equals(condition.getType(), Expression.ExpressionType.BOOLEAN)) {
            semanticErrors.add("Error: Conditional expression must be of type boolean at line " + ctx.getStart().getLine() + " column " + ctx.getStart().getCharPositionInLine());
        }
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
//TODO : check how to select statement of if block and else block DekuDz : nadohoum ga3
        //return null ;
    }


    @Override
    public Expression visitLoopDefinition(MinINGParser.LoopDefinitionContext ctx) {

        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine() + 1;

        Expression initialization = visit(ctx.loopAssignment().expression());
        String loopVariable = ctx.loopAssignment().IDF().getText();
        if (!initialization.getType().equals(Expression.ExpressionType.INTEGER)||initialization.getType().equals(Expression.ExpressionType.FLOAT)) {
            semanticErrors.add("Error: Loop initialization must be an integer or float at " + line + ":" + column);
        }
        Expression step=visit(ctx.expression(1));
        if (!step.getType().equals(initialization.getType())) {
            semanticErrors.add("Error: Loop step must be of the same type as the initialization at " + line + ":" + column);
        }
        Expression rangeEnd = visit(ctx.expression().getLast());
        if (!rangeEnd.getType().equals(initialization.getType())) {
            semanticErrors.add("Error: Loop range end must be of the same type as the initialization at " + line + ":" + column);
        }

        List<Expression> statements = new ArrayList<>();
        for(MinINGParser.StatementContext statement : ctx.statement()){
            statements.add(visit(statement)); //TODO: store like this or evaluate immediately?
        }
        return new LoopExpression(initialization,step,rangeEnd,loopVariable,statements);
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
        if (!symbolTable.containsSymbol(variableName)) {
            semanticErrors.add("Error: Variable " + variableName + " not declared");
        }
        Expression readExpression = new ReadExpression(variableName);
        readExpression.evaluate(symbolTable);
        return readExpression;
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
        if(ctx.expression() != null) {
            return visit(ctx.expression());
        }else{
            semanticErrors.add("Error: Missing or invalid expression inside parentheses at line "
                    + ctx.getStart().getLine() + ", column " + ctx.getStart().getCharPositionInLine());
            return null;
        }

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
        if(!symbolTable.containsSymbol(variableName)){
            semanticErrors.add("Error: Variable " + variableName + " not declared at line " +  + ctx.getStart().getLine() + ", column " + ctx.getStart().getCharPositionInLine());
        }else{
            return new VariableExpression(variableName,symbolTable);
        }
        return null;
    }

    @Override
    public Expression visitComparison(MinINGParser.ComparisonContext ctx) {
        // Evaluate the left and right expressions
        Expression left = visit(ctx.expression(0));
        Expression right = visit(ctx.expression(1));
        String op = visit(ctx.comparisonOp()).toString(); //can be .evaluate()
        isCompatibleForComparison c = new isCompatibleForComparison(left, right);
        if(!c.checkCompatibility()){
            semanticErrors.add("Error: Cannot apply operator '" + op + "' to types "
                    + left.getType() + " and " + right.getType()
                    + " at line " + ctx.getStart().getLine()
                    + ", column " + ctx.getStart().getCharPositionInLine());        }

        // Wrap the comparison logic into a ComparisonExpression object
        return new ComparisonExpression(left, right, op);
    }

    @Override
    public Expression visitComparisonOp(MinINGParser.ComparisonOpContext ctx) {
        String op = null;
        if (ctx.GREATER() != null) {
            op = ">";
        } else if (ctx.GREATEREQUAL() != null) {
            op = ">=";
        } else if (ctx.LESS() != null) {
            op = "<";
        } else if (ctx.LESSEQUAL() != null) {
            op = "<=";
        } else if (ctx.EQUAL() != null) {
            op = "==";
        } else if (ctx.NOTEQUAL() != null) {
            op = "!=";
        }else{
            semanticErrors.add("Error : Unknown or unsupported operator at line " + ctx.getStart().getLine() + ", column " + ctx.getStart().getCharPositionInLine());
        }
        // I added the LiteralExpression class to store comparison operators as strings and use it in comparisonExpression
        return new LiteralExpression(op);
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