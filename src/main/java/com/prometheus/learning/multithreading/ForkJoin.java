package com.prometheus.learning.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoin {


    /**
     * The fork/join framework is designed for work that can be broken into smaller pieces
     * recursively, allowing to take advantage of multiple processors. The fork/join framework
     * distributes tasks to worker treads in a thread pool, which employs a work-stealing algorithm. */
    public void forkJoins() {

        /** The main component of the fork/join framework is ForkJoinPool class,
         *  preserving thread pools and executing ForkJoinTask processes */

        /** ForkJoinPool is an implementation of an ExecutiveService interface, which
         *  differs from other implementations in that it employes a work-stealing algorithm*/

        /** Returns a common pool instance, the default thread for a ForkJoinTask */
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        /** Creates a ForkJoinPool with parallelism level equal to the number of available processors */
        forkJoinPool = new ForkJoinPool();

        /** Specific level of parallelism */
        forkJoinPool = new ForkJoinPool(2);


        /** ForkJoinTask is an abstract base class representing tasks running within a ForkJoinPool
         *  ForkJoinTask is a thread-like entity, but is more lightweight */

        /** RecursiveAction (returns a value) and RecursiveTask (doesn't return a value) are
         *  2 subclasses of ForkJoinClass.
         */

        MyAction action = new MyAction("Java");
        forkJoinPool.invoke(action); //Does not return anything

        MyTask task = new MyTask(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
        int result = forkJoinPool.invoke(task); //Has a return value


    }

    class MyAction extends RecursiveAction {

        String word;

        public MyAction(String word) {
            this.word = word;
        }

        protected void compute() {
            System.out.println("Executing task");

            if(word.length() <= 1) {
                System.out.println(word);
            }

            MyAction action1 = new MyAction(word.substring(0,word.length()/2));
            MyAction action2 = new MyAction(word.substring(word.length()/2, word.length()));

            //ForkJoinTask.invokeAll(action1, action2);
        }

    }

    class MyTask extends RecursiveTask<Integer> {

        List<Integer> ints;

        public MyTask(List<Integer> ints) {
            this.ints = ints;
        }

        protected Integer compute() {
            System.out.println("Executing task");

            if(ints.size() <= 1) {
                System.out.println(ints.size());
            }

            MyTask task1 = new MyTask(ints.subList(0, ints.size()/2));
            MyTask task2 = new MyTask(ints.subList(ints.size()/2, ints.size()));

            task1.fork();
            task2.fork();

            return task1.join() + task2.join();
        }

    }

}
