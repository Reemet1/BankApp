package com.prometheus.learning.multithreading;

import java.util.Random;

public class ProducerConsumer {

    void producerConsumer() {

        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();

    }


    class Message {

        private String message;
        private boolean empty = true;

        /** Used by Consumer thread */
        public synchronized String read() {

            while (empty) {
                try {
                    /** Since both read and write methods are synchronized and use the same lock,
                     *  when one thread acquires the lock and stays in a loop, the other thread
                     *  cannot call the method and Deadlock results. To avoid deadlock in this
                     *  situation, a wait() method is called in a loop to suspend that thread
                     *  and release the lock so that other thread can continue
                     */
                    wait();

                    /** Usually wait is called in a loop so that the condition for which it
                     *  was waiting for is checked again after the thread is notified, because
                     *  it could be possible that a thread is continued (notified for other
                     *  reason or interrupted, but the condition it is meant to wait for
                     *  is still false)
                     */
                } catch (InterruptedException e) {}
            }
            empty = true;
            /** After empty is set to true, a thread has to notify other threads that is waiting
             * so that it can continue looping (as a result (empty=true) loop is exited in write method)
             * notify() is used to notify a single random thread waiting, and notifyAll()
             * notifies all threads waiting (not recommended, can cause performance issues)
             */
            notifyAll();
            return message;
        }

        /** Used by Producer thread */
        public synchronized void write(String message) {
            while (!empty) {
                try {
                    /** Since both read and write methods are synchronized and use the same lock,
                     *  when one thread acquires the lock and stays in a loop, the other thread
                     *  cannot call the method and Deadlock results. To avoid deadlock in this
                     *  situation, a wait() method is called in a loop to suspend that thread
                     *  and release the lock so that other thread can continue
                     */
                    wait();
                } catch (InterruptedException e) {}
            }
            empty = false;
            this.message = message;
            /** After empty is set to true and message is written, a thread has to notify other threads that is waiting
             * so that it can continue looping (as a result (empty=false) loop is exited in read method)
             * notify() is used to notify a single random thread waiting, and notifyAll()
             * notifies all threads waiting (not recommended, can cause performance issues)
             */
            notifyAll();

        }

    }

    /** Consumer */
    class Reader implements Runnable {
        private Message message;

        public Reader(Message message) {
            this.message = message;
        }

        @Override
        public void run() {
            Random random = new Random();

            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {}


            String latestMessage = null;
            while(!(latestMessage = message.read()).equals("Finished writing")) {
                System.out.println("Reading " + latestMessage);
                try {
                    Thread.sleep(random.nextInt(2000));
                } catch (InterruptedException e) {}
            }

        }
    }
    /** Producer */
    class Writer implements Runnable {
        private Message message;

        public Writer(Message message) {
            this.message = message;
        }

        @Override
        public void run() {
            String[] messages = {"Message 1","Message 2","Message 3","Message 4","Message 5"};

            Random random = new Random();

            for(int i = 0; i < messages.length; i++) {
                message.write(messages[i]);
                try {
                    Thread.sleep(random.nextInt(2000));
                } catch (InterruptedException e){ }


            }

            message.write("Finished writing");

        }
    }

}
