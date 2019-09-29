package com.prometheus.learning.lang.interfaces;

/**
 * Runnable objects can execute code concurrently with other threads of the program.
 * The class should implement Runnable instead of Thread is the class only
 * overrides the run() method, otherwise it should implement Thread.
 */
public class RunnableImpl implements Runnable {

    /**
     * The execution of a runnable object begins here, invoked by thread.start().
     */
    @Override
    public void run() {
        System.out.println("Runnable instance");
    }


    public void testRunnable() {
        Thread thread = new Thread(new RunnableImpl());
        thread.start();
    }
}
