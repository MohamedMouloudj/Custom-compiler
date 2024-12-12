package com.customCompiler;

import java.util.*;
/*
// Classe principale pour exécuter le programme
public class SemanticAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez une expression arithmétique :");
        String expression = scanner.nextLine();

        try {
            ExpressionParser parser = new ExpressionParser();
            ASTNode tree = parser.parse(expression);

            SemanticAnalyzer analyzer = new SemanticAnalyzer();

            // Analyser l'AST
            analyzer.analyze(tree);

            // Afficher les résultats
            analyzer.printQuadruples();
            analyzer.printAssembly();
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}
*/


// Classe principale pour exécuter le programme
public class SemanticAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez une expression arithmétique :");
        String expression = scanner.nextLine();

        try {
            ExpressionParser parser = new ExpressionParser();
            ASTNode tree = parser.parse(expression);

            SemanticAnalyzer analyzer = new SemanticAnalyzer();

            // Analyser l'AST
            analyzer.analyze(tree);

            // Afficher les résultats
            analyzer.printQuadruples();
            analyzer.printAssembly();
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}