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
