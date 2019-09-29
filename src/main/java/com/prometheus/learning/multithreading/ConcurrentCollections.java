package com.prometheus.learning.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentCollections {

    public void concurrentCollections() {

        /** CopyOnWriteArrayList is a thread-safe variant of the ArrayList class,
         *  in which all mutative operations are implemented by making a copy of the underlying array */

        /** When an Iterator instance is created, it provides a snapshot state of the collection, which
         *  can not be modified by other threads, so ConcurrentModificationException will not occur.
         *  When an original collection is modified, the collection used in iterator is not modified */

        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        ((CopyOnWriteArrayList) copyOnWriteArrayList).addIfAbsent("Str");
        ((CopyOnWriteArrayList) copyOnWriteArrayList).addAllAbsent(new ArrayList<>(Arrays.asList("str1","str2")));

        /** Same effects as in ArrayList class */
        copyOnWriteArrayList.add("str");
        copyOnWriteArrayList.get(0);
        copyOnWriteArrayList.remove(0);
        copyOnWriteArrayList.clear();

    }

    public void cyclicBarrier() {

        /** CyclicBarrier is executed (tripped), when a specified number of threads
         *  has called await() on it */

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("Barrier thread limit reached, executing task");
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                    System.out.println("Await complete");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                    System.out.println("Await complete");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Runnable action = () -> System.out.println("Barrier tripped");
        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2, action);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    /** Waits for a maximum of 1 second for barrier to trip and then continues */
                    cyclicBarrier1.await(1, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
