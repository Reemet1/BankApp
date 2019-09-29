package com.prometheus.learning.oop;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        main.method();

    }

    public void method() {
        new SuperClass(new SubClass());
    }

    class SuperClass {

        public SuperClass() {
            System.out.println("Superclass constructor");
        }

        public SuperClass(SuperClass obj) {
            System.out.println("super");
        }
        /*public SuperClass(SubClass obj) {
            System.out.println("sub");
        }*/

    }

    class SubClass extends SuperClass {

        public SubClass() {
            System.out.println("Subclass constructor");
        }

        public SubClass(int a) {
            this();
        }

        public void method() {
            System.out.println(this.hashCode() + " " + super.hashCode());
        }

    }
}
