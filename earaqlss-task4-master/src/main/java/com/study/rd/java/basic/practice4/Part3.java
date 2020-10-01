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
public class Part3 {
    public static  final Logger LOGGER = Logger.getLogger(Part3.class.getName());

    public static final String CHARACTER =  "(?U)\\b\\w\\b";
    public static final String INTEGER =  "(?<![-.])\\b[0-9]+\\b(?!\\.[0-9])";
    public static final String DOUBLE =  "\\d+\\.\\d+ | \\.\\d+";
    public static final String STRING =  "(?Us)[\\w&&\\D]{2,}";


    public static void main(String[] args) {
        String input = Demo.getInput("part3.txt","CP1251");
        try {
            getResult(input);
        }catch (IOException e) {
            LOGGER.log(Level.SEVERE, Demo.ERRORMESSAGE, e);
        }

    }

    public static void getResult(String input) throws IOException {
        String tmp = null;
        String stop = "stop";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
           while(!Objects.equals(tmp = bufferedReader.readLine(),stop)) {
              switch (tmp) {
                  case "char" : Demo.print(convertInputToRegexRule(input, CHARACTER));
                      break;
                  case "int" : Demo.print(convertInputToRegexRule(input, INTEGER));
                      break;
                  case "double" : Demo.print(convertInputToRegexRule(input, DOUBLE));
                      break;
                  case "String" : Demo.print(convertInputToRegexRule(input, STRING));
                      break;
                  default: Demo.print("Incorrect input");
                      break;
              }
           }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, Demo.ERRORMESSAGE, e);
        }
    }


    public static String convertInputToRegexRule(String input, String regex) {
        StringBuilder sb = new StringBuilder();
        Pattern p  = Pattern.compile(regex);
        Matcher m = p.matcher(input);

        while(m.find()) {
            sb.append(m.group().trim()).append(" ");
        }
        return sb.toString();
    }
}
