package com.prometheus.learning.multithreading;

public class Synchronisation {


    public void synchronisation() {

        /** Thread interference happens, because both threads use the same resource 'counter' */
        System.out.println("----------------- THREAD INTERFERENCE -----------------");
        Counter counter = new Counter();
        Thread counterThread1 = new Thread(new CounterThread(counter));
        counterThread1.setName("Thread 1");
        Thread counterThread2 = new Thread(new CounterThread(counter));
        counterThread2.setName("Thread 2");
        counterThread1.start();
        counterThread2.start();

        while(counterThread1.isAlive() || counterThread2.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        /** To get rid of thread interference (race condition), both threads can
         * have their own instance of counter */
        System.out.println("------------------- SEPARATE COUNTER INSTANCES -----------------");
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        counterThread1 = new Thread(new CounterThread(counter1));
        counterThread1.setName("Thread 1");
        counterThread2 = new Thread(new CounterThread(counter2));
        counterThread2.setName("Thread 2");
        counterThread1.start();
        counterThread2.start();

        while(counterThread1.isAlive() || counterThread2.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        /** In many cases it is still necessary for multiple threads to access and modify the
         *  same resource, e.g a bank account. In such cases the shared resources can be
         *  synchronized so that only one thread can access a shared resource at a time. */

        System.out.println("---------------- SYNCHRONIZED COUNTER METHOD -------------------");
        counterThread1 = new Thread(new SyncedCounterThread(counter));
        counterThread1.setName("Thread 1");
        counterThread2 = new Thread(new SyncedCounterThread(counter));
        counterThread2.setName("Thread 2");
        counterThread1.start();
        counterThread2.start();

        while(counterThread1.isAlive() || counterThread2.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /** Counting in a synchronized block */

        System.out.println("---------------- COUNTER IN SYNCHRONIZED BLOCK -------------------");
        counterThread1 = new Thread(new LockCounterThread(counter));
        counterThread1.setName("Thread 1");
        counterThread2 = new Thread(new LockCounterThread(counter));
        counterThread2.setName("Thread 2");
        counterThread1.start();
        counterThread2.start();

        /** Static methods can also be synchronized, in which the lock used is
         * owned by the class object associated with the object's class.
         * Also synchronization is 'reentrant', which means, when a thread
         * has aqcuired a lock, it can also acquire the same lock on some other place.
         * A thread can acquire a lock it already owns.
         */

        /** A critical section is a block of code that contains reference variables that
         *  are accessible to other threads. When all the critical sections in a program
         *  are syncrhonized, the program is said to be 'thread safe', since no
         *  thread interference can occur.
         */

        /** Some collections are thread-safe (synchronized) while others arent
         *  1) ArrayList is NOT thread-safe
         *  2) Vector class IS synchronized
         *  */

    }


    class Counter {

        int i;

        /** Constructors cant be synchronized */

        void count() {
            for(i = 10; i > 0; i--) {
                System.out.println(Thread.currentThread().getName() + " count " + i);
            }
        }

        /** Only one thread can access a synchronized method at a time. A synchronized method
         *  aquires an intrinsic lock of that instance which is used to call the method */
        synchronized void syncCount() {
            for(i = 10; i > 0; i--) {
                System.out.println(Thread.currentThread().getName() + " count " + i);
            }
        }

        void lockCount() {

            /** Synchronization can also be applied to blocks, in which case
             * the first thread that enters the block acquires an object's intrinsic lock
             * and other threads are suspended before the block.
             * When the thread has released an object's intrinsic lock, some other thread
             * can acquire it. Synchronized blocks allow more control over
             * what is being synchronized.
             */

            /** An instrinsic lock used has to be accessible to other threads, because thread
             *  local lock objects (local variables) are not applied to other threads so the
             *  block is not synchronized from them. A good choice is to use the instance
             *  itself (this keyword), since its shared among threads. */
            synchronized (this){
                for(i = 10; i > 0; i--) {
                    System.out.println(Thread.currentThread().getName() + " count " + i);
                }
            }

        }
    }

    class CounterThread implements Runnable{

        Counter counter;
        CounterThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.count();
        }
    }

    class SyncedCounterThread implements Runnable{

        Counter counter;
        SyncedCounterThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.syncCount();
        }
    }

    class LockCounterThread implements Runnable{

        Counter counter;
        LockCounterThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.lockCount();
        }
    }
}
