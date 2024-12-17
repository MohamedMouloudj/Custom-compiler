package com.customCompiler.expressions;

import com.customCompiler.MinINGParser;
import com.customCompiler.MinINGParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to convert the Antlr AST to a Program object,
 * which is used to store the program in a structured way and to perform easily the semantic analysis on the program
 * */
public class AntlrToProgram extends MinINGParserBaseVisitor<Program> {
    // store all semantic errors in the program
    public List<String> semanticErrors;

    @Override
    public Program visitProgram(MinINGParser.ProgramContext ctx) {
        semanticErrors=new ArrayList<>();
        Program program=new Program();
        AntlrToExpression expressionVisitor=new AntlrToExpression(semanticErrors, program.symbolTable);

         program.addExpression(expressionVisitor.visit(ctx.varGlobal()));
         program.addExpression(expressionVisitor.visit(ctx.declaration()));
         program.addExpression(expressionVisitor.visit(ctx.instruction()));

//        if (ctx.varGlobal() != null) {
//            for (int i = 0; i < ctx.varGlobal().getChildCount(); i++) {
//                program.addExpression(expressionVisitor.visit(ctx.varGlobal().getChild(i)));
//            }
//        }

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