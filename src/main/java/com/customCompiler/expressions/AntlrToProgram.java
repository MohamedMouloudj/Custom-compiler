package com.customCompiler.expressions;

import java.util.ArrayList;
import java.util.List;
import com.customCompiler.MinINGParserBaseVisitor;
import com.customCompiler.MinINGParser;

public class AntlrToProgram extends MinINGParserBaseVisitor<Program> {
    // store all semantic errors in the program
    public List<String> semanticErrors;


    @Override
    public Program visitProgram(MinINGParser.ProgramContext ctx) {
        Program program=new Program();
        semanticErrors=new ArrayList<>();
         AntlrToExpression expressionVisitor=new AntlrToExpression(semanticErrors);

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
