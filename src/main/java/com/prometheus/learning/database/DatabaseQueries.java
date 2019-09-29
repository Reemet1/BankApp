package com.prometheus.learning.database;


/**
 * SQL a.k.a Structured Query Language is a language to operate databases.
 * SQL enables to CREATE, ALTER and DROP databases, tables and views, as well
 * enables to SELECT, INSERT, UPDATE or DELETE records from/into different tables
 * and also manager user permissions with GRANT and REVOKE.
 */

public class DatabaseQueries {

    public String createDatabase(String dbName) {
        return QueryType.CREATE_DB + dbName;
    }

    public String selectDatabase(String dbName) {
        return QueryType.SELECT + dbName;
    }

    public String dropDatabase(String dbName) {
        return QueryType.DROP_DB + dbName;
    }

    public String showDatabases() {
        return QueryType.SHOW_DBS.toString();
    }

    public String createTable(Table table) {
        StringBuilder sql = new StringBuilder();
        sql.append(QueryType.CREATE_TABLE + table.getTableName()).append("( \n");

        for(Table.Column column : table.getColumns()) {
            sql.append(column.getColumnName()).append(" ");
            sql.append(column.getDataType()).append(" ");
            sql.append(column.notNull ? Clause.NOT_NULL : " ");
            sql.append((column.defaultValue == null) ? " " : "DEFAULT '" + column.defaultValue + "'");
            sql.append(", \n");
        }
        sql.append(Clause.PRIMARY_KEY.get(table.getPrimaryKey().getColumnName())).append("\n");
        sql.append(")");
        return sql.toString();
    }

    public String showTables() {
        return QueryType.SHOW_TABLES.toString();
    }

    public String tableInfo(String tableName) {
        return QueryType.DESCRIBE + tableName;
    }

    public String dropTable(String tableName) {
        return QueryType.DROP_TABLE + tableName;
    }

    public String insertIntoTable(String tableName, String ... values) {
        return QueryType.INSERT_INTO + tableName + Clause.VALUES.get(values);
    }

    public String select(String tableName, String[] columns, Condition ... conditions) {
        StringBuilder sql = new StringBuilder();
        sql.append(QueryType.SELECT);
        if(columns == null || columns.length == 0) {
            sql.append("*");
        } else {
            for(int i = 0; i < columns.length-1; i++) {
                sql.append(columns[i] + ",");
            }
            sql.append(columns[columns.length-1]);
        }

        sql.append(Clause.FROM).append("`").append(tableName).append("`");

        if(conditions != null && conditions.length > 0) {
            sql.append(Clause.WHERE);
            for(int i = 0; i < conditions.length-1; i++) {
                sql.append(conditions[i]).append(" ").append(conditions[i].andOr).append(" ");
            }
            sql.append(conditions[conditions.length-1]);
        }


        return sql.toString();
    }

    public String select(String tableName) {
        return select(tableName, null, null);
    }

    public String select(String tableName, String[] columns) {
        return select(tableName, columns, null);
    }

    public String select(String tableName, Condition ... conditions) {
        return select(tableName, null, conditions);
    }

    public String updateTable(String tableName, String[] columns, String[] values, Condition ... conditions) {
        StringBuilder sql = new StringBuilder();
        sql.append(QueryType.UPDATE + tableName + " SET ");
        for(int i = 0; i < columns.length-1; i++) {
            if(values[i].equals("?")) sql.append(columns[i]+" = " + values[i] + " , ");
            else sql.append(columns[i]+" = '" + values[i] + "' , ");
        }
        if(values[values.length-1].equals("?")) {
            sql.append(columns[columns.length-1]+" = " + values[values.length-1] + "");
        } else {
            sql.append(columns[columns.length-1]+" = '" + values[values.length-1] + "'");
        }


        if(conditions != null && conditions.length > 0) {
            sql.append(Clause.WHERE);
            for(int i = 0; i < conditions.length-1; i++) {
                sql.append(conditions[i] + " " + conditions[i].andOr + " ");
            }
            sql.append(conditions[conditions.length-1]);
        }

        return sql.toString();
    }

    public String deleteRecords(String tableName, Condition ... conditions) {
        StringBuilder sql = new StringBuilder();
        sql.append(QueryType.DELETE + tableName);
        sql.append(Clause.WHERE);
        for(int i = 0; i < conditions.length-1; i++) {
            sql.append(conditions[i] + " " + conditions[i].andOr + " ");
        }
        sql.append(conditions[conditions.length-1]);

        return sql.toString();
    }

    /**
     * SQL OPERATORS
     *
     * Arithmetic operators: + - * / %
     * Comparison operators: = != <> > < <= >= !< !>
     */

}

