package com.prometheus.learning.database;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private String tableName;
    private List<Column> columns;
    private Column primaryKey;

    public Table(String tableName) {
        this.tableName = tableName;
        columns = new ArrayList<>();
    }

    public String getTableName() {
        return tableName;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public Column getPrimaryKey() {
        return primaryKey;
    }

    public void addColumn(Column column) {
        columns.add(column);
    }

    public void setPrimaryKey(Column column) {
        primaryKey = column;
    }

    public static class Column {

        String columnName;
        DataType dataType;
        String defaultValue;
        boolean notNull;
        List<Condition> conditions;
        String[] foreignKey;
        boolean autoIncrement;

        public Column(String columnName, DataType dataType, boolean notNull, String defaultValue) {
            this.columnName = columnName;
            this.dataType = dataType;
            this.notNull = notNull;
            this.defaultValue = defaultValue;
            foreignKey = new String[2];
            conditions = new ArrayList<>();
        }

        public String getColumnName() {
            return columnName;
        }

        public DataType getDataType() {
            return dataType;
        }

        public void addCondition(Condition condition) {
            conditions.add(condition);
        }
    }

    public enum DataType {
        INT("INT"),
        DECIMAL("DECIMAL(10,2)"),
        VARCHAR("VARCHAR(255)");

        String value;

        DataType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    enum Constraint {
        CONSTRAINT,
        CHECK,
        DEFAULT,
        FOREIGN_KEY,
        PRIMARY_KEY,
        UNIQUE
    }

}

