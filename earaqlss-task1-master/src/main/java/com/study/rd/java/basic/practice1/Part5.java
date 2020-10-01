package com..rd.java.basic.practice1;

/**
 * @author beskorovajny
 *
 * Class that implements functionality of defining
 * the sum of the digits of a whole positive number
 * passed to the application as the command line parameter.
 */
public class Part5 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        int number = 0;
        try {
            number = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Demo.print(String.valueOf(getSum(number)));

    }

    /**
     * @param num - whole number for defining the sum of digits
     * @return -  integer whole positive number
     */
    static int getSum(int num) {
        int sum = 0;
        if (num <= 0) {
            return 0;
        }
        while (num != 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }
	
}
