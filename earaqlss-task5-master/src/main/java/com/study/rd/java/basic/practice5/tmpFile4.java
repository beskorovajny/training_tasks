package com..rd.java.basic.practice5;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static java.lang.Thread.sleep;
import static java.util.regex.Pattern.*;


/**
 * @author beskorovajny
 */
public class tmpFile4 {
    public static final Logger LOGGER = Logger.getLogger(tmpFile4.class.getName());
    public static final String FILE_NAME = "part4.txt";

    private static int rows = 0;
    private static int maxValue = 0;


    public static List<Integer> getInput(String fileName) throws FileNotFoundException {
        ArrayList<Integer> listI = new ArrayList<>();
        Scanner sc = new Scanner(new File(fileName));
        while (sc.hasNextInt()) {
            listI.add(sc.nextInt());
        }
        sc.close();
        return listI;
    }

    public static String getStringInput(String fileName) throws FileNotFoundException {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
            count = count + 1;
            sb.append(System.lineSeparator());
        }
        scanner.close();
        rows = count;
        return sb.toString().trim();
    }


    public static void findMaxValue(String input) {

        Pattern p3 = compile("\\d+");
        Matcher m3 = p3.matcher(input);

        int max = Integer.MIN_VALUE;
        while (m3.find()) {
            int nextNum = Integer.parseInt(m3.group());
            if (nextNum > max) {
                max = nextNum;
            }
        }

        if (maxValue < max) {
            maxValue = max;
        }

    }

    static class Worker extends Thread {
        String maxValueString;

        Worker(String s) {
            maxValueString = s;
            start();
        }

        @Override
        public void run() {
            synchronized (this) {
                tmpFile4.findMaxValue(maxValueString);
            }
        }
    }

    public static void main(String[] args)  {

        List<Integer> input = null;
        try {
            input = tmpFile4.getInput(FILE_NAME);
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
        }

        long start = System.currentTimeMillis();

        try {
            sleep(1);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
            Thread.currentThread().interrupt();
        }

        assert input != null;
        Demo.print(Collections.max(input) + System.lineSeparator());
        long end = System.currentTimeMillis();
        Demo.print(end - start + System.lineSeparator());

        String strInput = null;

        try {
            strInput = tmpFile4.getStringInput(FILE_NAME);
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
        }

        String[] strArray = null;
        if (strInput != null) {
            strArray = strInput.split(System.lineSeparator());
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < rows; i++) {

            new Worker(strArray[i]);
        }
        try {
            sleep(2);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
            Thread.currentThread().interrupt();
        }

        Demo.print(maxValue + System.lineSeparator());
        end = System.currentTimeMillis();
        Demo.print(end - start);

        input.clear();
    }
}
