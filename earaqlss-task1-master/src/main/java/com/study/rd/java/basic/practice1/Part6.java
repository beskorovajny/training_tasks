package com..rd.java.basic.practice1;

/**
 * @author beskorovajny
 *
 * Class that creates an array from n elements and
 * fills it with an ascending sequence of prime numbers
 * (2, 3, 5, 7 …). The n number should be passed
 * as the command line parameter.
 */
public class Part6 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        int size = 0;
        try {
            size = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (size > 0) {
            int[] arr = fillPrimeArray(size);
            for (int i = 0; i < arr.length - 1; i++) {
                Demo.print(arr[i] + " ");
            }
            Demo.print(String.valueOf(arr[arr.length - 1]));
        } else {
            Demo.print("");
        }


    }

    static int[] fillPrimeArray(int size) {
            int[] arr = new int[size];
            int tmp = 0;

            for (int i = 1; tmp < arr.length; i++) {
                if (isPrime(i)) {
                    arr[tmp] = i;
                    tmp++;
                }
            }
        return arr.clone();
    }

    static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
	
}
