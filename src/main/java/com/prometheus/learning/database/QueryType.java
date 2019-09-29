package com.prometheus.learning.database;

public enum QueryType {

    CREATE_DB("CREATE DATABASE"),
    SHOW_DBS("SHOW DATABASES"),
    CREATE_TABLE("CREATE TABLE"),
    SHOW_TABLES("SHOW TABLES"),
    DESCRIBE("DESCRIBE"),
    INSERT_INTO("INSERT INTO"),
    DROP_DB("DROP DATABASE"),
    DROP_TABLE("DROP TABLE"),
    ALTER("ALTER TABLE"),
    DELETE("DELETE FROM"),
    SELECT("SELECT"),
    UPDATE("UPDATE");

    String type;

    QueryType(String type) {
        this.type = type;
    }

    public String toString() {
        return  " " + type + " ";
    }

}

