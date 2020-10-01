package com..rd.java.basic.practice5;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author beskorovajny
 */

public class Part1 {
    public static final Logger LOGGER = Logger.getLogger(Part1.class.getName());

    static class ThreadExtends extends Thread {

        @Override
        public void run() {
            while(true) {
                Demo.print(this.getName());

                try {
                    Thread.sleep(500);
                }catch(InterruptedException e) {
                    LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }


    }

    static class RunnableImpl implements Runnable {

        @Override
        public void run() {
            int i = 0;
            while(i < 4) {
                Demo.print(Thread.currentThread().getName());

                try {
                    Thread.sleep(500);
                }catch(InterruptedException e) {
                    LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
                    Thread.currentThread().interrupt();
                    break;
                }
                i++;

            }
        }

    }




    public static void main(String[] args) {
        ThreadExtends thread1 = new ThreadExtends();
        Thread thread2 = new Thread(new RunnableImpl());

        thread1.setName("Thread-1");
        thread2.setName("Thread-2");


        thread1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
            Thread.currentThread().interrupt();
        }
        thread1.interrupt();


        thread2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
            Thread.currentThread().interrupt();
        }
        thread2.interrupt();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
            Thread.currentThread().interrupt();
        }

        Thread.currentThread().interrupt();



    }

}

