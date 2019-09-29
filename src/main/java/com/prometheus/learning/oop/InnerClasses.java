package com.prometheus.learning.oop;

public class InnerClasses {


    public void innerClasses() {

        /** Creating innerclass object */
        OuterClass.InnerClass innerClassObj = new OuterClass().new InnerClass(2);
        //innerClassObj = new OuterClass.InnerClass(2); //invalid

        /** Local inner class */
        class ImplClass implements InnerInterface {
            @Override
            public void interfaceMethod() {

            }
        }

        InnerInterface implObj = new ImplClass();

        /** Local anonymous class. Created upon object creation, can be used only once. */
        method1(new InnerInterface() {
            @Override
            public void interfaceMethod() {

            }
        });

    }

    public void method1(InnerInterface param) {}


    public class OuterClass {

        private String outerField;

        private int field;

        /** Inner classes are defined within another class. In general these classes are
         * not useful on their own right, but are mostly extensions or additions
         * or helper classes to their parent class. Inner classes are normally made private
         * so that only their parent class can access them.
         */
        private class InnerClass {

            int field;

            public InnerClass(int field) {
                //Distinguish between argument, inner class field and outer class field.
                this.field = field;
                OuterClass.this.field = field;
            }

            /** Objects of the inner class have access to all parent class fields and methods,
             even private ones. */
            public void innerMethod() {
                String a = outerField;
            }
        }
    }

    interface InnerInterface {
        void interfaceMethod();
    }




}
