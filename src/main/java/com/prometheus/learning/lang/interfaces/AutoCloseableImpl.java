package com.prometheus.learning.lang.interfaces;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * An object that may hold test (such as file or socket handles) until it is closed.
 * The close() method of an AutoCloseable object is called automatically when exiting a try-with-test block
 * for which the object has been declared in the resource specification header.
 * This construction ensures prompt release, avoiding resource exhaustion exceptions and errors
 * that may otherwise occur.
 */
public class AutoCloseableImpl implements AutoCloseable {

    InputStream in;
    OutputStream out;

    public void testAutoClose() throws Exception {

        try(AutoCloseableImpl autoCloseable = new AutoCloseableImpl()) {
            System.out.println("Exiting try block");
        }

    }

    /**
     * implementers are strongly encouraged to declare concrete implementations
     * of the close method to throw more specific exceptions.
     * Cases where the close operation may fail require careful attention by implementers.
     */
    @Override
    public void close() throws Exception {
        System.out.println("Closing streams");

        if(in != null) {
            in.close();
            in = null;
        }
        if(out != null) {
            out.close();
            out = null;
        }
    }
}
