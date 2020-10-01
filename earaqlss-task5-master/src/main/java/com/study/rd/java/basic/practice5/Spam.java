package com..rd.java.basic.practice5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author beskorovajny
 */
public class Spam {
    private static final Logger LOGGER = Logger.getLogger(Spam.class.getName());


    private final Thread[] threads;
    private final String[] messages;
    private final int[] delays;

    public Spam(String[] messages, int[] delays) {
        this.messages = messages;
        this.delays = delays;
        this.threads = new Thread[messages.length];
    }

    public static void main(final String[] args) {
        String[] messages = new String[] { "@@@", "bbbbbbb" };
        int[] delays = new int[]{ 333, 222};
        Spam spam = new Spam(messages, delays);
        spam.start();
        spam.send();
        spam.stop();
    }

    public void start() {
        for (int index = 0; index < messages.length; index++) {
            String message = messages[index];
            int delay = delays[index];
            Thread thread = new Breaker(message, delay);
            threads[index] = thread;
            thread.start();
        }
    }

    public void stop() {

        for (Thread thread : threads) {
            thread.interrupt();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
                Thread.currentThread().interrupt();
            }
        }
    }

    private void send() {
        int i = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!(Objects.equals("",bufferedReader.readLine()))) { i++; }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, (Demo.EXCEPTION_MESSAGE + i), e);
        }
    }

    public static class Breaker extends Thread {
        private final String message;
        private final int timer;

        public Breaker(String message, int timer) {
            this.message = message;
            this.timer = timer;
        }

        @Override
        public void run() {
            while (!isInterrupted()) {
                Demo.print(message);
                try {
                    Thread.sleep(timer);
                } catch (InterruptedException e) {
                    LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}