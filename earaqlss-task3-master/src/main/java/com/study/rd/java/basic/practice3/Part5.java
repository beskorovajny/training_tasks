package com.study.rd.java.basic.practice3;


/**
 * @author beskorovajny
 */
public class Part5 {

    public static void main(String[] args) {
        System.out.println(roman2Decimal("LXXX"));
        System.out.println(decimal2Roman(76));
    }

    public static String decimal2Roman(int dec) {
        if (dec < 1 || dec > 100) {
            return null;
        }
        String[] hund = {"", "C"};
        String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] unit = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        /*Finding the digits in the thousand, hundred, ten and units place*/
        int h = (dec / 100) % 10;
        int t = (dec / 10) % 10;
        int u = dec % 10;
        StringBuilder sb = new StringBuilder();
        sb.append(hund[h]);
        sb.append(ten[t]);
        sb.append(unit[u]);
        return sb.toString();
    }


    public static int roman2Decimal(String roman) {
        if (roman == null || roman.isEmpty()) {
            return 0;
        }
        int number = 0;
        char previous = 0;

        for (int x = 0; x < roman.length(); x++) {
            if (roman.charAt(x) == 'I') {
                number += 1;
            }

            if (roman.charAt(x) == 'V') {
                if (previous == 'I') {
                    number -= 2;
                }
                number += 5;
            }

            if (roman.charAt(x) == 'X') {
                if (previous == 'I') {
                    number -= 2;
                }
                number += 10;
            }

            if (roman.charAt(x) == 'L') {
                if (previous == 'X') {
                    number -= 20;
                }
                number += 50;
            }

            if (roman.charAt(x) == 'C') {
                if (previous == 'X') {
                    number -= 20;
                }
                number += 100;
            }
            previous = roman.charAt(x);

        }
        return number;
    }
}
