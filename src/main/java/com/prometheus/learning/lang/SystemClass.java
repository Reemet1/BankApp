package com.prometheus.learning.lang;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Properties;

/**
 * System class provides useful static methods and fields.
 */
public class SystemClass {

    public void systemClass() {

        /**
         * Important streams.
         * System.in grants input from the user (e.g keyboard).
         * System.out grants output to computer screen.
         * System.err grants red colored error stream to the computer screen.
         */
        InputStream inputStream = System.in;
        PrintStream outputStream = System.out;
        OutputStream outputStreamErr = System.err;

        /** It is also possible to set custom system intput and output streams */
        System.setIn(inputStream);
        System.setOut(outputStream);
        System.setErr(outputStream);

        /** System.getenv() returns Operating System level environment variables while
         *  System.getProperties() returns JVM arguments */
        Map<String, String> environmentProperties = System.getenv();
        Properties javaProperties = System.getProperties();

        /** Timestamps in milli- and nanoseconds */
        System.currentTimeMillis();
        System.nanoTime();

        System.getSecurityManager();
        System.console();

        System.gc(); //executed garbage collection

        System.runFinalization(); //runs finalize() methods on objects

        //System.exit(1); //exits the program



    }

}
