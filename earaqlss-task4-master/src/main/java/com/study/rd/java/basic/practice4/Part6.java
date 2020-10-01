package com..rd.java.basic.practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author beskorovajny
 */
public class Part6 {
    public static final Logger LOGGER = Logger.getLogger(Part6.class.getName());

    public static final String CYRL = "[а-яіїєёА-ЯЁІЇЄ]+";
    public static final String LATN = "[a-zA-Z]+";
    public static  final String INPUT = Demo.getInput("part6.txt","CP1251");
    public static final String STOP = "stop";

    public static void main(String[] args) {
        showSentence(INPUT);
    }

    public static void showSentence(String input) {
        String scanInput;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while(!Objects.equals(scanInput = bufferedReader.readLine().toLowerCase(),STOP)) {
               switch (scanInput) {
                   case "latn" :
                       Demo.print("Latn: " + convertInputToRule(input, LATN));
                       break;
                   case "cyrl" :
                       Demo.print("Cyrl: " + convertInputToRule(input, CYRL));
                       break;
                   default:
                       Demo.print(scanInput + ": Incorrect input");
               }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, Demo.ERRORMESSAGE, e);
        }
    }
    public static String convertInputToRule(String input, String regex) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern  = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()) {
            sb.append(matcher.group()).append(" ");
        }
        return sb.toString();
    }
}
