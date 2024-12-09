package com.customCompiler.expressions;

import com.customCompiler.MinINGParser;
import com.customCompiler.MinINGParserBaseVisitor;
import com.customCompiler.SymbolTable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to convert the Antlr AST to a Program object,
 * which is used to store the program in a structured way and to perform easily the semantic analysis on the program
 * */
public class AntlrToProgram extends MinINGParserBaseVisitor<Program> {
    // store all semantic errors in the program
    public List<String> semanticErrors;
    public SymbolTable symbolTable;


    @Override
    public Program visitProgram(MinINGParser.ProgramContext ctx) {
        Program program=new Program();
        semanticErrors=new ArrayList<>();
        symbolTable=new SymbolTable();
         AntlrToExpression expressionVisitor=new AntlrToExpression(semanticErrors, symbolTable);

        if (ctx.varGlobal() != null) {
            program.addExpression(expressionVisitor.visit(ctx.varGlobal()));
        }

        // Visit declaration block
        if (ctx.declaration() != null) {
            program.addExpression(expressionVisitor.visit(ctx.declaration()));
        }

        // Visit instruction block
        if (ctx.instruction() != null) {
            program.addExpression(expressionVisitor.visit(ctx.instruction()));
        }
/*
        for (int i=0;i<ctx.getChildCount();i++) {
            // EOF (last child of prog rule), we don't need to visit it, we attempt to convert it to an Expression object
            if (i!=ctx.getChildCount()-1) {
                program.addExpression(expressionVisitor.visit(ctx.getChild(i)));
            }
        }
*/
        return program;
    }
}
