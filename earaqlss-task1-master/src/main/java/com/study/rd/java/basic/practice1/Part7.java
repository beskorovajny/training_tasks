package com..rd.java.basic.practice1;

/**
 * @author beskovajny
 *
 * Columns of spreadsheets (like Excel) have letter numbering in the
 * form of latin capital letters (sequentially, from left to right):
 * A, B, ..., Y, Z, AA, AB, ..., AY, AZ, BA, BB, …, etc.
 *
 * At the same time, each column has its sequence number:
 * A - 1; B - 2; ... ; Y - 25; Z - 26; AA - 27; AB - 28; …, etc.
 *
 * Class that contains the following three methods:
 * - a method of defining the column sequence number by its letter number
 * - a method of defining the column letter number by its sequence number
 * - using the column letter number, write a method of defining the number
 * of the column that is placed on the right side of the given one.
 */
public class Part7 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        String arrows = " ==> ";
        Demo.print("A" + arrows + str2int("A") + arrows + int2str(str2int("A")) + "\n"
                  + "B" + arrows + str2int("B") + arrows + int2str(str2int("B")) + "\n"
                  + "Z" + arrows + str2int("Z") + arrows + int2str(str2int("Z")) + "\n"
                  + "AA" + arrows + str2int("AA") + arrows + int2str(str2int("AA")) + "\n"
                  + "AZ" + arrows + str2int("AZ") + arrows + int2str(str2int("AZ")) + "\n"
                  + "BA" + arrows + str2int("BA") + arrows + int2str(str2int("BA")) + "\n"
                  + "ZZ" + arrows + str2int("ZZ") + arrows + int2str(str2int("ZZ")) + "\n"
                  + "AAA" + arrows + str2int("AAA") + arrows + int2str(str2int("AAA")) + "\n");
    }

    public static int str2int(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++)
        {
            result *= 26;
            result += str.charAt(i) - 'A' + 1;
        }
        return result;
    }


    public static String int2str(int number) {

        StringBuilder column = new StringBuilder();
        while (number > 0) {
            // Find remainder
            int tmp = number % 26;

            // If remainder is 0, then a
            // 'Z' must be there in output
            if (tmp == 0) {
                column.append("Z");
                number = (number / 26) - 1;
            } else {
                column.append((char)((tmp - 1) + 'A'));
                number = number / 26;
            }
        }
        return column.reverse().toString();
    }

    public static String rightColumn(String str) {
        int tmp = str2int(str);
        return int2str(tmp + 1);
    }
}
