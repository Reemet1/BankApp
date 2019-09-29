package com.prometheus.learning.database;

public class Column {

    private String columnName;
    private Aggregate aggregate;
    private Clause clause;

    public Column(String columnName, Aggregate aggregate, Clause clause) {
        this.columnName = columnName;
        this.aggregate = aggregate;
        this.clause = clause;
    }

}
