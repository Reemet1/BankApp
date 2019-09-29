package com.prometheus.learning.database;

public enum Aggregate {

    MAX("MAX"),
    MIN("MIN"),
    COUNT("COUNT"),
    AVG("AVG"),
    SUM("SUM");

    String aggr;

    Aggregate(String aggr) {
        this.aggr = aggr;
    }

    public String get(String columnName) {
        return aggr + "(" + columnName + ")";
    }
}

