package com..rd.java.basic.practice4;

import java.io.*;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author beskorovajny
 */
public class Part2 {
    public static  final Logger LOGGER = Logger.getLogger(Part2.class.getName());
    public static final String ARROWS = "==> ";
    public static final int DEFAULT_SIZE = 10;

    public static void main(String[] args) {
        String generated = randomNumberGenerator(DEFAULT_SIZE);
        int[] read = null;
        int[] sortedArray = null;
        try {
            writeFile("part2.txt",generated);
            read = readFile("part2.txt");
            Demo.print("input " + ARROWS + arrayToString(read));
            bubbleSort(read);
            writeFile("part2_sorted.txt",arrayToString(read));
            sortedArray = readFile("part2_sorted.txt");
            Demo.print("output " + ARROWS + arrayToString(sortedArray));

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, Demo.ERRORMESSAGE, e);
        }
    }

    public static String randomNumberGenerator(int size) {
        Random random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(random.nextInt(50)).append(" ");
        }
        return sb.toString().trim();
    }

    public static void bubbleSort(int[] arrToSort) {
        if (arrToSort == null) {
            return;
        }
        int size = arrToSort.length;
        int tmp = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 1; j < (size - i); j++) {
                if (arrToSort[j - 1] > arrToSort[j]) {
                    tmp = arrToSort[j - 1];
                    arrToSort[j - 1] = arrToSort[j];
                    arrToSort[j] = tmp;
                }
            }
        }
    }

    public static int[] readFile(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String tmp = null;
            while ((tmp = bufferedReader.readLine()) != null) {
                sb.append(tmp);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, Demo.ERRORMESSAGE, e);
        }
        String[] resultStr = sb.toString().split("\\s");
        int[] resultIntArray = new int[resultStr.length];
        int tmpArraySize = resultIntArray.length;
        for (int i = 0; i < tmpArraySize; i++) {
            resultIntArray[i] = Integer.parseInt(resultStr[i]);
        }

        return resultIntArray;
    }
    public static void writeFile(String fileName, String arrayForWrite) throws IOException {
        File file = new File(fileName);
        FileWriter fw = new FileWriter(file);
        try (PrintWriter printWriter = new PrintWriter(fw)) {
            printWriter.println(arrayForWrite);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, Demo.ERRORMESSAGE, e);
        }

    }
    public static String arrayToString(int[] array) {
        if (array == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int element : array) {
            sb.append(element).append(" ");
        }
        return sb.toString().trim();
    }

}
