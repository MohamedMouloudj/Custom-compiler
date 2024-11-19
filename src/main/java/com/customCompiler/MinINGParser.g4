parser grammar MinINGParser;

options {tokenVocab=MinINGLexer;}

// logic and arithmetic 
expression: expression (MUL|DIV) expression
          | expression (ADD|SUB) expression
          |expression OR expression
          |expression AND expression
          | NOT expression
          |'(' expression ')'
          ;

// comparison
comparison: expression ('>'|'>='|'<'|'<='|'=='|'!=') expression;


//declaration variable 
declaration : TYPE (',' IDF)* SEMI
            | CONST TYPE IDF RECEIVE (INT|FLOAT|CHAR) SEMI;



table_declaration : TYPE IDF LBRACKET INT RBRACKET SEMI;



