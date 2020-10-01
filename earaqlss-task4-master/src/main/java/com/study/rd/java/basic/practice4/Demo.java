package com..rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author beskorovajny
 */
public class Demo {
    public static final Logger LOGGER = Logger.getLogger(Demo.class.getName());
    public static final String ERRORMESSAGE = "Exception message : ";

    public static void main(String[] args) {
        Part1.main(new String[] {});
        Part2.main(new String[] {});
        Part3.main(new String[] {});
        Part4.main(new String[] {});
    }
    public static void print(String string) {
        System.out.println(string);
    }

    public static String getInput(String fileName, String encoding){
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), encoding);
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, Demo.ERRORMESSAGE, e);
        }
        return sb.toString();
    }

}
