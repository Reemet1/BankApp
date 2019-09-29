package com.prometheus.learning.oop;

public class Constructors {


    public void constructorCalling() {

        /**
         * Each time an object is created (instantiated), a constructor is invoked,
         * which initializes that object.
         *
         * If no constructors are explicitly defined, then there will be a default constructor
         * (without parameters) implicitly provided by Java.
         *
         * If at least one constructor is defined explicitly, then the default constructor
         * will not be available, and to be able to create an object using a
         * no-parameter constructor, it has to be explicitly defined.
         *
         * Each constructor invoked has to invoke one of its superclass constructors as a first thing
         * using a 'super' keyword, or call another constructor in the same class (using this(args)) which
         * calls a superclass constructor. When no super(args) is called explicitly, then super() is
         * called implicitly (also in default constructor), which invokes the superclass'
         * no-parameter (or default) constructor (which has to be present)
         *
         */

        SubSubClass obj = new SubSubClass();

    }

    /** Compilation error: recursive constructor call */
    /*
    public Constructors() {
        this(1);
    }
    public Constructors(int a) {
        this();
    }*/

    class SuperClass {

        public SuperClass() {
            System.out.println("Invoking superclass no-parameter constructor");
        }

        /** This is a valid method, not a constructor */
        public void SuperClass() {
        }

        /** When one constructors parameter is a subtype of other constructors parameter,
         *  then constructor with more specific parameter type will be used */
        public SuperClass(Number number) {}
        public SuperClass(Integer integer) {}

    }

    class SubClass extends SuperClass {

        public SubClass(int a) {
            System.out.println("Invoking subclass constructor with parameters");
        }
    }

    class SubSubClass extends SubClass {

        /** Calling 'this()' or 'super()' must be the first thing in a constructor */

        public SubSubClass() {
            this(2);
            System.out.println("Invoking subsubclass no-parameter constructor");
        }

        public SubSubClass(int a) {
            super(1); //calling superclass constructor
            super.hashCode(); //calling superclass method
            System.out.println("Invoking subsubclass constructor with parameters");
        }

    }

}


