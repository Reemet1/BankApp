package com.prometheus.learning.oop;

public class Abstraction {



    private void abstractClasses() {

        /**
         * Abstract class cannot be instantiated, but
         * abstract class's constructor can be invoked from implementing subclass's constructor
         */
        //AbstractClass abstractClass = new AbstractClass();

        /** But abstract class object can be created with inner class that implements
         *  all the abstract methods of AbstractClass*/
        AbstractClass abstractClass1 = new AbstractClass() {
            @Override
            String abstractMethod(String str) {return null;}
            @Override
            public void method1(){}
            @Override
            public int method2(int a) {return 0;}
        };

        AbstractClass abstractClass = new AbstractClassSubclass(10);

    }

    class AbstractClassSubclass extends AbstractClass {


        /**
         * Abstract methods provide the requirements as to what the method should do an return,
         * but do not specify a concrete implementation of how it should be done.
         * In short, an abstract method says what should be done, but now how it should be done.
         */
        String abstractMethod(String str) {
            return "";
        }

        public AbstractClassSubclass() {
            super();
        }

        public AbstractClassSubclass(int a) {
            super(a);
        }


        public int method2(int a) {
            return 0;
        }

        public void method1() {

        }
    }

    abstract class AbstractClass implements SubInterface {

        /**
         * If a class has at least one abstract method, the class must be declared as abstract.
         * An abstract class can have no abstract methods
         */

        /**
         * Though no object can be instantiated using abstract classes constructor directly,
         * the constructor can be invoked from subclass constructor.
         */

        public AbstractClass() {
            System.out.println("Abstract class constructor");
        }

        public AbstractClass(int a) {
            System.out.println("Abstract class parametrized constructor: " + a);
            /** Abstract method can be called, since it is implemented in subclass */
            abstractMethod("str");
        }

        abstract String abstractMethod(String str);

        /** Abstract methods can be called from the method in the same class */
        void method2() {
            abstractMethod("str");
        }

        /** Abstract methods cannot have a body */
        //abstract String abstractMethod(String str){};


        /** Abstract methods cannot be declared private, final or static */
        //private abstract void privateAbstractMethod();
        //abstract final void finalAbstractMethod();
        //abstract static void staticAbstractMethod();

        /**
         * An abstract class can contain non abstract methods, which enables
         * partial implementation
         */

        void nonAbstractMethod() {
            System.out.println("Non abstract method");
        }

    }

    interface SubInterface extends Interface {

        /**
         * An interface that extends another interface inherits all the abstract methods
         * of the superinterface, and may add new abstract methods or fields on its own
         */

    }

    public interface Interface {

        /**
         * Interface is a class where all methods except default method are abstract
         */

        /**
         * All fields in an instance are implicitly public static final
         */
        int field = 3;

        /**
         * All methods in an interface are implicitly public abstract
         */
        void method1();

        /**
         * An abstract method determines the return type and parameters of the method,
         * but leaves the implementation totally to its implementing class
         */
        int method2(int a);

    }

}
