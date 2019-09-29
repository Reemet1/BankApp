package com.prometheus.learning.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronized blocks have multiple drawbacks:
 * 1) Threads that are blocked waiting for a lock can't be interrupted, they are
 *    blocked until they get the lock they are waiting on.
 * 2) Synchronized block must be within the same method
 * 3) It cannot be tested whether an object's intrinsic lock is available or
 *    find out any other information about that lock.
 * 4) A thread cannot timeout after it has waited for a lock for a certain time
 * 5) When multiple threads are waiting on the same lock, the lock is not aqcuired by
 *    first-come-first-server, that means that when a thread blocks on a given lock first
 *    does not mean that it will acquire the lock first.
 *
 *    To get through those drawbacks, an objects that implement a Lock interface can be used
 *    for locking mechanism, while gaining the previously named functionalities.
 */

public class ReentrantLockUnlock {

    public void reentrantLockUnlock() {

        List<String> buffer = new ArrayList<>();

        /** Reentrant means that a thread can obtain this lock multiple times */
        ReentrantLock bufferLock = new ReentrantLock();
        MyProducer myProducer = new MyProducer(buffer, bufferLock);
        MyConsumer myConsumer1 = new MyConsumer(buffer, bufferLock);
        MyConsumer myConsumer2 = new MyConsumer(buffer, bufferLock);

        new Thread(myProducer, "Producer").start();
        new Thread(myConsumer1,"Consumer 1").start();
        new Thread(myConsumer2,"Consumer 2").start();

    }

    class MyProducer implements Runnable {
        private List<String> buffer;
        private ReentrantLock bufferLock;

        public MyProducer(List<String> buffer, ReentrantLock bufferLock) {
            this.buffer = buffer;
            this.bufferLock = bufferLock;
        }

        @Override
        public void run() {
            Random random = new Random();
            String[] nums = {"1","2","3","4","5"};

            for(String num : nums) {

                try {
                    System.out.println(Thread.currentThread().getName() + ": Adding num " + num);

                    bufferLock.lock();
                    buffer.add(num);
                    bufferLock.unlock();

                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted");
                }

            }
            System.out.println(Thread.currentThread().getName() + " - Adding EOF and exiting");

            buffer.add("EOF");


        }
    }

    class MyConsumer implements Runnable {

        private List<String> buffer;
        private ReentrantLock bufferLock;

        public MyConsumer(List<String> buffer, ReentrantLock bufferLock) {
            this.buffer = buffer;
            this.bufferLock = bufferLock;
        }

        @Override
        public void run() {
            /** The thread can acquire a lock multiple times, and these will be counted. In order
             *  for the lock to be fully unlocked (so other thread can obtain it), the number of
             *  unlock() must be equal to lock(), that's why below there are multiple unlock()-s.
             *  This way of dealing with locks is not recommended, since unlock() calls
             *  may become overly scattered in the code and when an exception would occur
             *  before the unlock, it would not be called. Better way is using
             *  try-finally blocks to handle locks and unlocks.
             */
            /*while(true) {
                bufferLock.lock();
                if(buffer.isEmpty()) {
                    bufferLock.unlock();
                    continue;
                }
                if(buffer.get(0).equals("EOF")) {
                    System.out.println(Thread.currentThread().getName() + " - EOF.. Exiting");
                    bufferLock.unlock();
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + " - Removed " + buffer.remove(0));
                }
                bufferLock.unlock();
            } */

            /** A try-finally block ensures that a corresponding unlock() is called each time,
             *  whether there is an exception or the loop will be continued or breaked -
             *  the finally block and this an unlock() method in it is always executed */
            while(true) {
                bufferLock.lock();
                try {
                    if(buffer.isEmpty()) {
                        continue;
                    }
                    if(buffer.get(0).equals("EOF")) {
                        System.out.println(Thread.currentThread().getName() + " - EOF.. Exiting");
                        break;
                    } else {
                        System.out.println(Thread.currentThread().getName() + " - Removed " + buffer.remove(0));
                    }
                } finally {
                    bufferLock.unlock();
                }
            }

            /** A thread can first check whether a lock is available and
             *  proceed with different actions accordingly. If tryLock() returns true,
             *  the lock is acquired automatically. */
            if(bufferLock.tryLock()) {
                System.out.println(Thread.currentThread().getName() + ": Lock was available. Acquiring the lock and doing some actions");
            } else {
                System.out.println(Thread.currentThread().getName() + ": The lock was unavailable. Proceeding with alternative actions");
            }

            /** Trying to unlock a lock that is not acquired results in an exception.
             *  Also when the same lock has been aqcuired over the limit times
             *  there will be an exception.
             */
        }
    }

}

