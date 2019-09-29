package com.prometheus.learning.database;

import java.util.Arrays;

public enum Clause {

    DEFAULT("DEFAULT"),
    NOT_NULL("NOT NULL"),
    FROM(" FROM "),
    WHERE("WHERE"),
    DISTINCT("DISTINCT"),
    GROUP_BY("GROUP BY"),
    ORDER_BY("ORDER BY"),
    LIMIT("LIMIT"),
    PRIMARY_KEY("PRIMARY KEY"),
    VALUES("VALUES");

    private String clause;

    Clause(String clause) {
        this.clause = clause;
    }

    public String toString() {
        return clause;
    }

    public String get(String ... arguments) {
        boolean brackets = clause.equals("VALUES") || clause.equals("PRIMARY KEY");
        if(clause.equals("VALUES")) {
            for(int i = 0; i < arguments.length; i++) {
                arguments[i] = "'" + arguments[i] + "'";
            }
        }
        String argumentStr = Arrays.toString(arguments).replace("[","").replace("]","");
        return " " + clause + (brackets ? "(" : " ") + argumentStr + (brackets ? ")" : " ") + " ";
    }
}
