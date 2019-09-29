package com.prometheus.learning.multithreading.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadInterference {

    public void threadInterference() {

        List<String> buffer = new ArrayList<>();
        MyProducer myProducer = new MyProducer(buffer);
        MyConsumer myConsumer1 = new MyConsumer(buffer);
        MyConsumer myConsumer2 = new MyConsumer(buffer);

        new Thread(myProducer, "Producer").start();
        new Thread(myConsumer1,"Consumer 1").start();
        new Thread(myConsumer2,"Consumer 2").start();

    }

    class MyProducer implements Runnable {
        private List<String> buffer;

        public MyProducer(List<String> buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            Random random = new Random();
            String[] nums = {"1","2","3","4","5"};

            for(String num : nums) {

                try {
                    System.out.println(Thread.currentThread().getName() + ": Adding num " + num);
                    synchronized (buffer) {
                        buffer.add(num);
                    }
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted");
                }

            }
            System.out.println(Thread.currentThread().getName() + " - Adding EOF and exiting");
            synchronized (buffer) {
                buffer.add("EOF");
            }

        }
    }

    class MyConsumer implements Runnable {

        private List<String> buffer;

        public MyConsumer(List<String> buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            while(true) {
                synchronized (buffer) {
                    if(buffer.isEmpty()) {
                        continue;
                    }
                    if(buffer.get(0).equals("EOF")) {
                        System.out.println(Thread.currentThread().getName() + " - EOF.. Exiting");
                        break;
                    } else {
                        System.out.println(Thread.currentThread().getName() + " - Removed " + buffer.remove(0));
                    }
                }

            }
        }
    }

}
