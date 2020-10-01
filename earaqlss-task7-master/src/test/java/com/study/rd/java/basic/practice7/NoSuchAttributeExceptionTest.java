package com..rd.java.basic.practice7;

import org.junit.Test;

import static org.junit.Assert.*;

public class NoSuchAttributeExceptionTest {

    @Test
    public void getMessage() {
        String message = "Attribute ( lol ) not found";
        assertEquals(message, new NoSuchAttributeException("lol").getMessage());
    }
}