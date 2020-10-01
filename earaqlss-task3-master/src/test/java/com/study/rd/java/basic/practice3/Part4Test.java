package com..rd.java.basic.practice3;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

public class Part4Test {
    @Test
    public void testConvertP4() throws NoSuchAlgorithmException {
        String MD5 = "912EC803B2CE49E4A541068D495AB570";
        String SHA_256 = "F0E4C2F76C58916EC258F246851BEA091D14D4247A2FC3E18694461B1816E13B";

        assertEquals(MD5,Part4.hash("asdf","MD5"));
        assertEquals(SHA_256,Part4.hash("asdf","SHA-256"));
        assertNull(Part4.hash(null,"MD5"));
    }
}