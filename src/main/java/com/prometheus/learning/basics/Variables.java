package com.prometheus.learning.basics;

/** Scope refers to the visibility of class, members or variables */
/** static (global) scope - superclass scope - class scope -
 *  inner class scope - method local scope - block scope (block, loop, try-block, etc) */
/** Generally, object scope is the block in which it is declared and all the blocks that contain this block */
public class Variables {

    {
        int blockLocalVariable = 10;
    }

    /**Instance variables can be used from all methods of that class. They are initialized
     * when an instance of a class is instantiated and destroyed, when an object is destroyed */

    public int publicInstanceVar = 0;
    private int privateInstanceVar = 0;

    private int var1 = 0;
    private int var2 = 0;

    /** instance variables and methods can have the same name */
    int x;
    void x() {};

    public void method() {

        /** Method local variable is only visible in the method where it was created and
         * they are destroyed when the method is exited. */
        int methodLocalVariable = 1;

        {
            /** Block local variables are only visible in the block where they were created
             * and they are destroyed when the block is exited */
            int blockLocalVariable = 1;
        }

        /** method or block local variables cant have have access modifier specified */

        /** Variable i is loop local and can only be used in that loop */
        for(int i = 0; i < 10; i++) {

        }

        /** When a variable is called, java first searches this variable's declaration
         * from inside a local scope, and when not found,
         * the variable is searched from larger scope, e.g from outside the block, or from instance variables.
         */
        int var1 = 1;
        var1 += 1;
        var2 += 1;

        /** To distinguish from local vs instance variables, instance variables are referred with 'this' keyword */
        this.var1 += 1;

        String localStr = "localStr";
        {
            //String localStr = "inBlock Str"; //Invalid, aleady defined
            String anotherLocalStr = "in block str";
        }
        String anotherLocalStr = "outside block"; //valid

        /** pimitives and Strings will get a new copy inside a method, and changing
         * those variables will not affect the variables outside the method call.
         * The term for this is 'passing by value' */
        int a = 10;
        method2(a);
        System.out.println(a == 10); //true
        String str = "str";
        method3(str);
        System.out.println(str.equals("str")); //true

        /** But objects will be retained and 'passed by reference' */
        int[] nrs = {1};
        method4(nrs);
        System.out.println(nrs[0] == 5); //true


    }

    public void method2(int a) {
        a = 1;
    }
    public void method3(String str) {
        str = "string";
    }
    public void method4(int[] args) {
        args[0] = 5;
    }

    class Superclass {
        int field = 1;
    }

    /** Generally it is bad practice to use same variable names in different scopes. */

    class InnerClass {
        /** Class local variable */
        int var1 = 0;

        void method() {
            /** Method local scope */
            int var1 = 0;
            var1 += 1;


            /** Inner class scope */
            this.var1 += 1;
            /** Outer class scope */
            var2 += 1;
            //this.var2 += 1; //Not found from inner class scope
            Variables.this.var2 += 1; //Accessing var2
            Variables.this.method(); //Also outer class methods can be called this way

            /** All outer class fields and methods are available for inner class, even private ones */
            privateInstanceVar +=1;

            InnerClass innerInstance = new Variables().new InnerClass();
            //innerInstance.var2 += 1; //Cant access outer class fields through instance of inner class
            }
    }

    class Subclass extends Superclass{
        int field = 2;

        public void fieldScope() {
            int field = 3;

            {
                /** Already defined in a scope */
                //int field = 0;
            }

            /** method local */
            field += 1;

            /** Instance local */
            this.field += 1;

            /** Superrclass field */
            super.field += 1;

        }
    }

}
