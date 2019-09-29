package com.prometheus.learning.multithreading.problems;

public class DeadLock1 {

    public Object lock1 = new Object();
    public Object lock2 = new Object();

    public void deadLock() {

        /** Deadlock in this example occurs before thread1 obtains lock1, then sleeps while thread2
         *  obtains lock2 and proceeds to wait for lock1. When thread1 wakes and proceeds
         *  to wait for lock2, both threads get stuck in a deadlock waiting for each other's
         *  locks to be released. These could happen in the same method or also
         *  in different classes and methods.
         *
         *  There are 2 possible solutions for deadlocks:
         *  1) Thread obtains one lock at a time, but this is very limiting in applications, better is
         *  2) Threads obtain locks in the same order
         */
        System.out.println("------------ FIXED THREADS 1 -------------");
        Thread fixedThread1 = new FixedThread1();
        Thread fixedThread2 = new FixedThread2();
        fixedThread1.start();
        fixedThread2.start();

        try {
            fixedThread1.join();
            fixedThread2.join();
        } catch (InterruptedException e) {

        }

        System.out.println("------------ FIXED THREADS 2 -------------");
        Thread fixedThread3 = new FixedThread3();
        fixedThread3.setName("FixedThread 3");
        Thread fixedThread4 = new FixedThread3();
        fixedThread4.setName("FixedThread 4");
        fixedThread3.start();
        fixedThread4.start();

        try {
            fixedThread3.join();
            fixedThread4.join();
        } catch (InterruptedException e) {

        }


        System.out.println("------------ DEADLOCKING THREADS -------------");
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread2();
        thread1.start();
        thread2.start();


    }

    class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1 has lock 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}

                System.out.println("Thread 1 waiting for lock 2");
                synchronized (lock2) {
                    System.out.println("Thread 1 has lock 1 and lock 2");
                }
                System.out.println("Thread 1 released lock 2");
            }
            System.out.println("Thread 1 released lock 1");


        }
    }

    class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("Thread 2 has lock 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}

                System.out.println("Thread 2 waiting for lock 1");
                synchronized (lock1) {
                    System.out.println("Thread 2 has lock 1 and lock 2");
                }
                System.out.println("Thread 2 released lock 1");
            }
            System.out.println("Thread 2 released lock 2");


        }
    }

    class FixedThread1 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("FixedThread 1 has lock 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}

                System.out.println("FixedThread 1 waiting for lock 2");
                synchronized (lock2) {
                    System.out.println("FixedThread 1 has lock 1 and lock 2");
                }
                System.out.println("FixedThread 1 released lock 2");
            }
            System.out.println("FixedThread 1 released lock 1");


        }
    }

    class FixedThread2 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("FixedThread 2 has lock 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}

                System.out.println("FixedThread 2 waiting for lock 2");
                synchronized (lock2) {
                    System.out.println("FixedThread 2 has lock 1 and lock 2");
                }
                System.out.println("FixedThread 2 released lock 2");
            }
            System.out.println("FixedThread 2 released lock 1");


        }
    }

    class FixedThread3 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName()+" has lock 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}

                System.out.println(Thread.currentThread().getName()+" releasing lock 1");
            }

            System.out.println(Thread.currentThread().getName()+" waiting for lock 2");
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName()+" has lock 2");
                System.out.println(Thread.currentThread().getName()+" releasing lock 2");
            }

        }
    }

}
