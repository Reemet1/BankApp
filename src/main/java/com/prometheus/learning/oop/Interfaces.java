package com.prometheus.learning.oop;

/**
 * A class can only extend one class, but implement multiple interfaces.
 */
public class Interfaces {


    public void interfaces() {
        int field = Interface.FIELD;
        Interface.staticMethod();
        Interface obj = new ImplementationClass();
        obj.defaultMethod();
        ((ImplementationClass) obj).method2(); //Method of ImplemencationClass can be called when obj
        //is cast to ImplementationClass

        ImplementationClass obj2 = new ImplementationClass();
        obj2.defaultMethod();

        //new Interface(); //Interface cannot be instantiated

        /** Though subclass of a regular class can use superclass static method without class reference,
         *  a static interface methods can be called with interface class reference only */
        //obj.staticMethod();
        Interface.staticMethod();
    }



}

/** Class cannot implement 2 interfaces which have defaults methods with the same signature, but
 * it can implement 2 interfaces that have static methods with the same signature, since
 * static interface methods can only be accessed through interface name reference*/
class ImplementationClass implements Interface, AnotherInterface {
    @Override
    public void method() {
        System.out.println("Implementation");
    }
    public void method2() {};

}

/**
 * Interface is a reference type in Java. It contains only abstract methods, except default and static methods.
 * Interface is implicitly abstract. An interface is also used to add a common parent.
 */
interface Interface {

    /** Interface cannot have constructors */
    /*public Interface() {
    }*/

    /** Fields of interfaces are implicitly public static final,
     *  and cannot be instance fields or with smaller visibility*/
    int FIELD = 10;

    /**
     * Methods in an interface are implictly public abstract
     */
    void method();

    /** Default and static methods can have a body. Default methods can be overridden.
     * Default method is public  */
    default void defaultMethod() {
        System.out.println("Default method of an interface");
    }

    static void staticMethod() {
        System.out.println("Static method of an interface");
    }

}

/**
 * An interface can extend another interface, it can also extend multiple interfaces */
interface SubInterface extends Interface, AnotherInterface {

    void method2();
}

interface AnotherInterface {

}
