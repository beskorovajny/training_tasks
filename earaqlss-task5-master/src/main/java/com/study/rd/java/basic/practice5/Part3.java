package com..rd.java.basic.practice5;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author beskorovajny
 */
public class Part3 {
    private static final Logger LOGGER = Logger.getLogger(Part3.class.getName());

    private int counter;
    private int counter2;

    private final int numberOfThreads;
    private final int numberOfIterations;

    public Part3(int numberOfThreads, int numberOfIterations) {
        this.numberOfThreads = numberOfThreads;
        this.numberOfIterations = numberOfIterations;
    }

    public static void main(final String[] args) {
        Part3 part3 = new Part3(2, 5);
        part3.compare();
        part3.compareSync();
    }


    public void compare() {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            threadList.add(new CountThread());
        }
        threadAction(threadList);
    }

    private class CountThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < numberOfIterations; i++) {
                Demo.print((counter++) + " == " + counter2);
                try {
                    Thread.sleep(100);
                    counter2++;
                } catch (InterruptedException e) {
                    LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private class CountSyncThread extends Thread {
        private final Object lock;
        public CountSyncThread(Object lock){
            this.lock = lock;
        }
        @Override
        public void run() {
            synchronized (lock) {
                int i = 0;
                while (i < numberOfIterations) {
                    Demo.print(counter++ + " == " + counter2);
                    try {
                        Thread.sleep(100);
                        counter2++;
                    } catch (InterruptedException e) {
                        LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
                        Thread.currentThread().interrupt();
                    }
                    i++;
                }
            }
        }
    }

    public void compareSync() {
        List<Thread> threads = new ArrayList<>();
        Object lock = new Object();
        for (int i = 0; i < numberOfThreads; i++) {
            threads.add(new CountSyncThread(lock));
        }
        threadAction(threads);
    }

    private void threadAction(List<Thread> threads) {
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
                Thread.currentThread().interrupt();
            }
        }
        counter = 0;
        counter2 = 0;
    }

}
