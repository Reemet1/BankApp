package com.prometheus.learning.database;

import java.util.ArrayList;
import java.util.List;

public class Query {

    Type queryType;
    String tableName;
    List<String> columns;
    List<Condition> conditions;
    List<Clause> clauses;
    List<String> aggregatedColumns;

    public Query(Type queryType) {
        columns = new ArrayList<>();
        aggregatedColumns = new ArrayList<>();
        this.queryType = queryType;
    }

    public void addColumn(String columnName) {
        columns.add(columnName);
    }

    public void addAggregate(String column, Aggregate aggregate) {
        aggregatedColumns.add(aggregate.get(column));
    }

    public String toString() {
        StringBuilder sql = new StringBuilder();
        sql.append(queryType);
        switch (queryType) {
            case CREATE_DB: {

            }
        }

        return sql.toString();
    }

    enum Type {
        CREATE_DB("CREATE DATABASE"),
        CREATE_TABLE("CREATE TABLE"),
        INSERT("INSERT INTO"),
        DROP_DB("DROP DATABASE"),
        DROP_TABLE("DROP TABLE"),
        ALTER("ALTER TABLE"),
        DELETE("DELETE FROM"),
        SELECT("SELECT"),
        UPDATE("UPDATE");

        String type;

        Type(String type) {
            this.type = type;
        }

        public String toString() {
            return  type;
        }
    }

    enum Clause {
        DISTINCT,
        GROUP_BY,
        ORDER_BY,
        LIMIT
    }

    enum Aggregate {
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

}

