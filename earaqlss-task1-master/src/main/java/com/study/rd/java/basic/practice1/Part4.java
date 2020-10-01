package com..rd.java.basic.practice1;

/**
 * @author beskorovajny
 *
 * Class that implements functionality of defining
 * the greatest common divisor of two whole
 * positive numbers passed to the application
 * as the command line parameters.
 */
public class Part4 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        try {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        Demo.print(String.valueOf(getGCD(a, b)));
    }


    /**
     * @param num1 - first whole integer number
     * @param num2 - second whole integer number
     * @return - greatest common divisor integer result value from first and second numbers
     */
    static int getGCD(int num1, int num2) {
        int gcd = 0;
        for (int i = 1; i <= num1 && i <= num2; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

}
