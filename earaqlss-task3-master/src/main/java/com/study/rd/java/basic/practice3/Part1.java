package com..rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author beskorovajny
 */
public class Part1 {
    private static final Pattern LOGIN_NAME_EMAIL = Pattern
            .compile("(([a-z\\u0410-\\u044F]+);([\\w\\u0410-\\u044F]+\\s[\\w\\u0410-\\u044F]+);(\\w+@(\\w+.\\w+)))", Pattern.MULTILINE);

    public static void main(String[] args) {
        final String part1 = Util.getInput("part1.txt");


        System.out.println(part1);
        System.out.println();
        System.out.println(convert2(part1));


    }

    public static String convert1(String input) {
        if (input != null) {
            String text = input;
            StringBuilder result = new StringBuilder();
            Pattern pattern = Pattern.compile(
                    "((?<=\\s)([a-zа-я]+(?=;))|(?<=;)([^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+))",
                    Pattern.UNICODE_CHARACTER_CLASS);

            Matcher matcher = pattern.matcher(text);
            int count = 1;
            while (matcher.find()) {
                count++;
                if (count % 2 == 0) {
                    result.append(text.substring(matcher.start(), matcher.end()) + ": ");
                } else {
                    result.append(text.substring(matcher.start(), matcher.end()) + "\n");
                }
            }
            return result.toString();
        }
        return null;
    }

    public static String convert2(String input) {
        if (input == null) {
            return null;
        }
        String[] arr = strToArr(input);
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i <= arr.length - 3; i += 3) {
            sb.append(
                    arr[i + 1].substring(arr[i + 1].indexOf(' ') + 1) + " " +
                            arr[i + 1].substring(0, arr[i + 1].indexOf(' ')) +
                            " (email: " + arr[i + 2] + ")\n"
            );
        }
        return sb.toString();

    }

    public static String convert3(String input) {
        if (input != null) {
            String[] arrC3 = input.split("\n");
            StringBuilder[] sbArr = new StringBuilder[arrC3.length];

            for (int i = 0; i < sbArr.length; i++) {
                if (arrC3[i].contains("@")) {
                    sbArr[i] = new StringBuilder(arrC3[i].substring(arrC3[i].indexOf('@') + 1));
                    sbArr[i].append(" ==> ").append(arrC3[i].substring(0, arrC3[i].indexOf(';')));
                    for (int j = i + 1; j < arrC3.length; j++) {
                        if (arrC3[j].contains(sbArr[i].substring(0, sbArr[i].indexOf("=") - 1))) {
                            sbArr[i].append(", " + arrC3[j].substring(0, arrC3[j].indexOf(';')));
                            arrC3[j] = new StringBuilder(arrC3[j].substring(0, arrC3[j].indexOf('@') - 1)).toString();
                        }
                    }
                }
            }

            StringBuilder sbRes = new StringBuilder();
            for (StringBuilder s : sbArr) {
                if (s != null) {
                    sbRes.append(s + "\n");
                }
            }
            return sbRes.toString();


        }
        return null;
    }

    public static String convert4(String input) {
        Matcher matcher = LOGIN_NAME_EMAIL.matcher(input);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "$1;" + 1488);
            /* r.nextInt(10000)*/
        }
        return sb.toString();


    }
    private static String[] strToArr(String str) {
        return str.replace("\n", ";").split(";");
    }

}