package com.prometheus.learning.basics.modifiers;

/** Top level class must be public or without modifier, for which this class
 * is visible only to classes in the same package */
public class AccessModifiers {

    /** There are 4 access modifiers: public, protected, private, and default.
     * Access modifiers can be applied to methods, variables, constructors
     * and inner classes (also abstract inner classes and interfaces) */

    /** can be accessed from any class */
    public int publicVar;

    /** can be accessed only from subclasses of this class or classes in the same package */
    protected int protectedVar;

    /** can only be accessed from this class */
    private int privateVar;

    /** default - can be accessed from classes in the same package */
    int var;

    interface InnerInterface {
        /** All instance variables in an interface are implicitly public static final
         * and all methods in an interface are implicitly public*/
        public int a = 10;
        int b = 20;
        public void method();
    }

}
