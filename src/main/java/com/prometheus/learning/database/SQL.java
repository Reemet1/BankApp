package com.prometheus.learning.database;

public class SQL {

    enum Action {
        CREATE,
        ALTER,
        DROP,
        DELETE,
        INSERT_INTO,
        UPDATE,
        USE,
        SHOW,
        DESCRIBE,
        EXEC,
        TRUNCATE_TABLE,
    }

    enum Object {
        DATABASE,
        TABLE,
        COLUMN,
        VIEW,
        INDEX,
        PROCEDURE
    }

    enum Clause {
        ASC,
        DESC,
        WHERE,
        FROM,
        GROUP_BY,
        HAVING,
        ORDER_BY,
        DISTINCT,
        LIMIT,
        SET,
        VALUES,
        AS

    }

    enum Sets {
        UNION,
        UNION_ALL,
        JOIN,
        LEFT_JOIN,
        RIGHT_JOIN,
        INNER_JOIN,
        OUTER_JOIN,
        FULL_OUTER_JOIN,

    }










}
