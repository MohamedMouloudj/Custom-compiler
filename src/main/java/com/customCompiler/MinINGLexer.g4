//lexical analysis (token definition)

lexer grammar MinINGLexer;

VAR_GLOBAL: 'VAR_GLOBAL';
DECLARATION: 'DECLARATION';
INSTRUCTION: 'INSTRUCTION';
CONST: 'CONST';
TYPE: 'INTEGER'|'FLOAT'|'CHAR';
IDF: [A-Z][a-z0-9]*{0,7};//to revise later for the lenght
INT:[0-9]+ | '('[+-][0-9]+')'; //TODO: check the MAX and MIN value
FLOAT: [0-9]+'.'[0-9]+ | '('[+-][0-9]+'.'[0-9]+')';
CHAR : '\'' (~[\u0027\r\n]) '\'' ; //\u0027 matches the unicode for a single quote [ ' ]

//arithmetic and logic
ADD: '+';
SUB: '-';
MUL: '*';
DIV:'/';
AND: '&&';
OR: '||';
NOT:'!';

//comarison
GREATER : '>';
GREATEREQUAL: '>=';
LESSER: '<';
LESSEREQUAL: '<=';
EQUAL:'==';
NOTEQUAL:'!=';

//delimiters
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
LBRACKET: '[';//for the array declaration
RBRACKET: ']';//for the array declaration
SEMI: ';';
COMMA: ',';

//comments and space
COMMENT: '%%' ~[\r\n]* -> skip;
NEWLINE: [\n\r]+ -> skip;
SPACE: [ \t]+ -> skip;

//I dont know where i put it 
RECEIVE: '=';