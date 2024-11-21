parser grammar MinINGParser;

@header{
    package com.customCompiler.generated;
}

options {tokenVocab=MinINGLexer;}

// logic and arithmetic 
expression: expression (MUL|DIV) expression
          | expression (ADD|SUB) expression
          | expression OR expression
          | expression AND expression
          | NOT expression
          | LPAREN expression RPAREN
          ;

// comparison
comparison: expression (GREATER|GREATEREQUAL|LESS|LESSEQUAL|EQUAL|NOTEQUAL) expression;


//declaration variable 
decl :  TYPE IDF (COMMA IDF)* SEMI
     | CONST TYPE IDF RECEIVE (INT|FLOAT|CHAR) SEMI
     ;


table_decl : TYPE IDF LBRACKET INT RBRACKET SEMI;
