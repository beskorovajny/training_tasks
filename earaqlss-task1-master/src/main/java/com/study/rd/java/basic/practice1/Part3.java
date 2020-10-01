package com..rd.java.basic.practice1;

/**
 * @author beskorovajny
 *
 * Class that implements functionality of displaying of the
 * command line parameters in console
 * (display using a space between them),
 * the result should not end with a space.
 */
public class Part3 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        if (args.length == 0) {
            Demo.print("");
        } else {
            for (int i = 0; i < args.length-1; i++) {
                Demo.print(args[i] + " ");
            }
            Demo.print(args[args.length-1]);
        }
    }
	
}
