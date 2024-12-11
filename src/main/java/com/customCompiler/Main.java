package com.customCompiler;


import com.customCompiler.expressions.AntlrToProgram;
import com.customCompiler.expressions.Expression;
import com.customCompiler.expressions.Program;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import com.customCompiler.MinINGParser;
import com.customCompiler.MinINGLexer;
import org.antlr.v4.runtime.tree.ParseTree;
import com.customCompiler.SymbolTable;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) { // check if the user has provided the file name
            System.err.println("Bad usage: no file input is provided");
            return;
        } else {
            String fileName = args[0];
            System.out.println("Parsing: " + fileName);
            MinINGParser parser = getParser(fileName);
            // To tell ANTLR to build a parse tree. It parses from the start symbol "prog" (Axiom)
            ParseTree antlrAST = parser.prog();
            AntlrToProgram programVisitor = new AntlrToProgram();
            Program program = programVisitor.visit(antlrAST);

            if (programVisitor.semanticErrors.isEmpty()) {
                ExpressionProcessor.evaluate(program.expressions, program.symbolTable);
            } else {
                System.out.println("********** Errors **********");
                for (String error : programVisitor.semanticErrors) {
                    System.err.println(error);
                }
            }
        }


    }

    /**
     * Get the parser for the given file
     *
     * @param fileName
     * @return MinINGParser
     */
    private static MinINGParser getParser(String fileName) {
        MinINGParser parser = null;
        try {
            CharStream input = CharStreams.fromFileName(fileName);
            MinINGLexer lexer = new MinINGLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new MinINGParser(tokens);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return parser;
    }
}


