package com.customCompiler;

/*
// Classe pour construire un AST à partir d'une expression
class ExpressionParser {
    private int index;
    private String input;

    public ASTNode parse(String input) {
        this.input = input.replaceAll("\s", ""); // Supprimer les espaces
        this.index = 0;
        return parseExpression();
    }

    private ASTNode parseExpression() {
        ASTNode left = parseTerm();

        while (index < input.length() && (input.charAt(index) == '+' || input.charAt(index) == '-')) {
            char op = input.charAt(index++);
            ASTNode right = parseTerm();
            left = new ASTNode(String.valueOf(op), left, right);
        }

        return left;
    }

    private ASTNode parseTerm() {
        ASTNode left = parseFactor();

        while (index < input.length() && (input.charAt(index) == '*' || input.charAt(index) == '/')) {
            char op = input.charAt(index++);
            ASTNode right = parseFactor();
            left = new ASTNode(String.valueOf(op), left, right);
        }

        return left;
    }

    private ASTNode parseFactor() {
        if (index < input.length() && input.charAt(index) == '(') {
            index++; // Consommer '('
            ASTNode node = parseExpression();
            if (index >= input.length() || input.charAt(index) != ')') {
                throw new IllegalArgumentException("Erreur de syntaxe : parenthèse fermante manquante.");
            }
            index++; // Consommer ')'
            return node;
        }

        return parseNumberOrVariable();
    }

    private ASTNode parseNumberOrVariable() {
        if (index >= input.length() || !Character.isLetterOrDigit(input.charAt(index))) {
            throw new IllegalArgumentException("Erreur de syntaxe : opérande attendu.");
        }

        StringBuilder sb = new StringBuilder();
        while (index < input.length() && (Character.isLetterOrDigit(input.charAt(index)))) {
            sb.append(input.charAt(index++));
        }
        return new ASTNode(sb.toString());
    }
}
*/

// Classe pour construire un AST à partir d'une expression
class ExpressionParser {
    private int index;
    private String input;

    public ASTNode parse(String input) {
        this.input = input.replaceAll("\s", ""); // Supprimer les espaces
        this.index = 0;
        //ASTNode result = parseExpression();
        ASTNode result = parseAssignment();
        System.out.println("AST généré avec succès.");
        return result;
    }

    private ASTNode parseAssignment() {
        ASTNode left = parseExpression();

             // Vérifier si une affectation suit
        if (index < input.length() && input.startsWith(":=", index)) {
            index += 2; // Consommer ':='
            ASTNode right = parseExpression();
            return new ASTNode(":=", left, right);
        }

        return left;
    }

    private ASTNode parseExpression() {
        ASTNode left = parseTerm();

        while (index < input.length() && (input.charAt(index) == '+' || input.charAt(index) == '-')) {
            char op = input.charAt(index++);
            ASTNode right = parseTerm();
            left = new ASTNode(String.valueOf(op), left, right);
        }

        return left;
    }
    private ASTNode parseTerm() {
        ASTNode left = parseFactor();

        while (index < input.length() && (input.charAt(index) == '*' || input.charAt(index) == '/')) {
            char op = input.charAt(index++);
            ASTNode right = parseFactor();
            left = new ASTNode(String.valueOf(op), left, right);
        }

        return left;
    }

    private ASTNode parseFactor() {
        if (index < input.length() && input.charAt(index) == '(') {
            index++; // Consommer '('
            ASTNode node = parseExpression();
            if (index >= input.length() || input.charAt(index) != ')') {
                throw new IllegalArgumentException("Erreur de syntaxe : parenthèse fermante manquante.");
            }
            index++; // Consommer ')'
            return node;
        }

        return parseNumberOrVariable();
    }
    private ASTNode parseNumberOrVariable() {
        if (index >= input.length() || !Character.isLetterOrDigit(input.charAt(index))) {
            throw new IllegalArgumentException("Erreur de syntaxe : opérande attendu.");
        }

        StringBuilder sb = new StringBuilder();
        while (index < input.length() && (Character.isLetterOrDigit(input.charAt(index)))) {
            sb.append(input.charAt(index++));
        }
        return new ASTNode(sb.toString());
    }
}