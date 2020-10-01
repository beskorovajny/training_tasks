package com..rd.java.basic.practice5;

import java.io.*;
import java.security.SecureRandom;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author beskorovajny
 */
class Part4Helper {
    public static final Logger LOGGER = Logger.getLogger(Part4Helper.class.getName());

    public static int[][] randomNumberGenerator(int rows, int columns) {
        int[][] matrixHelper = new int[rows][columns];
        Random random = new SecureRandom();
        for (int i = 0; i < matrixHelper.length; i++) {
            for (int j = 0; j < matrixHelper[i].length; j++) {
                matrixHelper[i][j] = random.nextInt(1000);
            }
        }
        return matrixHelper.clone();
    }




    public static void writeFile(String fileName, int[][] matrix) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName)))) {

                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        writer.write(matrix[i][j] + " ");
                    }
                    writer.newLine();
                }
                writer.flush();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
        }

    }

    public static void printMatrix (int[][] toPrint) {
        for (int i = 0; i < toPrint.length; i++) {
            for (int j = 0; j < toPrint[i].length; j++) {
                Demo.print(toPrint[i][j] + " ");
            }
            Demo.print("");
        }

    }

    void read () {
        /*try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while (reader.readLine() != null) {
                rows++;
            }
            reader.close();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
            return -1;
        }*/
    }
}
