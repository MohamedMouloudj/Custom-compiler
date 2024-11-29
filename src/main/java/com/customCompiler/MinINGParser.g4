parser grammar MinINGParser;

//@header{
//    package com.customCompiler.;
//}

options {tokenVocab=MinINGLexer;}

//prog: (decl | expression)+ EOF      # Program ;
// Entry point
prog
    : varGlobal declaration instruction EOF  #Program;

// VAR_GLOBAL block
varGlobal: VAR_GLOBAL LBRACE varDeclaration* RBRACE     #VariableGlobalSegment;

// DECLARATION block
declaration: DECLARATION LBRACE varDeclaration* RBRACE  #DeclarationSegment;

// INSTRUCTION block
instruction: INSTRUCTION LBRACE statement* RBRACE   #InstructionSegment;

//decl :  TYPE IDF (COMMA IDF)* SEMI
//     | CONST TYPE IDF RECEIVE (INT|FLOAT|CHAR) SEMI
//     ;
// Variable declaration
varDeclaration
    : TYPE IDF (COMMA IDF)* SEMI            #VariableDeclaration    // Simple variable declaration
    | TYPE IDF LBRACKET INT RBRACKET SEMI           #ArrayDeclaration   // Array declaration
    | CONST TYPE IDF RECEIVE (INT|FLOAT|CHAR) SEMI          #ConstDeclaration  // Constant declaration
    ;

// Statements
statement
    : assignment                               #AssignmentStatement    // Assignment statement
    | condition                                #ConditionStatement // IF statement
    | loop                                     #LoopStatement   // FOR loop
    | ioOperation                              #IOStatement // Input/Output operation
    ;

// Assignment
assignment: IDF RECEIVE expression SEMI     #AssignmentExpression
    ;

// IF statement
condition
    : IF LPAREN conditionExpr RPAREN LBRACE statement* RBRACE ( ELSE LBRACE statement* RBRACE )?   #ConditionalStatement
    ;

// FOR loop
loop
    : FOR LPAREN assignment COLON INT COLON IDF RPAREN LBRACE statement* RBRACE #LoopDefinition
    ;// TODO: check the assignment problem

// Input/Output operations
ioOperation
    : READ LPAREN IDF RPAREN SEMI   #ReadOperation
    | WRITE LPAREN (stringOrExpression (COMMA stringOrExpression)*)? RPAREN SEMI    #WriteOperation
    ;

// Expression
expression
    : term (ADD term)*  #Addition
    | term (SUB term)*  #Subtraction
    ;

term
    : factor (MUL factor)*  #Multiplication
    | factor (DIV factor)*  #Division
    ;

factor
    : LPAREN expression RPAREN  #Parenthesis
    | INT               #Integer
    | FLOAT             #Float
    | CHAR              #Char
    | IDF               #Variable
    ;


// Condition expression
conditionExpr
    : expression comparisonOp expression    #Comparison
    ;

comparisonOp
    : GREATER | GREATEREQUAL | LESS | LESSEQUAL | EQUAL | NOTEQUAL
    ;

// String or expression (for WRITE operations)
stringOrExpression
    : STRING_LITERAL    # StringLiteral
    | expression        # ExpressionInWrite
    ;
