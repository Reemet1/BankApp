package com.prometheus.learning.oop;

/**
 * Polymorphism is a property of objects to admit a type of more than one class.
 * Subclass object IS-A superclass type object.
 */

public class Polymorphism {

    private void objectCreation() {
        /**
         * Subclass constructor can create objects of its
         * superclass (or its own class) type, but cannot create
         * objects of its own subclass type
         */

        Superclass inst1 = new Superclass();
        Superclass inst2 = new Subclass();
        Superclass inst3 = new SubSubClass();

        Subclass inst4 = new Subclass();
        Subclass inst5 = new SubSubClass();

        SubSubClass inst6 = new SubSubClass();

        //SubSubClass inst7 = new Subclass(); Not valid
        //SubSubClass inst8 = new Superclass("param"); Not valid
        //Subclass inst9 = new Superclass("param"); Not valid

        Superclass upCasted = inst4;
        Subclass downCasted = (Subclass) upCasted;

        /** Upcasting and downcasting can only be done between classes that are
         *  in the same superclass-subclass hierarchy */
        //Subclass downCasted2 = (Subclass)(new Integer(2)); //compilation error

        Number nr = polymorphicMethod(new Subclass());
    }

    /** Returned object can be a subtype of return parameter, and a passed
     *  parameter object can be a subtype of the declared parameter type */
    public Number polymorphicMethod(Superclass superclassInstance) {
        return new Integer(2);
    }

    private void defaultTypes() {
        /**
         * By default, every object has at least two types, a type of its own class and type Object
         */

        Superclass sup = new Superclass();
        System.out.println("sup instanceOf Superclass: " + (sup instanceof Superclass));
        System.out.println("sup instanceOf Object: " + (sup instanceof Object));
    }

    private void objectTypes() {
        /**
         * An object initialized using a subclass (or its own class) constructor admits
         * any of its superclass (or its own class) type,
         * but cannot have a type of any of its own subclasses.
         */

        System.out.println("new Superclass() instanceOf Superclass: " + (new Superclass() instanceof Superclass)); //true
        System.out.println("new Superclass() instanceOf Subclass: " + (new Superclass() instanceof Subclass)); //false
        System.out.println("new Superclass() instanceOf SubSubClass: " + (new Superclass() instanceof SubSubClass)); //false

        System.out.println("new Subclass() instanceOf Superclass: " + (new Subclass() instanceof Superclass)); //true
        System.out.println("new Subclass() instanceOf Subclass: " + (new Subclass() instanceof Subclass)); //true
        System.out.println("new Subclass() instanceOf SubSubClass: " + (new Subclass() instanceof SubSubClass)); //false

        System.out.println("new SubSubClass() instanceOf Superclass: " + (new SubSubClass() instanceof Superclass)); //true
        System.out.println("new SubSubClass() instanceOf Subclass: " + (new SubSubClass() instanceof Subclass)); //true
        System.out.println("new SubSubClass() instanceOf SubSubClass: " + (new SubSubClass() instanceof SubSubClass)); //true

        /** In order to use instanceof, the comparable classes must be in the same
         *  superclass-subclass hierarchy */
        //boolean falseInstance = new Subclass() instanceof String; //Compilation error
    }


    public class Superclass {}

    public class Subclass extends Superclass {}

    public class SubSubClass extends Subclass {}

}




