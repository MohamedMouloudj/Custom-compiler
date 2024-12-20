package com.customCompiler;


import com.customCompiler.expressions.core.*;
import com.customCompiler.quadruplet.QuadElement;
//import com.customCompiler.quadruplet.QuadrupleGenerator;
import com.customCompiler.quadruplet.QuadrupleGenerator;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import com.customCompiler.MinINGParser;
import com.customCompiler.MinINGLexer;
import org.antlr.v4.runtime.tree.ParseTree;
import com.customCompiler.SymbolTable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        try {
            String inputFile="src/test/java/successFile";
            FileInputStream fileInputStream = new FileInputStream(inputFile);

            MinINGParser parser = getParser(fileInputStream);
            // To tell ANTLR to build a parse tree. It parses from the start symbol "prog" (Axiom)
            ParseTree antlrAST = parser.prog();
            AntlrToProgram programVisitor = new AntlrToProgram();
            Program program = programVisitor.visit(antlrAST);
            program.symbolTable.displayTable();
            if (!programVisitor.semanticErrors.isEmpty()) {
                System.out.println("********** Errors **********");
                for (String error : programVisitor.semanticErrors) {
                    System.err.println(error);
                }
                return;
            }else{
                System.out.println("No error detected");
            }
            QuadrupleGenerator generator = new QuadrupleGenerator();
            generator.visit(antlrAST);
            System.out.println("Quadruples:");
            for (QuadElement quad : generator.getQuadruples()) {
                System.out.println(quad.toString());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
//        if (args.length != 1) { // check if the user has provided the file name
//            System.err.println("Bad usage: no file input is provided");
//            return;
//        } else {
//
//        }


    }

    /**
     * Get the parser for the given file
     *
     * @param fileStream
     * @return MinINGParser
     */
    private static MinINGParser getParser(InputStream fileStream) {
        MinINGParser parser = null;
        try {
            CharStream input = CharStreams.fromStream(fileStream);
            MinINGLexer lexer = new MinINGLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new MinINGParser(tokens);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return parser;
    }
}


