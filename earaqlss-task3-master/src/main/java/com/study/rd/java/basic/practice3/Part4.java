package com..rd.java.basic.practice3;


import java.security.*;
import java.security.NoSuchAlgorithmException;


/**
 * @author beskorovajny
 */
public class Part4 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("asdf", "MD5"));
        System.out.println(hash("asdf", "SHA-256"));
    }

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        if (input != null) {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            digest.update(input.getBytes());
            byte[] hash = digest.digest();
            StringBuilder sbHash = new StringBuilder();
            for (byte b : hash) {
                sbHash.append(String.format("%02x", b));
            }

            return sbHash.toString().toUpperCase();
        }
        return null;
    }
}
