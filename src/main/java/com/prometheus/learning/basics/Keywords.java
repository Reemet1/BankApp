package com.prometheus.learning.basics;

import java.io.File;

public class Keywords {

    /** access modifiers */
    public int a; protected int b; private int c;

    /** non-access modifiers */
    static int d; final int e = 1; volatile int f; transient int g;

    enum Enum{}

    public void keywords() throws RuntimeException{

        /** primitives */
        byte a; short b; char c; int d; long e; float f; double g; boolean h;

        if(true){}
        else if(false){}
        else ;

        switch("a"){case "b": default: }

        for(int i = 0; i < 10; i++) {
            continue;
        }

        synchronized (""){}

        try {
            throw new RuntimeException();
        } catch (Exception ex) {
        } finally {}

        do {
            break;
        } while ("a".isEmpty());


        File file = new File("");

        assert true;

        boolean inst = "" instanceof String;

    }

    interface Interface {}
    abstract class AbstractClass{}
    class Class extends AbstractClass implements Interface {

        void m() {
            this.toString();
            super.toString();

            return;
        }
    }

}
