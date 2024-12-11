/* package com.customCompiler;

import com.customCompiler.expressions.Expression;


import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String, Symbol> symbols;

    public SymbolTable() {
        symbols = new HashMap<>();
    }

    public void addSymbol(String name, Symbol symbol) {
        symbols.put(name, symbol);
    }

    public Symbol getSymbol(String name) {
        return symbols.get(name);
    }

    public boolean containsSymbol(String name) {
        return symbols.containsKey(name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol Table:\n");
        for (Symbol symbol : symbols.values()) {
            sb.append(symbol.toString()).append("\n");
        }
        return sb.toString();
    }
}

////TODO: Ibrahim
//public class SymbolTable {
//    // Hado ghir des methodes temporaires bech khdemt na, 3awdhom
//    public Object addVariable(String name, Object value) {return 0;}
//    public Object setValue(String name, Object value) {return 0;}
//    public Object getValue(String name) {
//        return 0;
//    }
//    public String getType(String identifier) {
//        return Expression.ExpressionType.INTEGER.toString();
//    }
//
//
//}

*/


package com.customCompiler;

import com.customCompiler.expressions.Expression;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private final Map<String, String> symbols; // Map pour stocker les données encodées

    public SymbolTable() {
        symbols = new HashMap<>();
    }

    // Encodage des données pour stockage
    private String encode(Symbol symbol) {
        return symbol.getName() + "|" +
                symbol.getType() + "|" +
                symbol.getValue() + "|" +
                symbol.getScope() + "|" +
                symbol.isConstant() + "|" +
                symbol.getSize();
    }

    // Vérifie si un symbole existe dans la table
    public boolean containsSymbol(String name) {
        return symbols.containsKey(name);
    }

    // Récupération d'un symbole (avec décodage)
    public Symbol getSymbol(String name) {
        String encodedSymbol = symbols.get(name); // Récupérer la version encodée
        if (encodedSymbol == null) {
            throw new RuntimeException("Le symbole '" + name + "' n'existe pas dans la table.");
        }
        return decode(encodedSymbol); // Décoder pour obtenir un objet Symbol
    }


    // Fonction pour décoder une chaîne encodée en un objet Symbol
    private Symbol decode(String encoded) {
        if (encoded == null || encoded.isEmpty()) {
            return null; // Retourner null si la chaîne est vide ou nulle
        }

        // Séparer la chaîne encodée en parties
        String[] parts = encoded.split("\\|");

        // Vérifier que le nombre de parties correspond
        if (parts.length != 6) {
            throw new RuntimeException("Invalid encoded symbol format.");
        }

        // Décoder les informations
        String name = parts[0];  // Décoder le nom
        Expression.ExpressionType type = Expression.ExpressionType.valueOf(parts[1]);  // Décoder le type
        Object value = parseValue(parts[2], type);  // Décoder la valeur selon le type
        int size = Integer.parseInt(parts[3]);  // Décoder la taille
        boolean isConstant = Boolean.parseBoolean(parts[4]);  // Décoder la constante
        Symbol.Scope scope = Symbol.Scope.valueOf(parts[5]);  // Décoder le scope

        // Créer et retourner un nouvel objet Symbol
        return new Symbol(name, type, value, scope, isConstant, size);
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


    public void addSymbol(String name, Symbol symbol) {
        if (symbols.containsKey(name)) {
            throw new RuntimeException("Symbol " + name + " is already declared.");
        }
        symbols.put(name, encode(symbol));
    }


    public void setValue(String name, Object value) {
        if (!symbols.containsKey(name)) {
            throw new RuntimeException("Variable " + name + " is not declared in the symbol table.");
        }
        // Décoder l'objet Symbol
        Symbol symbol = decode(symbols.get(name));

        // Vérifier si le symbole est une constante
        if (symbol.isConstant()) {
            throw new RuntimeException("Cannot modify the value of a constant variable: " + name);
        }

        // Modifier la valeur
        symbol.setValue(value);

        // Réencoder et mettre à jour la Map
        symbols.put(name, encode(symbol));
    }

    public Object getValue(String name) {
        if (!symbols.containsKey(name)) {
            return null; // Ou lever une exception
        }
        return decode(symbols.get(name)).getValue();
    }

    public String getType(String name) {
        if (!symbols.containsKey(name)) {
            throw new RuntimeException("Variable " + name + " is not declared in the symbol table.");
        }
        return decode(symbols.get(name)).getType().toString();
    }

    public void displayTable() {
        String header = String.format("| %-15s | %-10s | %-10s | %-10s | %-10s |", "Name", "Type", "Value", "Scope", "Constant");
        String border = "+-----------------+------------+------------+------------+------------+";

        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (Map.Entry<String, String> entry : symbols.entrySet()) {
            String name = entry.getKey();
            Symbol symbol = decode(entry.getValue());
            String row = String.format("| %-15s | %-10s | %-10s | %-10s | %-10s |",
                    name,
                    symbol.getType(),
                    symbol.getValue() != null ? symbol.getValue().toString() : "null",
                    symbol.getScope(),
                    symbol.isConstant() ? "true" : "false");
            System.out.println(row);
        }
        System.out.println(border);
    }
}
