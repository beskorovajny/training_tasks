package com..rd.java.basic.practice3;

import java.util.regex.Pattern;

/**
 * @author beskorovajny
 */
public class Part6 {

    public static void main(String[] args) {
        String text6 = Util.getInput("part6.txt");
        System.out.println(text6);
        System.out.println();
        System.out.println(convert(text6));

    }

    public static String convert(String input) {
        Pattern pattern = Pattern.compile("(\\b\\w+\\b)(?=[\\s\\S]*\\b\\1\\b[\\s\\S]*\\b\\1\\b)",
                Pattern.UNICODE_CHARACTER_CLASS);
        String result = pattern.matcher(input + " " + input).replaceAll("_$1");

        return  result.substring(0,result.length() - 1 - pattern.matcher(input).replaceAll("_$1").length());

    }
}
