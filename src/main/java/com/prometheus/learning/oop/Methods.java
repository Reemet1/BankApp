package com.prometheus.learning.oop;

import java.util.ArrayList;
import java.util.List;

public class Methods {

    /** Methods contain operations which for a unit of work within a program (functions).
     *  Method naming has the same rules as naming variables */
    public void methods() {

        List<String> list1 = new ArrayList<>();
        List<String> list2 = list1;

        method1(list1);

        System.out.println(list1);

    }

    public void method1(List<String> list) {
        list.add("str");
    }


    /** access modifier - nonaccess modifiers - return type - method name (parameters) {body}
     *  access and nonaccess modifiers can have any order with each other*/
    public static final int methodName(String param1, int param2) throws Exception {
        //method body
        return 1;

        /** Returning a value is mandatory, if a method has non-void return type */
    }

    public void voidMethod() {
        //return 1; //compilation error
        /** In void method, a return; can be used to exit the method. But in a method
         * that returns a value, a return has to end with a value to be returned */
        return;

    }

    /** Methods with Object return type can return null */
    public String strMethod() {
        return null;
    }

    /** Null cannot be returned when return type is primitive */
    public int intMethod() {
        //return null;
        return 0;
    }

    public String strMethod2(int a) {

        /** Doesn't guarantee that 1 will be returned */
        if(a == 1) {
            return "1";
        }

        /** Have to add another return so it is certain that a value will be returned */
        return "2";
    }


    public int exceptionMethod() {

        try {
            return 1;
        } catch (Exception e) {

        }
        return 2;

    }

    /** Parameters must be separated with commas, not with semicolons */
    public void paramMethod(int a, int b) {}

    public void varArgs1(String... args) {
        /** Varargs is treated as an array */
        String[] strArgs = args;
        /** varargs arguments dont have to be passed */
        varArgs2("str1", "str2");
    }

    public void varArgs2(String a, String b, String... args) {

        /** For varargs it is possible to pass both array and elements as separate arguments */
        varArgs1(new String[]{"Str1", "Str2"});
        varArgs1("Str1", "Str2");
        /** Varargs method can also be called without varargs arguments, and
         * in that case a default empty array (not null) will be created */
        varArgs1();

        /** Passing null does not create and empty array */
        varArgs1(null);
    }

    /** Varargs have to be the last arguments */
    //public void varArgs3(String... args, int a){}
    //public void varArgs4(String... args1, int... args2){}

    public void varArgs3(int... args) {}
    /** When valling varArgs3(1), then a single parameter method is called */
    public void varArgs3(int a){}
}
