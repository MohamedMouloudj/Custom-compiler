lexer grammar MinINGLexer;



VAR_GLOBAL: 'VAR_GLOBAL';
DECLARATION: 'DECLARATION';
INSTRUCTION: 'INSTRUCTION';
CONST: 'CONST';
TYPE: 'INTEGER' | 'FLOAT' | 'CHAR';
IF: 'IF';
ELSE: 'ELSE';
FOR: 'FOR';
READ: 'READ';
WRITE: 'WRITE';

// IDF: Identifier rule (max length: 8 characters)
IDF: UPPERCASE (LOWERCASE | DIGIT)? (LOWERCASE | DIGIT)? (LOWERCASE | DIGIT)? (LOWERCASE | DIGIT)? (LOWERCASE | DIGIT)? (LOWERCASE | DIGIT)? (LOWERCASE | DIGIT)?;

// Integer and Float rules with fragments
INT: DIGIT+ | '(' SIGN DIGIT+ ')';
FLOAT: DIGIT+ '.' DIGIT+ | '(' SIGN DIGIT+ '.' DIGIT+ ')';

// CHAR rule with fragment for valid characters
CHAR: '\'' CHAR_BODY '\'';

// Arithmetic and logic operators
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
AND: '&&';
OR: '||';
NOT: '!';

// Comparison operators
GREATER: '>';
GREATEREQUAL: '>=';
LESS: '<';
LESSEQUAL: '<=';
EQUAL: '==';
NOTEQUAL: '!=';

// Delimiters
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
LBRACKET: '['; // For array declaration
RBRACKET: ']'; // For array declaration
SEMI: ';';
COLON: ':';
COMMA: ',';

// Comments and space
COMMENT: '%%' ~[\r\n]* -> skip;
NEWLINE: [\n\r]+ -> skip;
SPACE: [ \t]+ -> skip;

// Assignment
RECEIVE: '=';

// rules for string literals (used in WRITE operations)
STRING_LITERAL: '"' ( ~["\r\n] | '\\"' )* '"';

// Fragments for reusable patterns
fragment LOWERCASE: [a-z];
fragment UPPERCASE: [A-Z];
fragment DIGIT: [0-9];
fragment SIGN: [+-];
fragment CHAR_BODY: ~[\u0027\r\n];

//@header{
//    package com.customCompiler.generated;
//}
//
//VAR_GLOBAL: 'VAR_GLOBAL';
//DECLARATION: 'DECLARATION';
//INSTRUCTION: 'INSTRUCTION';
//CONST: 'CONST';
//TYPE: 'INTEGER'|'FLOAT'|'CHAR';
//// IDF: [A-Z][a-z0-9]{0,7}; This does not work on ANTLR , quantifiers are not supported
//IDF: [A-Z] [a-z0-9]* [a-z0-9]? [a-z0-9]? [a-z0-9]? [a-z0-9]? [a-z0-9]? [a-z0-9]?;
//INT:[0-9]+ | '('[+-][0-9]+')'; //TODO: check the MAX and MIN value
//FLOAT: [0-9]+'.'[0-9]+ | '('[+-][0-9]+'.'[0-9]+')';
//CHAR : '\'' (~[\u0027\r\n]) '\'' ; //\u0027 matches the unicode for a single quote [ ' ]
//
////arithmetic and logic
//ADD: '+';
//SUB: '-';
//MUL: '*';
//DIV:'/';
//AND: '&&';
//OR: '||';
//NOT:'!';
//
////comarison
//GREATER : '>';
//GREATEREQUAL: '>=';
//LESS: '<';
//LESSEQUAL: '<=';
//EQUAL:'==';
//NOTEQUAL:'!=';
//
////delimiters
//LPAREN: '(';
//RPAREN: ')';
//LBRACE: '{';
//RBRACE: '}';
//LBRACKET: '[';//for the array declaration
//RBRACKET: ']';//for the array declaration
//SEMI: ';';
//COMMA: ',';
//
////comments and space
//COMMENT: '%%' ~[\r\n]* -> skip;
//NEWLINE: [\n\r]+ -> skip;
//SPACE: [ \t]+ -> skip;
//
////I dont know where i put it
//RECEIVE: '=';
