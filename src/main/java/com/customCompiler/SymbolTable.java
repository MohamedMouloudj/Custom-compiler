package com.customCompiler;

import com.customCompiler.expressions.Expression;

import java.util.HashMap;
import java.util.Map;

import java.io.*;
import java.util.Base64;

public class SymbolTable {
    private final Map<String, String> symbols; // Map pour stocker les données encodées

    public SymbolTable() {
        symbols = new HashMap<>();
    }

    // Méthode utilitaire pour convertir la valeur en fonction de son type
    private Object parseValue(String value, Expression.ExpressionType type) {
        switch (type) {
            case INTEGER:
                return Integer.parseInt(value);
            case FLOAT:
                return Float.parseFloat(value);
            case CHAR:
                return value.charAt(0);  // Suppose un seul caractère
            default:
                return value;  // Retourner la chaîne brute pour UNKNOWN ou autres
        }
    }


    // Encode un symbole en une chaîne encodée Base64
    public String encodeSymbol(Symbol symbol) {
        try (ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(byteOut)) {
            out.writeObject(symbol);
            return Base64.getEncoder().encodeToString(byteOut.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("Failed to encode symbol", e);
        }
    }

    // Décode une chaîne encodée Base64 en un symbole (inverse function of 'encodeSymbol' )
    public Symbol decodeSymbol(String encodedSymbol) {
        try (ByteArrayInputStream byteIn = new ByteArrayInputStream(Base64.getDecoder().decode(encodedSymbol));
             ObjectInputStream in = new ObjectInputStream(byteIn)) {
            return (Symbol) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to decode symbol", e);
        }
    }

    // Ajouter un symbole dans la table
    public void addSymbol(String name, Symbol symbol) {
        if (symbols.containsKey(name)) {
            throw new RuntimeException("Symbol " + name + " is already declared.");
        }
        symbols.put(name, encodeSymbol(symbol)); // Encode et stocke le symbole
    }

    // Récupérer un symbole depuis la table
    public Symbol getSymbol(String name) {
        String encodedSymbol = symbols.get(name); // Récupérer la version encodée
        if (encodedSymbol == null) {
            throw new RuntimeException("Le symbole '" + name + "' n'existe pas dans la table.");
        }
        return decodeSymbol(encodedSymbol); // Décoder et retourner l'objet Symbol
    }

    // Modifier la valeur d'un symbole
    public void setValue(String name, Object value) {
        if (!symbols.containsKey(name)) {
            throw new RuntimeException("Variable " + name + " is not declared in the symbol table.");
        }

        // Décoder l'objet Symbol par name
        Symbol symbol = decodeSymbol(symbols.get(name));

        // Vérifier si le symbole est une constante
        if (symbol.isConstant()) {
            throw new RuntimeException("Cannot modify the value of a constant variable: " + name);
        }

        // Modifier la valeur
        symbol.setValue(value);

        // Réencoder et mettre à jour la table
        symbols.put(name, encodeSymbol(symbol));
    }

    // Vérifie si un symbole existe dans la table ...boolean
    public boolean containsSymbol(String name) {
        return symbols.containsKey(name);
    }

    // Obtenir la valeur seulement d'un symbole
    public Object getValue(String name) {
        if (!symbols.containsKey(name)) {
            return null; // Ou lever une exception
        }
        return decodeSymbol(symbols.get(name)).getValue();
    }

    // Obtenir le type d'un symbole
    public String getType(String name) {
        if (!symbols.containsKey(name)) {
            throw new RuntimeException("Variable " + name + " is not declared in the symbol table.");
        }
        return decodeSymbol(symbols.get(name)).getType().toString();
    }

    // Afficher la table des symboles
    public void displayTable() {
        String header = String.format(
                "| %-15s | %-10s | %-10s | %-10s | %-10s | %-10s |",
                "Name", "Type", "Value", "Scope", "Constant", "Size"
        );

        String border = "+-----------------+------------+------------+------------+------------+------------+";

        System.out.println("******** Symbols Table ********");
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (Map.Entry<String, String> entry : symbols.entrySet()) {
            Symbol symbol = decodeSymbol(entry.getValue());
            String row = String.format(
                    "| %-15s | %-10s | %-10s | %-10s | %-10s | %-10d |",
                    entry.getKey(),
                    symbol.getType(),
                    symbol.getValue() != null ? symbol.getValue().toString() : "null",
                    symbol.getScope(),
                    symbol.isConstant() ? "true" : "false",
                    symbol.getSize()
            );
            System.out.println(row);
        }
        System.out.println(border);
    }


    //espace test table symbol et ses functions.....enlever les commentaires de n'importe quel instruction pour la tester
    public static void main(String[] args) {
        SymbolTable symbolTable = new SymbolTable();

        try{
            // Créer des symboles
            symbolTable.addSymbol("x", new Symbol(Expression.ExpressionType.INTEGER, 42, Symbol.Scope.GLOBAL, true, 4));
            symbolTable.addSymbol("y", new Symbol(Expression.ExpressionType.FLOAT, 3.14, Symbol.Scope.GLOBAL, false, 8));
            symbolTable.addSymbol("z", new Symbol(Expression.ExpressionType.CHAR, 32, Symbol.Scope.GLOBAL, false, 1));



            //symbolTable.addSymbol("A", new Symbol("A", Expression.ExpressionType.FLOAT, 292, Symbol.Scope.GLOBAL, false, 8));

            // si duplicatioon de meme nom variable : erreur
                //symbolTable.addSymbol("x", new Symbol("x", Expression.ExpressionType.FLOAT, 4543, Symbol.Scope.GLOBAL, false, 4));

            // Modifier un symbole mais ici affiche msg erreur prcq x est saisis comme constant:(true)
                //symbolTable.setValue("x", 100);

            // Modifier un symbole mais ici affiche msg erreur prcq x est saisis comme constant:(true)
               //symbolTable.setValue("A", 100);

            // Récupérer et afficher les symboles
               //System.out.println("Valeur de x : " + symbolTable.getValue("x"));
               //System.out.println("Valeur de A : " + symbolTable.getValue("A"));

            //symbolTable.setValue("A",100);

            // ajout un symbol et puis une ligne dans table symbol
              // 1.premier cas pour deja existance du meme nom de symbol : donc erreur
                 //symbolTable.addSymbol("x", new Symbol("x", Expression.ExpressionType.INTEGER, 100, Symbol.Scope.GLOBAL, false, 4));
              //2.deuxieme cas est entrer un nom symbol nn existant deja : ajout nouvelle ligne dans la table
                 //symbolTable.addSymbol("g", new Symbol("g", Expression.ExpressionType.INTEGER, 33, Symbol.Scope.GLOBAL, false, 4));

            // Vérification du type
            System.out.println("\nType de x : " + symbolTable.getType("x"));


            // affiche msg d'erreur du variable non existant 't'
            //System.out.println("\naffiche les infos du symboles voulus"+symbolTable.getSymbol("t"));
            //affiche les valeurs du variable existant A
                //System.out.println("affiche les infos du symboles voulus 'A':\n"              +symbolTable.getSymbol("A"));

            System.out.println("\nRésultat de la présence du symbole 'x': "+symbolTable.containsSymbol("x"));


            System.out.println("\n                    === Table des Symboles ===");
            // Affichage complet de la table
            symbolTable.displayTable();
        }catch(RuntimeException e) {
            System.err.println("Erreur : " + e.getMessage());
        }

        /*
        //............................test (decode and encode) Symbol..........................

        // Création de plusieurs symboles
        Symbol symbol1 = new Symbol("x", Expression.ExpressionType.INTEGER, 42, Symbol.Scope.GLOBAL, false, 4);
        Symbol symbol2 = new Symbol("y", Expression.ExpressionType.FLOAT, 3.14, Symbol.Scope.GLOBAL, false, 8);
        Symbol symbol3 = new Symbol("z", Expression.ExpressionType.CHAR, 'A', Symbol.Scope.GLOBAL, true, 1);

        // Encodage de chaque symbole
        String encoded1 = symbolTable.encodeSymbol(symbol1);
        String encoded2 = symbolTable.encodeSymbol(symbol2);
        String encoded3 = symbolTable.encodeSymbol(symbol3);

        // Affichage des résultats
        System.out.println("Encoded Symbol 1: " + encoded1);
        System.out.println("Encoded Symbol 2: " + encoded2);
        System.out.println("Encoded Symbol 3: " + encoded3);

    */


      /*

    ............................exemple pour test d'égalité == true  où 'x' à la meme chaine encodé parraport à lui..........................

            // Création de deux symboles identiques
            Symbol symbol1 = new Symbol("x", Expression.ExpressionType.INTEGER, 42, Symbol.Scope.GLOBAL, false, 4);
            Symbol symbol2 = new Symbol("x", Expression.ExpressionType.INTEGER, 42, Symbol.Scope.GLOBAL, false, 4);

            // Encodage des deux symboles
            String encoded1 = symbolTable.encodeSymbol(symbol1);
            String encoded2 = symbolTable.encodeSymbol(symbol2);

            // Affichage des résultats
            System.out.println("Encoded Symbol 1: " + encoded1);
            System.out.println("Encoded Symbol 2: " + encoded2);

            // Vérification de l'égalité
            System.out.println("Encoded strings are equal: " + encoded1.equals(encoded2));

           */
    }


}



