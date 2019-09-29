package com.prometheus.learning.basics.modifiers;

public class StaticMofidier {

    public static void main(String[] args) {
        System.out.println("In main method");
    }

    /** Static initializer blocks are equivalent to static constructors. This block is only executed
     * once when the class is loaded into the project. All the static fields must be initialized
     * before all static initializer blocks have been terminated. */

    static {
        /** static final fields can only be initialized in static initializer blocks */
        finalStaticField = "Initialized";

        /** Static methods can be called from static initializer blocks */
        staticMethod();

        /** Instance fields cannot be used in static initializer blocks */
        //instanceField = "str";

        /** To use instanc field, an instance has to be created */
        StaticMofidier staticMofidier = new StaticMofidier();
        staticMofidier.instanceField = "Str";

    }

    /** Multiple static initializer blocks can be declare and they are executed in their declaration order */
    static {

    }

    /** static fields can appear after the static initializer block and are initialized first */
    public static final String finalStaticField;
    public String instanceField;

    /** All instances of a class share and modify the same static fields of a class (a.k.a class field),
     *  there is only one copy of each static variable in memory.
     *  Static fields and methods are related to classes directly and not related to concrete instances.
     *  Static fields are created when the class is created by Java */
    public static String staticField = "Static field";

    /** Static fields are rare and and mostly declared as public static final and
     * variable name in such case is written in UPPERCASE */
    public static final String CONSTANT = "constant";

    public int field;

    /** Methods that only access static fields should also be declared as static.
     *  Superclass static methods cannot be overridden in subclass */
    public static void staticMethod() {

        /** Static methods cannot access instance fields and methods, since instance variables
         * are not initialized and instance methods could also operate on uninitialized variables */
        //field = 2;
        //nonAccessModifiers();

        /** Static methods can use static variables and static methods, since static methods
         * only use static variables */
        staticField += 1;
        staticMethod2();

        /** BlockChain methods can also be called */
        //BlockChain.main(new String[]{"a"});

        /** Static fields and methods can be called on null objects */
        StaticMofidier instance = null;
        System.out.println(instance.staticField);
    }

    public static void staticMethod2(){}

    public void nonAccessModifiers() {

        /** Static fields and methods can be accessed from the same class without class reference */
        staticField += 1;
        staticMethod();

        /** From other classes the static fields and methods can be accessed
         * without instantiating an object with class reference */
        StaticMofidier.staticField += 1;
        StaticMofidier.staticMethod();

        /** Static fields and methods can also be accessed through instances, but it is a bad practice
         * since it hides the fact that the field or method accessed is static. It is better to use
         * full class reference StaticMofidier.staticField or StaticMofidier.staticMethod()
         */
        StaticMofidier obj = new StaticMofidier();
        obj.staticField += 1;

    }

}
