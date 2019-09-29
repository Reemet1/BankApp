package com.prometheus.learning.multithreading.problems;

public class LiveLock {


    /**
     * Livelock is similar to deadlock, but instead of blocking behind lock, the
     * lock is released to other thread and vice versa indefinetly.
     */
    public void liveLock() {

        Worker worker1 = new Worker("Worker 1", true);
        Worker worker2 = new Worker("Worker 2", true);

        SharedResource sharedResource = new SharedResource(worker1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker1.work(sharedResource, worker2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker2.work(sharedResource, worker1);
            }
        }).start();

    }

    class SharedResource {

        private Worker owner;

        public SharedResource(Worker owner) {
            this.owner = owner;
        }

        public Worker getOwner() {
            return owner;
        }

        public synchronized void setOwner(Worker owner) {
            this.owner = owner;
        }

    }

    class Worker {
        private String name;
        private boolean active;

        public Worker(String name, boolean active) {
            this.name = name;
            this.active = active;
        }

        public synchronized void work(SharedResource sharedResource, Worker otherWorker) {

            while(active) {
                if(sharedResource.getOwner() != this) {
                    try {
                        wait(100);
                    } catch (InterruptedException e) {}
                    continue;
                }
                if(otherWorker.isActive()) {
                    System.out.println(getName() + ": give the resource to the worker " + otherWorker.getName());
                    sharedResource.setOwner(otherWorker);
                    continue;
                }

                System.out.println(getName() + ": working on a common resource");
                active = false;
                sharedResource.setOwner(otherWorker);


            }
        }

        public String getName() {
            return name;
        }

        public boolean isActive() {
            return active;
        }

    }

}
