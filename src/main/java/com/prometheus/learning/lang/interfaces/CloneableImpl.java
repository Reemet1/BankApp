package com.prometheus.learning.lang.interfaces;

/**
 * A Cloneable class's instances can be cloned, a.k.a can be used to derive
 * new instances of the same class with shallow copy (fields of the new instance are
 * same) or deep copy (fields of the new instance are also new).
 */
public class CloneableImpl implements Cloneable {

    public String field;

    public CloneableImpl(String str) {
        field = str;
    }

    /**
     * The clone() in the Object class only makes a shallow copy of the object,
     * that means it creates a new instance but initializes the same field objects.
     * To make a deep copy where all the fields are also new objects,
     * a impl copy has to be implemented in this overridden clone() method.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        CloneableImpl clone = new CloneableImpl(new String(field.toCharArray()));
        return clone;
    }

    public void testClone() throws CloneNotSupportedException {

        CloneableImpl cloneable = new CloneableImpl("String");
        Object cloned = cloneable.clone();
        System.out.println(((CloneableImpl)cloned).field == cloneable.field);
        System.out.println(((CloneableImpl)cloned).field.equals(cloneable.field));
    }

}
