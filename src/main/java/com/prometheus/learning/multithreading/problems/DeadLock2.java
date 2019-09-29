package com.prometheus.learning.multithreading.problems;

public class DeadLock2 {

    /**
     * Possible scenarios:
     * 1) Thread1 enters data.updateData() and writes to the console, then suspends.
     * 2) Thread2 enters display.updateDisplay() and writes to the console, then suspends.
     * 3) Thread1 runs and tries to call display.dataChanged(), but Thread2 is still running
     *    display.updateDisplay(), so it's holding the lock on the Display object. Thread1 blocks.
     * 4) Thread2 runs and tries to call data.getData(), but Thread1 is still running
     *    data.updateData(), so Thread2 blocks.
     *
     *    This deadlock is caused by circular reference.
     */

    public void deadLock() {

        Data data = new Data();
        Display display = new Display();
        data.setDisplay(display);
        display.setData(data);

        new Thread(new Runnable() {
            @Override
            public void run() {
                data.updateData();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                display.updateDisplay();
            }
        }).start();


    }

    class Data {

        private Display display;

        public void setDisplay(Display display) {
            this.display = display;
        }

        public synchronized void updateData() {
            System.out.println("Updating data...");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}

            display.dataChanged();
        }

        public synchronized Object getData() {
            return new Object();
        }

    }

    class Display {

        private Data data;

        public void setData(Data data) {
            this.data = data;
        }

        public synchronized void dataChanged() {
            System.out.println("The data has been changed");
        }

        public synchronized void updateDisplay() {
            System.out.println("Updating display..");
            Object o = data.getData();
        }

    }

}
