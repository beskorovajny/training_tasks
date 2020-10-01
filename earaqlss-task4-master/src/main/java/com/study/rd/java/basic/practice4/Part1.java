package com..rd.java.basic.practice4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.regex.Pattern.*;

/**
 * @author beskorovajny
 */
public class Part1 {

    public static void main(String[] args) {
        String strTest = Demo.getInput("part1.txt","CP1251");
        Demo.print(removeCharacters(strTest));
    }

    public static String removeCharacters(String input) {
        if (input == null) {
            return null;
        }
        StringBuffer sb  = new StringBuffer();
        Pattern p  = compile("(?Us)[\\w&&\\D]{4,}");
        Matcher m = p.matcher(input);
        while(m.find()) {
            m.appendReplacement(sb, m.group().substring(2));

        }
        m.appendTail(sb);
        return sb.toString().trim();
    }



}
