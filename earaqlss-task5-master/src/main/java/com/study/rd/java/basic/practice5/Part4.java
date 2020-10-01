package com..rd.java.basic.practice5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;

/**
 * @author beskorovajny
 */
public class Part4 {
    static final Logger LOGGER = Logger.getLogger(Part4.class.getName());
    static int threadsCount = 0;

    public static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
        }
        return sb.toString();
    }

    public static int findMax(int[][] arr) {
        int maxValue = arr[0][0];
        for (int i = 0; i < threadsCount; ++i) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] > maxValue) {
                    maxValue = arr[i][j];
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                       LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE);
                       Thread.currentThread().interrupt();
                    }
                }
            }
        }
        return maxValue;
    }

    public static class Worker extends Thread {
        private final int[] ints;
        private int maximalElement;

        public Worker(int[] inputArray) {
            this.ints = inputArray;
            this.maximalElement = inputArray[0];
        }

        public int getMaximalElement() {
            return maximalElement;
        }

        @Override
        public void run() {
            for (int el : ints) {
                if (el > maximalElement) {
                    maximalElement = el;
                }
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static int[][] stringToArray(String words) {
        String[] strings = words.split("\n");
        int rows = 0;
        threadsCount = strings.length;
        int columns = strings[0].split("\\s").length;
        int[][] intArr = new int[threadsCount][columns];
        for (String el : strings) {
            String[] arr1 = el.split("\\s");
            int length = 0;
            for (String e : arr1) {
                if (e.length() != 0) {
                    intArr[rows][length] = parseInt(e);
                    length++;
                }
            }
            rows++;
        }
        return intArr;
    }

    public static void main(final String[] args) {
        String words = readFile("part4.txt");
        int[][] arrayFromString = stringToArray(words);
        Worker[] threads = new Worker[threadsCount];

        long start = System.currentTimeMillis();
        int maxElement = findMax(arrayFromString);
        Demo.print(maxElement);
        Demo.print((System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < threadsCount; i++) {
            threads[i] = new Worker(arrayFromString[i]);
            threads[i].start();
        }

        for (int i = 0; i < threadsCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
                Thread.currentThread().interrupt();
            }
        }
        maxElement = threads[0].getMaximalElement();

        for (int i = 0; i < threadsCount; i++) {
            if (threads[i].getMaximalElement() > maxElement) {
                maxElement = threads[i].getMaximalElement();
            }
        }
        Demo.print(maxElement);
        Demo.print((System.currentTimeMillis() - start));
    }
}