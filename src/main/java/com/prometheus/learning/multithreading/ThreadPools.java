package com.prometheus.learning.multithreading;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Implementations of ExecuteService interfaces manages runnable tasks.
 * They optimize the creation an scheduling of threads. The runnable objects
 * still have to be provided to the service though. ExecutiveService implementations
 * make use of thread pools, which are managed set of threads. Thread pool may
 * may limit the number of threads used, so new tasks might have to wait in queue.
 *
 */

public class ThreadPools {

    public void threadPools() {

        /** ArrayBlockingQueue is thread-safe, so MyProducer and MyConsumer classes
         * can be cleaned out of locking mechanisms, since operations on buffer done
         * in these classes is thread-safe.
         */
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);
        //ReentrantLock bufferLock = new ReentrantLock();

        /** ExecutorService extends Executor interface. Executors help to decouple
         *  task execution from task submition */
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Executor singleThreadExecutor = Executors.newSingleThreadExecutor();

        /*MyProducer myProducer = new MyProducer(buffer, bufferLock);
        MyConsumer myConsumer1 = new MyConsumer(buffer, bufferLock);
        MyConsumer myConsumer2 = new MyConsumer(buffer, bufferLock);*/

        MyProducer myProducer = new MyProducer(buffer);
        MyConsumer myConsumer1 = new MyConsumer(buffer);
        MyConsumer myConsumer2 = new MyConsumer(buffer);

        /** Callable is similar to Runnable but returns a result object */
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return "result";
            }
        };

        executorService.submit(callable);

        /** executorService.execute(runnableObj) is equivalent to new Thread(runnable).start() */
        /** execute() method does not return anything */
        executorService.execute(myProducer);
        executorService.execute(myConsumer1);
        executorService.execute(myConsumer2);

        /** Submit method returns a Future object */
        executorService.submit(myProducer);
        executorService.submit(myConsumer1);
        executorService.submit(myConsumer2);
        /*new Thread(myProducer, "Producer").start();
        new Thread(myConsumer1,"Consumer 1").start();
        new Thread(myConsumer2,"Consumer 2").start(); */

        /** invokeAll() returns a List of Futures of all the submitted tasks when completed.
         *  The argument collection must contain Callable objects, not Runnable.
         *  The order of Futures in a returned collection is in the same order
         *  as the tasks are in argument collection */
        //executorService.invokeAll(new ArrayList<>());

        /** invokeAny() returns the Future of the first completed task in a given collection
         *  The argument collection must contain Callable objects, not Runnable*/
        //executorService.invokeAny(new ArrayList<>());


        /** Future object represents the result of a asynchronous computation */
        /** In the current case, the callable task will be run after other tasks have finished because
         * this executorService has a maximum of 3 threads. */
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("This is printed from Callable class");
                Thread.sleep(10000);
                return "Returned result from Callable";
            }
        });


        try {
            /** future.get() will block until the call() returns a result */
            String result = future.get();
            System.out.println(result);
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task was interrupted");
        }

        /** The application will be running even when all services have been executed, because
         *  the executor itself is not terminated. The shutdown() method waits til all
         *  tasks are executed and the shuts down the executorService. */
        //executorService.shutdown();
        ((ExecutorService) singleThreadExecutor).shutdownNow();
        executorService.shutdownNow();

        /** shutdown() will continue execution of already submitted tasks, but will not
         *  accept new tasks, while shutdownNow() attempts to close currently running tasks
         */
    }

    class MyProducer implements Runnable {
        private ArrayBlockingQueue<String> buffer;

        public MyProducer(ArrayBlockingQueue<String> buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            Random random = new Random();
            String[] nums = {"1","2","3","4","5"};

            for(String num : nums) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": Adding num " + num);
                    /** Used instead of arrayList.add(), since add() can throw exceptions */
                    buffer.put(num);
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted");
                }
            }
            System.out.println(Thread.currentThread().getName() + " - Adding EOF and exiting");

            try {
                /** Can throw InterruptedException because put() will block
                 *  when the thread doesn't have the lock or buffer is full.*/
                buffer.put("EOF");
            } catch (InterruptedException e) {}


        }
    }

    class MyConsumer implements Runnable {

        private ArrayBlockingQueue<String> buffer;

        public MyConsumer(ArrayBlockingQueue<String> buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {

            while(true) {
                /** The code might still have to be syncrhonized, because buffer.peek() might return null */
                synchronized (buffer) {
                    try {
                        if(buffer.isEmpty()) {
                            continue;
                        }
                        /** peek() used instead of arrayList.get() */
                        if(buffer.peek().equals("EOF")) {
                            System.out.println(Thread.currentThread().getName() + " - EOF.. Exiting");
                            break;
                        } else {  /** take() is used instead of arrayList.remove() */
                            /** Since ArrayBlockingQueue is first-in-first-out, the remove index doesnt have to be specificed as 0 */
                            System.out.println(Thread.currentThread().getName() + " - Removed " + buffer.take());
                        }
                    } catch (InterruptedException e) {}
                }

            }

        }
    }

}
