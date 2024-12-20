parser grammar MinINGParser;

options {tokenVocab=MinINGLexer;}


// Axiom
prog
    : varGlobal declaration instruction EOF  #Program;

// VAR_GLOBAL block
varGlobal: VAR_GLOBAL LBRACE varDeclaration* RBRACE     #VariableGlobalSegment;

// DECLARATION block
declaration: DECLARATION LBRACE varDeclaration* RBRACE  #DeclarationSegment;

// INSTRUCTION block
instruction: INSTRUCTION LBRACE statement* RBRACE   #InstructionSegment;


// Variable declaration
varDeclaration
    : TYPE IDF (COMMA IDF)* SEMI            #VariableDeclaration    // Simple variable(s) declaration
    | TYPE arrayList SEMI                   #ArrayDeclaration   // Array(s) declaration
    | CONST TYPE IDF RECEIVE (INT|FLOAT|CHAR) SEMI          #ConstDeclaration  // Constant declaration
    ;

arrayList
    : arrayDecl (COMMA arrayDecl)*            // List of arrays
    ;

arrayDecl
    : IDF LBRACKET INT RBRACKET               // Single array declaration
    ;

// Statements
statement
    : assignment                               #AssignmentStatement    // Assignment statement
    | expression    SEMI                       #ExpressionStatement    // Expression
    | condition                                #ConditionStatement // IF statement
    | loop                                     #LoopStatement   // FOR loop
    | ioOperation                              #IOStatement // Input/Output operation
    ;

// Assignment
assignment
    : IDF RECEIVE expression SEMI     #AssignmentExpression
    | IDF LBRACKET expression RBRACKET RECEIVE expression SEMI   #ArrayElementAssignment
    ;

// IF statement
condition
    : IF LPAREN conditionExpr RPAREN LBRACE statement* RBRACE ( ELSE LBRACE statement* RBRACE )?   #ConditionalStatement
    ;

// FOR loop
loop
    : FOR LPAREN loopAssignment COLON expression COLON expression RPAREN LBRACE statement* RBRACE #LoopDefinition
    ;
loopAssignment
    : IDF RECEIVE expression
    ;

// Input/Output operations
ioOperation
    : READ LPAREN IDF RPAREN SEMI   #ReadOperation
    | READ LPAREN IDF LBRACKET expression RBRACKET RPAREN SEMI   #ReadArrayOperation
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
    | IDF LBRACKET expression RBRACKET  #ArrayElement
    ;


// Condition expression
conditionExpr
    : expression comparisonOp expression    #Comparison
    | NOT conditionExpr                     #Negation
    | conditionExpr OR conditionExpr           #OrCondition
    | conditionExpr AND conditionExpr          #AndCondition
    | LPAREN conditionExpr RPAREN           #ParenthesisCondition
    ;

comparisonOp
    : GREATER | GREATEREQUAL | LESS | LESSEQUAL | EQUAL | NOTEQUAL
    ;

// String or expression (for WRITE operations)
stringOrExpression
    : STRING_LITERAL    # StringLiteral
    | expression        # ExpressionInWrite
    ;
