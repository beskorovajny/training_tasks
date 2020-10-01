package com..rd.java.basic.practice3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author beskorovajny
 */
public class Util {
    public static final Logger logger = Logger.getLogger(Util.class.getName());

    public static String getInput(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "UTF-8");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Exception message : ", ex);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = Util.getInput("part1.txt");
        logger.info(input);
    }
}