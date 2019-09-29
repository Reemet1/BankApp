package com.prometheus.learning.oop;

/**
 * Encapsulation in Java is a mechanism of wrapping the data (variables)
 * and code acting on the data (methods) together as a single unit.
 * In encapsulation, the variables of a class will be hidden from other classes,
 * and can be accessed only through the methods of their current class.
 * Therefore, it is also known as data hiding. In OOP, other classes do
 * not need to know how the intrinsics of an encapsulated class or
 * how it computes the results. Also the class can have total control
 * over what is stored in its fields.
 */
public class Encapsulation {

    private String privateField;

    public void testingEncapsulation() {

        Encapsulation encapsulation = new Encapsulation();
        //encapsulation.privateField; //No access
        //encapsulation.privateMethod(); //No access

        //Private field accessed through public get() and set() methods.
        String str = encapsulation.getPrivateField();
        encapsulation.setPrivateField("newValue");

        /** Current class does not need to know how method() computes its result or who does the work.
         *  As a result, the method() can delegate the work to some other intrinsic method. */
        int a = encapsulation.method();

    }

    public int method() {
        /** A method can delegate all or some of its required work to some other intrinsic method. */
        int a = privateMethod();
        return a;
    }

    private int privateMethod() {
        int nr = 10;
        return nr;
    }

    /** Private fields and methods of an object can be accessed if the object is
     * accessed from the same class */
    static void method2(Encapsulation enc1, Encapsulation enc2) {
        String field = enc1.privateField;
        enc2.privateMethod();
    }

    /**
     * Private fields can still be made accessible through public getter and setter methods,
     * but the class has more control whether to make the private fields read-only or write-only,
     * or not accessible at all.
     */
    public String getPrivateField() {
        return privateField;
    }

    public void setPrivateField(String str) {
        privateField = str;
    }

}


