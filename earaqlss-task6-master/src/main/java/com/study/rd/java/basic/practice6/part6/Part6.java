package com..rd.java.basic.practice6.part6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author beskorovajny
 */
public class Part6 {
    private static final Logger LOGGER = Logger.getLogger(Part6.class.getName());
    private static final Pattern PATTERN = Pattern.compile("[a-zA-Z]+");
    private String fileName;
    private String[] inputFromFile;

    Part6() {
    }


    public boolean console(String input, String fileName, String task, String operation) {
        if (!("--input".equals(input) || "-i".equals(input))) {
            LOGGER.info("Wrong operation");
            return false;
        }
        if (!("--task".equals(task) || task.equals("-t"))) {
            LOGGER.info("Wrong task");
            return false;
        }

        this.fileName = fileName;
        initialize();

        switch (operation.toLowerCase()) {
            case "frequency":
                Part61.getFrequency(inputFromFile);
                break;
            case "length":
                Part62.getLength(inputFromFile);
                break;
            case "duplicates":
                Part63.getDuplicates(inputFromFile);
                break;
            default:
                return false;
        }
        return true;
    }

    public void initialize() {
        StringBuilder stringBuilder = new StringBuilder();
        Matcher matcher = PATTERN.matcher(getInput());
        while (matcher.find()) {
            stringBuilder.append(matcher.group()).append(" ");
        }
        inputFromFile = stringBuilder.toString().split(" ");
    }

    String getInput() {
        StringBuilder sb = new StringBuilder();
        try (Scanner file = new Scanner(new File(fileName), "CP1251")) {
            while (file.hasNext()) {
                sb.append(file.next()).append(" ");
            }
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE,String.format("File: %s not found", fileName), e);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Part6 part6 = new Part6();
        part6.console(args[0], args[1], args[2], args[3]);

    }

}
