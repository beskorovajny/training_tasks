package com..rd.java.basic.practice5;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author beskorovajny
 */
public class Part2 {
    private static final Logger LOGGER = Logger.getLogger(Part2.class.getName());
    private static final InputStream INPUT_STREAM = new Worker();
    private static final InputStream SYSTEM_IN = System.in;

    public static void main(final String[] args) {
        System.setIn(INPUT_STREAM);
        Thread t1 = new Thread(() -> Spam.main(null));
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            LOGGER.log(Level.INFO, e.getMessage());
            Thread.currentThread().interrupt();
        }
        System.setIn(SYSTEM_IN);
    }

    public static class Worker extends InputStream {
        int index;
        int indexTmp;

        @Override
        public int read() {
            byte[] separator = System.lineSeparator().getBytes();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                LOGGER.log(Level.INFO, e.getMessage());
                Thread.currentThread().interrupt();
            }
            if (index != 0) {
                return -1;
            }
            index++;
            return separator[0] & 0xFF;
        }

        @Override
        public int read(byte[] bytes, int in, int itr) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
                Thread.currentThread().interrupt();
            }
            byte[] separator = System.lineSeparator().getBytes();
            if (indexTmp != 0) {
                return -1;
            }
            indexTmp++;
            bytes[0] = (byte) (separator[0] & 0xFF);
            return 1;
        }
    }
}