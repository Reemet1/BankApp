package com.prometheus.learning.oop;


/**
 * Inheritance can be defined as the process where
 * one class acquires the properties (methods and fields) of another.
 */

public class Inheritance {

    public void inheritingMethodsAndFields() {

        /** Creating subclass object, accessing superclass field and method.
         *  Upon creating an object, all of the non-private superclass fields and methods are aqcuired.
         *  Private superclass fields and methods are not inherited.
         */

        SubClass obj = new SubClass();
        System.out.println("Superclass field: " + obj.superClassField);
        obj.superClassMethod();

        //obj.privateSuperclassField;
        //obj.privateSuperclassMethod();
    }

    private void methodInvoking() {
        /**
         * Subclass type object can invoke superclass methods, but
         * Superclass type object cannot invoke subclass methods.
         * Available methods for the object depend on its type, not constructor.
         */

        new SuperClass().superClassMethod();
        //new SuperClass().subClassMethod(); //Cannot invoke
        //new Superclass().subSubClassMethod(); //Cannot invoke

        new SubClass().superClassMethod();
        new SubClass().subClassMethod();
        //new SubClass().subSubClassMethod(); //Cannot invoke

        new SubSubClass().superClassMethod();
        new SubSubClass().subClassMethod();
        new SubSubClass().subSubClassMethod();

        /** Subclass object can use superclass static method without class reference */
        new TestSubclass().testSuperclassStaticMethod();
        TestSuperclass.testSuperclassStaticMethod();
    }


    /** Superclass is a class that subclasses inherit from */
    class SuperClass {

        /** Each class has a default no-parameter constructor, which when not
         * defined explicictly, is defined implicictly by default. */
        public SuperClass() { }

        public SuperClass(int a) {}

        String sameNameField = "SuperClass field";

        int superClassField;
        private int privateSuperclassField;

        void superClassMethod() {}

        private void privateSuperclassMethod(){}

        void sameNameMethod() {
            System.out.println("Superclass method");
        }

        /** Inner classes cannot have static methods and fields */
        //static int staticInnerclassField;
        //static void staticSuperclassMethod() {}

    }

    /** Subclass is a class that inherits properties of a superclass, using extends keyword */
    class SubClass extends SuperClass {

        String sameNameField = "SubClass field";

        public SubClass() {
            /** super keyword is also used to invoke a superclass constructor */
            super();
        }

        void subClassMethod() {}

        @Override
        void sameNameMethod() {
            System.out.println("Subclass method");
        }

        void superKeyword() {

            /** super keyword is used to differentiate between superclass and subclass method,
             *  if they have the same name. */

            sameNameMethod();
            super.sameNameMethod();
            System.out.println(sameNameField);
            System.out.println(super.sameNameField);
        }
    }

    class SubSubClass extends SubClass {

        void subSubClassMethod() {}

    }

}

class TestSuperclass {

    static void testSuperclassStaticMethod() {

    }
}

class TestSubclass extends TestSuperclass {

    /** Subclass can use static superclass method without class reference */
    void testSubclassMethod() {
        testSuperclassStaticMethod();
    }

}




