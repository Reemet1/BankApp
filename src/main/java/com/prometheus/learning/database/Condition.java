package com.prometheus.learning.database;

public class Condition {

    String columnName;
    Type conditionType;
    String constraintValue;
    ANDOR andOr;

    public Condition(String columnName, Type conditionType, String constraintValue, ANDOR andOr) {
        this.columnName = columnName;
        this.conditionType = conditionType;
        this.constraintValue = constraintValue;
        this.andOr = andOr;
    }

    public Condition(String columnName, Type conditionType, String constraintValue) {
        this(columnName, conditionType, constraintValue, ANDOR.AND);
    }

    enum ANDOR {
        AND, //where all of the conditions must be true
        OR //where at least one of the given conditions is true
    }

    public enum Type {

        EQUALS("="),
        GREATER(">"),
        LESS("<"),
        GREATEREQ(">="),
        LESSEQ("<="),
        EXISTS("EXISTS"),
        ALL("ALL"), //used to compare a value to all values in another value set
        ANY("ANY"),
        NULL("IS NULL"),
        NOTNULL("IS NOT NULL"),
        NOT("NOT"), //negate operator, e.g NOT EXISTS, NOT BETWEEN, NOT IN, etc.
        LIKE("LIKE"), //where value is similar to the values given using a wildcard
        IN("IN"), //where value is in any of the given set
        BETWEEN("BETWEEN"); //BETWEEN - where value x <= a <= y

        String type;

        Type(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type;
        }

    }

    @Override
    public String toString() {
        String condition;
        if(constraintValue.equals("?")) {
            condition = columnName + " " + conditionType + " " + constraintValue;
        } else {
            condition = columnName + " " + conditionType + " '" + constraintValue +"'";
        }

        return condition;
    }

}

