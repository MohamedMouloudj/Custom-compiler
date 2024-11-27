parser grammar MinINGParser;

@header{
    package com.customCompiler;
}

options {tokenVocab=MinINGLexer;}

//prog: (decl | expression)+ EOF      # Program ;
// Entry point
program: varGlobal declaration instruction EOF;

// VAR_GLOBAL block
varGlobal: VAR_GLOBAL LBRACE varDeclaration* RBRACE;

// DECLARATION block
declaration: DECLARATION LBRACE varDeclaration* RBRACE;

// INSTRUCTION block
instruction: INSTRUCTION LBRACE statement* RBRACE;

//decl :  TYPE IDF (COMMA IDF)* SEMI
//     | CONST TYPE IDF RECEIVE (INT|FLOAT|CHAR) SEMI
//     ;
// Variable declaration
varDeclaration
    : TYPE IDF (COMMA IDF)* SEMI                            // Simple variable declaration
    | TYPE IDF LBRACKET INT RBRACKET SEMI      // Array declaration
    | CONST TYPE IDF RECEIVE (INT|FLOAT|CHAR) SEMI // Constant declaration
    ;

// Statements
statement
    : assignment                               // Assignment statement
    | condition                                // IF statement
    | loop                                     // FOR loop
    | ioOperation                              // Input/Output operation
    ;

// Assignment
assignment: IDF RECEIVE expression SEMI;

// IF statement
condition
    : IF LPAREN conditionExpr RPAREN LBRACE statement* RBRACE ( ELSE LBRACE statement* RBRACE )?;

// FOR loop
loop
    : FOR LPAREN assignment COLON INT COLON IDF RPAREN LBRACE statement* RBRACE; // TODO: check the assignment problem

// Input/Output operations
ioOperation
    : READ LPAREN IDF RPAREN SEMI
    | WRITE LPAREN (stringOrExpression (COMMA stringOrExpression)*)? RPAREN SEMI
    ;

// Expression
expression
    : term ((ADD | SUB) term)*
    ;

term
    : factor ((MUL | DIV) factor)*
    ;

factor
    : LPAREN expression RPAREN
    | INT
    | FLOAT
    | CHAR
    | IDF
    ;


// Condition expression
conditionExpr
    : expression comparisonOp expression
    ;

comparisonOp
    : GREATER | GREATEREQUAL | LESS | LESSEQUAL | EQUAL | NOTEQUAL
    ;

// String or expression (for WRITE operations)
stringOrExpression
    : STRING_LITERAL
    | expression
    ;
