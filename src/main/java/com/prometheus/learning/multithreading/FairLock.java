package com.prometheus.learning.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class FairLock {

    /** Static lock is shared among all threads. ReentrantLock lets to define
     *  whether is is a fair lock or not by setting the fair value in a constructor */
    private static ReentrantLock lock = new ReentrantLock(true);

    /**
     * Fair locks are first-come-first-serve locks
     */
    public void fairLiveLocks() {

        /** Thread priority is taken only a suggestion by the JVM, and the
         *  actual order of execution could be different
         */

        Thread t1 = new Thread(new Worker(), "Priority 10 thread");
        t1.setPriority(10);
        Thread t2 = new Thread(new Worker(), "Priority 8 thread");
        t2.setPriority(8);
        Thread t3 = new Thread(new Worker(), "Priority 6 thread");
        t3.setPriority(6);
        Thread t4 = new Thread(new Worker(), "Priority 4 thread");
        t4.setPriority(4);
        Thread t5 = new Thread(new Worker(), "Priority 2 thread");
        t5.setPriority(2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();



    }

    class Worker implements Runnable {

        private int runCount = 1;

        @Override
        public void run() {
            for(int i = 1; i <= 100; i++) {
                lock.lock();
                try {
                    System.out.format("%s run count = %d \n",
                            Thread.currentThread().getName(), runCount++);
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
