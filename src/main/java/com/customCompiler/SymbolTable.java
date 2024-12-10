package com.customCompiler;

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
