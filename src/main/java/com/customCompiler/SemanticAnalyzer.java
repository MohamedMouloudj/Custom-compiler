package com.customCompiler;

import java.util.ArrayList;
import java.util.List;
/*
// Classe pour générer les quadruplés et les instructions assembleur
class SemanticAnalyzer {
    private int tempCount = 0;
    private List<String> quadruples = new ArrayList<>();
    private List<String> assembly = new ArrayList<>();

    // Fonction pour générer un nouvel identifiant temporaire
    private String newTemp() {
        return "t" + (tempCount++);
    }

    // Analyse sémantique de l'AST
    public String analyze(ASTNode node) {
        if (node == null) return null;

        // Si c'est une feuille (opérande)
        if (node.left == null && node.right == null) {
            return node.value;
        }

        // Si l'opération est une affectation
        if (node.value.equals(":=")) {
            String result = analyze(node.right);
            quadruples.add("(" + node.value + ", " + result + ", _, " + node.left.value + ")");
            assembly.add("LOAD R1, " + result);
            assembly.add("STORE " + node.left.value + ", R1");
            return node.left.value;
        }

        // Analyse des sous-arbres gauche et droit
        String left = analyze(node.left);
        String right = analyze(node.right);

        // Générer un quadruplé pour l'opération
        String temp = newTemp();
        quadruples.add("(" + node.value + ", " + left + ", " + right + ", " + temp + ")");

        // Générer le code assembleur correspondant
        assembly.add("LOAD R1, " + left);
        assembly.add((node.value.equals("+") ? "ADD" : node.value.equals("-") ? "SUB" : node.value.equals("*") ? "MUL" : "DIV") + " R1, " + right);
        assembly.add("STORE " + temp + ", R1");

        return temp;
    }

    // Afficher les quadruplés générés
    public void printQuadruples() {
        System.out.println("Quadruples:");
        for (String quad : quadruples) {
            System.out.println(quad);
        }
    }

    // Afficher les instructions assembleur générées
    public void printAssembly() {
        System.out.println("\nAssembly Code:");
        for (String line : assembly) {
            System.out.println(line);
        }
    }
}
*/

// Classe pour générer les quadruplés et les instructions assembleur
class SemanticAnalyzer {
    private int tempCount = 0;
    private List<String> quadruples = new ArrayList<>();
    private List<String> assembly = new ArrayList<>();

    // Fonction pour générer un nouvel identifiant temporaire
    private String newTemp() {
        return "t" + (tempCount++);
    }

    // Analyse sémantique de l'AST
    public String analyze(ASTNode node) {
        if (node == null) return null;

        // Si c'est une feuille (opérande)
        if (node.left == null && node.right == null) {
            System.out.println("Analyse de la feuille: " + node.value);
            return node.value;
        }

        // Si l'opération est une affectation
        // Si l'opération est une affectation
        if (node.value.equals(":=")) {
            System.out.println("Analyse de l'affectation: " + node.left.value + " := ...");
            String result = analyze(node.right); // Calcul de l'expression à droite

            quadruples.add("(:=, " + result + ", _, " + node.left.value + ")");
            assembly.add("LOAD R1, " + result);
            assembly.add("STORE " + node.left.value + ", R1");
            return node.left.value;
        }
        // Analyse des sous-arbres gauche et droit
        String left = analyze(node.left);
        String right = analyze(node.right);

        // Générer un quadruplé pour l'opération
        String temp = newTemp();
        System.out.println("Analyse de l'opération: " + node.value + " avec " + left + " et " + right);
        quadruples.add("(" + node.value + ", " + left + ", " + right + ", " + temp + ")");
        // Générer le code assembleur correspondant
        assembly.add("LOAD R1, " + left);
        assembly.add((node.value.equals("+") ? "ADD" : node.value.equals("-") ? "SUB" : node.value.equals("*") ? "MUL" : "DIV") + " R1, " + right);
        assembly.add("STORE " + temp + ", R1");

        return temp;
    }

    // Afficher les quadruplés générés
    public void printQuadruples() {
        System.out.println("Quadruples:");
        for (String quad : quadruples) {
            System.out.println(quad);
        }
    }
    // Afficher les instructions assembleur générées
    public void printAssembly() {
        System.out.println("\nAssembly Code:");
        for (String line : assembly) {
            System.out.println(line);
        }
    }
}