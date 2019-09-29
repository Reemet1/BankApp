package com.prometheus.learning.multithreading;

/**
 * A process is a unit of execution that has its own memory space (heap).
 * Examples: Java console application, JavaFX application.
 *
 * A Thread is a unit of execution within a process. Each process
 * can have multiple threads.In Java, every process has at least one thread - main thread.
 *
 * Each thread has a thread stack, which is a memory space only accessed by that thread.
 * Threads enable parallel execution of code, the term for this is concurrency.
 *
 */

public class Multithreading {

    public void multithreading() {
        System.out.println("Printing from main thread 1");

        /** It is up to the JVM to decide when a given thread is executed, though
         *  the execution priority can be set. In single core processors, the execution
         *  can jump from one thread to another. In multi core processors, multiple
         *  threads can execute code at the same time */
        Thread testThread = new TestThread();
        testThread.start();
        /** An instance of a thread cannot be start() more than once. A new instance
         * has to be created each time */
        //testThread.start(); //Throws IllegarThreadStateException
        /** Using run() instead of start() executes on the same thread, not in a new one. */
        //testThread.run();

        for(int i = 1; i <= 10; i++) {
            System.out.println("Counting in MAIN thread: " + i);
        }

        /** A thread can be created locally, but its run method has to be implemented right away */
        Thread quickThread = new Thread() {

            @Override
            public void run() {
                System.out.println("Running code in quickly created thread");
            }
        };
        quickThread.start();

        /** Creating anonymous thread class. Useful when the tasks executed by a thread
         *  must be run once. Anonymous thread has to start() upon creation */
        new Thread() {
            @Override
            public void run() {
                System.out.println("Anonymous thread");
            }
        }.start();

        /** Thread can be created by giving a Runnable object as a parameter */
        Thread runnableThread = new Thread(new TestRunnable());
        runnableThread.start();

        Thread runnableThreadSuper = new Thread(new TestRunnable(){
            @Override
            public void run() {
                    super.run(); //calls for TestRunnable's run()
                    //specific code to this run()
                }
        });

        /** Runnable anonymous class can be given as a parameter for Thread, but
         * run() has to be implemented */
        Thread anonRunnableThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running in thread created using anonymous Runnable object");
            }
        });
        anonRunnableThread.start();

        /** And also anonymous thread with anonymous Runnable object as parameter can be created */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running in anonymous thread using anonymous Runnable object");
            }
        }).start();


        /** NB! Implementing Runnable is more convenient way to multithreading than subclassing Threads.
         * Also many methods, especially lambda methods take Runnable as a parameter and
         * using Runnable is more flexible */

        /**
         * Multiple threads can share the same instance, in which case, when that instance
         * is modified in one thread, the modified instance is also in use in second thread
         * and vice versa. The term for this is 'thread interference'.
         * Race condition is when two threads modify the same resource.
         */

    }

    public void interruptingThreads() {
        Thread sleepingThread = new SleepingThread();
        sleepingThread.start();
        try {
            Thread.sleep(5000);
            sleepingThread.interrupt();
            /** Interrupting sleeping thread */
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Joining is a mechanism where one thread waits til another thread is terminated before continuing
     * If in thread1 thread2.join() is called, then thread1 waits for thread2 to complete
     */
    public void joiningThreads() {

        Thread runnableThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread 1 starting sleep");
                    Thread.sleep(5000);
                    System.out.println("Thread 1 sleep ended");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        runnableThread1.start();

        Thread runnableThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2 waiting for Thread 1 to complete");
                try {
                    runnableThread1.join();
                    //runnableThread1.join(10000); //To avoid freeze, maximum wait time can be set
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Waiting complete, continue with Thread 2");
            }
        });
        runnableThread2.start();

    }

    /** Separate thread class. Useful when the tasks executed by a thread
     *  must be run multiple times */
    class TestThread extends Thread {

        @Override
        public void run() {
            for(int i = 1; i <= 10; i++) {
                System.out.println("Counting in TEST thread: " + i);
            }
        }

    }

    /** Implementing Runnable class is a another way to create an independently running code.
     * In this case, the run() method has to be implemented */
    class TestRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("Running code in Runnable");
        }
    }

    class SleepingThread extends Thread {
        @Override
        public void run() {
            try {
                for(int i = 1; i <= 10; i++) {
                    System.out.println("Sleeping thread: " + i + "/10");
                    Thread.sleep(1000);
                    //sleep(1000); //calls for Thread.sleep also
                }

            } catch (InterruptedException e) {
                System.out.println("Another thread woke me up");
                return; //terminating
            }
        }
    }
}

