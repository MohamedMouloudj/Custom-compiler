package com.customCompiler.expressions.core;

import com.customCompiler.*;
import com.customCompiler.SymbolTable;
import com.customCompiler.Symbol;
import com.customCompiler.expressions.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AntlrToExpression extends MinINGParserBaseVisitor<Expression> {

    private SymbolTable symbolTable; // store all the variables declared in the program
    private final List<String> semanticErrors;


    public AntlrToExpression(List<String> semanticErrors, SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        this.semanticErrors = semanticErrors;
    }
////////// Declarations //////////

    @Override
    public Expression visitVariableGlobalSegment(MinINGParser.VariableGlobalSegmentContext ctx) {
        List<Expression> declarations=new ArrayList<>();
       for (int i=0;i<ctx.varDeclaration().size();i++) {
           declarations.add(visit(ctx.varDeclaration(i)));
        }
        return new VariableGlobalExpression(declarations);
    }

    @Override
    public Expression visitDeclarationSegment(MinINGParser.DeclarationSegmentContext ctx) {
        List<Expression> declarations=new ArrayList<>();
        for (int i=0;i<ctx.varDeclaration().size();i++) {
            declarations.add(visit(ctx.varDeclaration(i)));
        }
        return new DeclarationExpression(declarations);
    }

    @Override
    public Expression visitVariableDeclaration(MinINGParser.VariableDeclarationContext ctx) {
        Expression.ExpressionType type = Expression.ExpressionType.valueOf(ctx.TYPE().getText());
        int line = ctx.getStart().getLine(); // Line number


        // List of identifiers
        List<TerminalNode> idfs = ctx.IDF();
        // List to store all variable declaration expressions
        List<VariableDeclarationExpression> variableDeclarations = new ArrayList<>();

        for (TerminalNode idf : idfs) {
            String varName = idf.getText();

            // Check for duplicate variables
            if (symbolTable.containsSymbol(varName)) {
                semanticErrors.add("Error: Duplicate variable declaration " + varName + " at " + line );
            } else {
                symbolTable.addSymbol(varName, new Symbol(type, null,Symbol.Scope.GLOBAL,false,0));
                // Create a variable declaration expression for each variable
                VariableDeclarationExpression varDecl = new VariableDeclarationExpression(type.toString(), varName);
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
        List<ArrayDeclarationExpression> arrayDeclarations = new ArrayList<>();
        for (MinINGParser.ArrayDeclContext idf : ctx.arrayList().arrayDecl()) {
            String varName = idf.IDF().getText();
            if (symbolTable.containsSymbol(varName)) {
                semanticErrors.add("Error: Duplicate array declaration " + varName + " at " + line );
            } else {
                int size = Integer.parseInt(idf.INT().getText());
                ArrayList<Object> array = new ArrayList<>();
                if(!Expression.ExpressionType.valueOf(type).equals(Expression.ExpressionType.INTEGER)&&!Expression.ExpressionType.valueOf(type).equals(Expression.ExpressionType.FLOAT)&&!Expression.ExpressionType.valueOf(type).equals(Expression.ExpressionType.CHAR)){
                    semanticErrors.add("Error: Invalid array type at " + line);
                }
                symbolTable.addSymbol(varName, new Symbol(Expression.ExpressionType.valueOf(type),array, Symbol.Scope.GLOBAL,false,size));
                if (size <= 0) {
                    semanticErrors.add("Error: Array size must be greater than 0 at " + line );
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
            value = new CharExpression(ctx.CHAR().getText());
        } else {
            semanticErrors.add("Error :  Invalid constant type at line "+ ctx.getStart().getLine() );
            value = null;
        }
        if(symbolTable.containsSymbol(constantName)){
            semanticErrors.add("Error : Duplicate declaration " + constantName + " at " + ctx.getStart().getLine() );
        }else{
            symbolTable.addSymbol(constantName, new Symbol(type,value!=null?value.evaluate(symbolTable):null,Symbol.Scope.GLOBAL,true,0));
        }
        return new ConstantExpression(constantName,type,value);
    }

////////// Statements //////////


    @Override
    public Expression visitInstructionSegment(MinINGParser.InstructionSegmentContext ctx) {
        List<Expression> instructions = new ArrayList<>();
        for (int i=0;i<ctx.statement().size();i++){
            instructions.add(visit(ctx.statement(i)));
        }
        return new InstructionExpression(instructions);
    }

    /**
     * For explicit array element assignment
     * */
    @Override
    public Expression visitArrayElementAssignment(MinINGParser.ArrayElementAssignmentContext ctx) {
        String arrayName = ctx.IDF().getText();
        Object index = visit(ctx.expression(0)); // Get the index expression
        Expression value = visit(ctx.expression(1)); // Get the value expression
        int line = ctx.getStart().getLine();

        // Check if the array exists and get its type and size
        if (symbolTable.containsSymbol(arrayName)) {
            Symbol arraySymbol = symbolTable.getSymbol(arrayName);
            int arraySize = arraySymbol.getSize();
            if (arraySize>0) {
                int indexValue = (int)((IntegerExpression) index).evaluate(symbolTable);
                // Check if the index is within bounds
                if (indexValue < arraySize) {
                    // Check if the type of the value matches the array type
                    if (!arraySymbol.getType().equals(value.getType())) {
                        semanticErrors.add("Error: Type mismatch in array assignment at line " + line);
                    }
                } else {
                    semanticErrors.add("Error: Array index out of bounds at " + line);
                }

            } else {
                semanticErrors.add(arrayName + " is not an array");
            }
        } else {
            semanticErrors.add("Array not declared at " + line );
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
                        semanticErrors.add("Error: Type mismatch in array assignment " + line);
                    }
                } else {
                    semanticErrors.add("Error: Array index out of bounds " + line );
                }
            } else {
                semanticErrors.add("Error: " + arrayName + " is not an array");
            }
        } else {
            semanticErrors.add("Error: Array not declared at " + line );
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
            semanticErrors.add("Error: Variable " + variableName + " is not defined at line " + ctx.getStart().getLine() );

        }else{
            String variableType  = symbolTable.getType(variableName);

            Expression expressionValue = visit(ctx.expression());
            String expressionType = expressionValue.getType().toString();

            if(!Objects.equals(variableType, expressionType)){
                semanticErrors.add("Error : "+ variableName + " is type " + variableType + " not "+ expressionType + " at line " + ctx.getStart().getLine() );

            }
            return new AssignmentExpression(variableName,expressionValue);
        }
        return  null;
    }

    @Override
    public Expression visitConditionalStatement(MinINGParser.ConditionalStatementContext ctx) {
//        System.out.println("\nFields:");
//        for (Field field : ctx.conditionExpr().getClass().getDeclaredFields()) {
//            field.setAccessible(true); // Access private fields
//            System.out.println("  " + field.getName());
//        }
//
//        System.out.println("\nMethods:");
//        for (Method method : ctx.conditionExpr().getClass().getDeclaredMethods()) {
//            System.out.println("  " + method.getName());
//        }
        Expression condition = visit(ctx.conditionExpr());
        if (!Objects.equals(condition.getType(), Expression.ExpressionType.BOOLEAN)) {
            semanticErrors.add("Error: Conditional expression must be of type boolean at line " + ctx.getStart().getLine());
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
        return new IfBlocksExpression(condition,ifStatements,elseStatements);

    }


    @Override
    public Expression visitLoopDefinition(MinINGParser.LoopDefinitionContext ctx) {

        int line = ctx.getStart().getLine();
        if(ctx.loopAssignment().RECEIVE() != null) {
            Expression initialization = visit(ctx.loopAssignment().expression());

            String loopVariable = ctx.loopAssignment().IDF().getText();
            if (!initialization.getType().equals(Expression.ExpressionType.INTEGER)||initialization.getType().equals(Expression.ExpressionType.FLOAT)) {
                semanticErrors.add("Error: Loop initialization must be an integer or float at " + line );
            }


            Expression step=visit(ctx.expression(1));
            if(step != null){
                if (!step.getType().equals(initialization.getType())) {
                    semanticErrors.add("Error: Loop step must be of the same type as the initialization at " + line  );
                }
            }else{
                semanticErrors.add("Error: Loop step must be an integer or float at " + line );
            }

            Expression rangeEnd = visit(ctx.expression().getLast());
            if(rangeEnd != null){
                if (!rangeEnd.getType().equals(initialization.getType())) {
                    semanticErrors.add("Error: Loop range end must be of the same type as the initialization at " + line );
                }
            }else{
                semanticErrors.add("Error: Loop range end must be an integer or float at " + line );
            }


            List<Expression> statements = new ArrayList<>();
            for(MinINGParser.StatementContext statement : ctx.statement()){
                statements.add(visit(statement)); //TODO: store like this or evaluate immediately?
            }
            return new LoopExpression(initialization,step,rangeEnd,loopVariable,statements);
        }else{
            semanticErrors.add("Error: Assignment is required at line "+ line);
            return null;
            //TODO : check if return null
        }

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

//    @Override
//    public Expression visitAddition(MinINGParser.AdditionContext ctx) {
//        Expression result = visit(ctx.term());
//        for(int i = 0;i<ctx.expression().size();i++){
//            Expression right = visit(ctx.expression(i));
//            System.out.println("visit add" + result + " " + right);
//            isCompatibleForComparison c = new isCompatibleForComparison(right,result);
//            if(!c.checkCompatibilityArithmetic()){
//                semanticErrors.add("Error : Addition operation between incompatible types " + right.getType() + " and " + result.getType() + " at line " + ctx.getStart().getLine() );
//            }
//            result = new AdditionExpression(result, right);
//        }
//        return result;
//    }
//
//    @Override
//    public Expression visitSubtraction(MinINGParser.SubtractionContext ctx) {
//        System.out.println("salam");
//        Expression result = visit(ctx.term());
//        for(int i = 0;i<ctx.expression().size();i++){
//            Expression right = visit(ctx.expression(i));
//            isCompatibleForComparison c = new isCompatibleForComparison(right,result);
//            if(!c.checkCompatibilityArithmetic()){
//                semanticErrors.add("Error : Subtraction operation between incompatible types " + right.getType() + " and " + result.getType() + " at line " + ctx.getStart().getLine() );
//            }
//            result = new SubtractionExpression(result, right);
//        }
//        return result;
//    }
//
//    @Override
//    public Expression visitMultiplication(MinINGParser.MultiplicationContext ctx) {
//        Expression result = visit(ctx.factor());
//        for (int i = 0; i < ctx.expression().size(); i++) {
//            Expression right = visit(ctx.expression(i));
//            isCompatibleForComparison c = new isCompatibleForComparison(right,result);
//            if(!c.checkCompatibilityArithmetic()){
//                semanticErrors.add("Error : Multiplication operation between incompatible types " + right.getType() + " and " + result.getType() + " at line " + ctx.getStart().getLine() );
//            }
//            result = new MultiplicationExpression(result, right);
//        }
//        return result;
//    }
//
//
//    @Override
//    public Expression visitDivision(MinINGParser.DivisionContext ctx) {
//        Expression result = visit(ctx.factor());
//        for (int i = 0; i < ctx.expression().size(); i++) {
//            Expression right = visit(ctx.expression(i));
//            isCompatibleForComparison c = new isCompatibleForComparison(right,result);
//            if(!c.checkCompatibilityArithmetic()){
//                semanticErrors.add("Error : Division operation between incompatible types " + result.getType() + " and " + right.getType() + " at line " + ctx.getStart().getLine() );
//            }
//            if(right instanceof IntegerExpression){
//                if(((Integer)right.evaluate(symbolTable)) == 0){
//                    semanticErrors.add("Error : Division by zero impossible at line " + ctx.getStart().getLine() );
//                }
//            }
//            //TODO :
//            result = new DivisionExpression(result, right);
//        }
//       return result;
//    }

//    @Override
//    public Expression visitParenthesis(MinINGParser.ParenthesisContext ctx) {
//        if(ctx.expression() != null) {
//            return new ParenthesisExpression(visit(ctx.expression()));
//        }else{
//            semanticErrors.add("Error: Missing or invalid expression inside parentheses at line "
//                    + ctx.getStart().getLine() );
//
//            return new ParenthesisExpression(null);
//        }
//
//    }

    @Override
    public Expression visitInteger(MinINGParser.IntegerContext ctx) {
        String integer = ctx.INT().getText();
        // To remove () from signed integer
        Pattern pattern = Pattern.compile("[+-]");
        Matcher matcher = pattern.matcher(integer);
        int value = Integer.parseInt(matcher.find() ? integer.substring(1,integer.length()-1) : integer);
        return new IntegerExpression(value);
    }

    @Override
    public Expression visitFloat(MinINGParser.FloatContext ctx) {
        String floatString = ctx.FLOAT().getText();
        Pattern pattern = Pattern.compile("[+-]");
        Matcher matcher = pattern.matcher(floatString);
        double value = new BigDecimal(matcher.find() ? floatString.substring(1,floatString.length()-1) : floatString).doubleValue();
        return new FloatExpression(value);
    }

    @Override
    public Expression visitChar(MinINGParser.CharContext ctx) {
        String valueString = ctx.CHAR().getText();
        return new CharExpression(valueString);
    }

    @Override
    public Expression visitVariable(MinINGParser.VariableContext ctx) {
        String variableName = ctx.IDF().getText();
        if(!symbolTable.containsSymbol(variableName)){
            semanticErrors.add("Error: Variable " + variableName + " not declared at line " +  + ctx.getStart().getLine());
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
        String op = ctx.comparisonOp().getText();
        isCompatibleForComparison c = new isCompatibleForComparison(left, right);
        if(!c.checkCompatibilityComparision()){
            semanticErrors.add("Error: Cannot apply operator '" + op + "' to types "
                    + left.getType() + " and " + right.getType()
                    + " at line " + ctx.getStart().getLine());        }

        // Wrap the comparison logic into a ComparisonExpression object
        return new ComparisonExpression(left, right, op);
    }

    @Override
    public Expression visitNegation(MinINGParser.NegationContext ctx) {
        // Visit the conditionExpr inside NOT
        Expression expr = visit(ctx.conditionExpr());
        return new NotLogicalExpression(expr);
    }

    @Override
    public Expression visitOrCondition(MinINGParser.OrConditionContext ctx) {
        // Left and right OR conditions
        Expression left = visit(ctx.conditionExpr(0));
        Expression right = visit(ctx.conditionExpr(1));

        return new OrLogicalExpression(left, right);
    }

    @Override
    public Expression visitAndCondition(MinINGParser.AndConditionContext ctx) {
        // Left and right AND conditions
        Expression left = visit(ctx.conditionExpr(0));
        Expression right = visit(ctx.conditionExpr(1));

        return new AndLogicalExpression(left, right);
    }

    @Override
    public Expression visitParenthesisCondition(MinINGParser.ParenthesisConditionContext ctx) {
        // Visit the inner conditionExpr
        return visit(ctx.conditionExpr());
    }
// Useless I guess
//    @Override
//    public Expression visitComparisonOp(MinINGParser.ComparisonOpContext ctx) {
//        return null;
//    }

    @Override
    public Expression visitStringLiteral(MinINGParser.StringLiteralContext ctx) {
        String value = ctx.STRING_LITERAL().getText();
        value = value.substring(1, value.length()-1);
        return new StringExpression(value);
    }

    @Override
    public Expression visitArrayElement(MinINGParser.ArrayElementContext ctx) {
        String arrayName = ctx.IDF().getText();
        Object index = visit(ctx.expression());
        int line = ctx.getStart().getLine();

        if (symbolTable.containsSymbol(arrayName)) {
            Symbol arraySymbol = symbolTable.getSymbol(arrayName);
            int arraySize = arraySymbol.getSize();
            if (arraySize>0) {
                int indexValue = (int)((IntegerExpression) index).evaluate(symbolTable);
                System.out.println("index value array element"+ indexValue);

                if (indexValue < arraySize) {
                    return new ArrayElementExpression(arrayName, indexValue, symbolTable);
                } else {
                    semanticErrors.add("Error: Array index out of bounds at " + line );
                }
            } else {
                semanticErrors.add("Error: " + arrayName + " is not an array");
            }
        } else {
            semanticErrors.add("Error: Array not declared at " + line);
        }

        return null;
    }

    @Override
    public Expression visitExpressionInWrite(MinINGParser.ExpressionInWriteContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Expression visitSubstraction(MinINGParser.SubstractionContext ctx) {
        Expression left = visit(ctx.expression());
        Expression result = left;
        Expression right = visit(ctx.term());
        isCompatibleForComparison c = new isCompatibleForComparison(right,left);
        if(!c.checkCompatibilityArithmetic()){
            semanticErrors.add("Error : Addition operation between incompatible types " + right.getType() + " and " + left.getType() + " at line " + ctx.getStart().getLine() );
        }
        result = new SubtractionExpression(left, right);
        System.out.println("left in Sub " + result + "Sub " + right);

        return result;
    }

    @Override
    public Expression visitAddition(MinINGParser.AdditionContext ctx) {
        Expression left = visit(ctx.expression());
        Expression result = left;
        Expression right = visit(ctx.term());
        isCompatibleForComparison c = new isCompatibleForComparison(right,left);
        if(!c.checkCompatibilityArithmetic()){
            semanticErrors.add("Error : Substraction operation between incompatible types " + right.getType() + " and " + left.getType() + " at line " + ctx.getStart().getLine() );
        }
        result = new AdditionExpression(left, right);
        System.out.println("left in addition " + result + "right " + right);
        return result;
    }

    @Override
    public Expression visitSimpleTerm(MinINGParser.SimpleTermContext ctx) {
        return visit(ctx.term());
    }

    @Override
    public Expression visitMultiplication(MinINGParser.MultiplicationContext ctx) {
        Expression left = visit(ctx.term());
        Expression result = left;
        Expression right = visit(ctx.operation_gf());
        isCompatibleForComparison c = new isCompatibleForComparison(right,result);
        if(!c.checkCompatibilityArithmetic()){
            semanticErrors.add("Error : Multiplication operation between incompatible types " + right.getType() + " and " + result.getType() + " at line " + ctx.getStart().getLine() );
        }

        result = new MultiplicationExpression(result, right);
        System.out.println("left in mul " + left + " righ in mu " + right);
        return result;
    }

    @Override
    public Expression visitDivision(MinINGParser.DivisionContext ctx) {
        Expression left = visit(ctx.term());
        Expression result = left;

        Expression right = visit(ctx.operation_gf());
        isCompatibleForComparison c = new isCompatibleForComparison(right,left);
        if(!c.checkCompatibilityArithmetic()){
            semanticErrors.add("Error : Division operation between incompatible types " + left.getType() + " and " + right.getType() + " at line " + ctx.getStart().getLine() );
        }
        if(right instanceof IntegerExpression){
            if(((Integer)right.evaluate(symbolTable)) == 0){
                semanticErrors.add("Error : Division by zero impossible at line " + ctx.getStart().getLine() );
            }
        }
        result = new DivisionExpression(left, right);
        System.out.println("left in division " + left + " right in division " + right);
       return result;
    }

    @Override
    public Expression visitSimpleOp(MinINGParser.SimpleOpContext ctx) {

        return visit(ctx.operation_gf());
    }


    @Override
    public Expression visitOperation_gf(MinINGParser.Operation_gfContext ctx) {
        if(ctx.expression() != null){
            return visit(ctx.expression());
        }else if(ctx.factor() != null){
            return visit(ctx.factor());
        }else{
            return visit(ctx.operation_gf());
        }
    }
}