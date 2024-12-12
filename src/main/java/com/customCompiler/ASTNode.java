package com.customCompiler;
/*
// Classe pour représenter les nœuds de l'arbre syntaxique
class ASTNode {
    String value;
    ASTNode left, right;

    public ASTNode(String value) {
        this.value = value;
    }

    public ASTNode(String value, ASTNode left, ASTNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
*/

import java.util.*;

// Classe pour représenter les nœuds de l'arbre syntaxique
class ASTNode {
    String value;
    ASTNode left, right;

    public ASTNode(String value) {
        this.value = value;
    }

    public ASTNode(String value, ASTNode left, ASTNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}