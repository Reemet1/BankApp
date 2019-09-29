package com.prometheus.learning.multithreading.problems;

public class DeadLock3 {

    /**
     * Possible scenarios:
     * 1) Thread 1 acquires the lock on Person1 and enters the sayHello() method. It prints to the console, then suspends.
     * 2) Thread 2 acquires the lock on Person2 and enters the sayHello() method. It prints to the console, then suspends.
     * 3) Thread 1 runs again and wants to say hello back to Person2.
     *    It tries to call the sayHelloBack() using the Person1 object that was passed into the sayHello() method,
     *    but Thread 2 is holding the Person2 lock, so Thread1 suspends.
     * 4) Thread 2 runs again and wants to say hello back to Person1.
     *    It tries to call the sayHelloBack() using the Person2 object that was passed into the sayHello() method,
     *    but Thread 1 is holding the Person1 lock, so Thread2 suspends.
     *
     *    This type of deadlock could happen when objects are being passed as parameters
     */

    public void deadLock() {

        System.out.println("------ WORKING ON SAME THREAD ------");
        PolitePerson person1 = new PolitePerson("Person 1");
        PolitePerson person2 = new PolitePerson("Person 2");
        person1.sayHello(person2);
        person2.sayHello(person1);

        System.out.println("------ DEADLOCK ON DIFFERENT THREADS ------");
        new Thread(new Runnable() {
            @Override
            public void run() {
                person1.sayHello(person2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                person2.sayHello(person1);
            }
        }).start();

    }


    class PolitePerson {

        private final String name;

        public PolitePerson(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void sayHello(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello to me %n",
                    this.name, person.getName());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}

            person.sayHelloBack(this);
        }

        public synchronized void sayHelloBack(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello back to me %n",
                    this.name, person.getName());
        }
    }

}
