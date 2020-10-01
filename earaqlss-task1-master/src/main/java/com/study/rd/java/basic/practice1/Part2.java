package com..rd.java.basic.practice1;

/**
 * @author beskorovajny
 *
 * Class that implements functionality of
 * addition of numbers passed to the
 * application as the command line parameters.
 */
public class Part2 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        int sum = 0;
        if (args.length == 0) {
            Demo.print("");
        } else {
                try {
                    for (String s : args) {
                        sum += Integer.parseInt(s);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            Demo.print(String.valueOf(sum));
        }
    }
	
}
