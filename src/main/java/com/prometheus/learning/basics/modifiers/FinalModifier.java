package com.prometheus.learning.basics.modifiers;

import java.util.ArrayList;
import java.util.List;

/** Classes declared as final cannot be subclassed. Abstract classes and interfaces cannot be
 * declared as final, since they have to be subclassed */
public final class FinalModifier {

    /** Final fields can only be initialized once. Initialization could be done along
     * with declaration or after the declaration, but could not be left uninitialized.
     * Uninitialized final variables have to be initialized in every constructor,
     * or in initialization block */
    public final int finalField1 = 0;
    public final String finalField2;
    //public final int finalField3; //error, might not have been initialized
    public final List<String> list = new ArrayList<>();

    /** error, might not have been initialized, cannot be initialized in a constructor,
     * has to be initialized in a static initializer block. */
    //public static final int finalField4;
    public static final int finalField4 = 10;

    public FinalModifier() {
        //finalField2 = null; //can be set to null when initializing
        finalField2 = "str";
        //finalField2 = "str2"; //once a final field is initialized, it cannot be changed
        //finalField2 = null; //cannot set to null after initializing

        /** a final object can be modified, but its reference cannot be changed */
        list.add("str");

        /** final variables can be defined locally and dont have to be initialized right away */
        final int a = 10;
        final int b;

    }

    /** final keyword can be used in method parameter */
    public void method(final String finalStr) {
        //finalStr = "abc";
    }


    //public final FinalModifier(int a) {} //Constructors cannot be declared final

    class Superclass {
        final void finalMethod() {

        }
    }

    class Subclass extends Superclass{

        /** Methods declared as final cannot be overridden */
        //void finalMethod() { }
    }
}
