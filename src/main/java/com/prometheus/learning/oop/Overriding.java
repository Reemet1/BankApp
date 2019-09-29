package com.prometheus.learning.oop;

public class Overriding {

    public void overriding() {

        /**
         * Upon invoking a method searching for a method begins from the object's constructor class.
         * If the method is not overridden in this class then the searching continues on superclass.
         */

        SuperClass obj = new SuperClass();
        obj.method();

    }


    class SuperClass {

        public void publicMethod(){}

        public void throwsUncheckedException() {}

        void throwsCheckedException() {}

        final int finalField = 1;

        final void finalMethod() {}

        void method() {
            System.out.println("Superclass method");
        }

        void methodWithParameters(Number number) {};

        Number returnTypeMethod() {
            return new Integer(1);
        }




    }

    class SubClass extends SuperClass {

        /** Overriding method can throw any unchecked exception, regardless the exceptions that
         * overridden method throws. */
        @Override
        public void throwsUncheckedException() throws RuntimeException {}


        /** Overriding method cannot throw checked exceptions that are new or broader than in overridden's method. */
        /*@Override
        void throwsCheckedException() throws Exception{} */

        /*@Override
        void publicMethod() {} */ //Overridden method's access modifier cannot be more restrictive

        @Override
        Integer returnTypeMethod() {

            /** Overriding method's return type must be a subtype of overridden method's return type.
             *  That guarantees that the method's returning type is always a subtype of superclass method's return type */

            return new Integer(2);
        }

        @Override
        void method() {
            /** Superclass method's functionality can be overriden in subclass with @Override annotation. */
            System.out.println("Overridden method");

            /** Superclass method can be called at any location in subclass method */
            super.method();

            //finalField = 2; //final superclass field cannot be overridden
        }


        /** Parameters of overriding method must be exactly of the same type */
        /*@Override
        void methodWithParameters(Integer number) {}*/

        /*@Override
        void finalMethod() {} */ //final superclass method cannot be overridden

    }

}
