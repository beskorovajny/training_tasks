package com..rd.java.basic.practice4;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Part4Test {
    @Test
    public void testPart4() {
        final String STR_TEST = "The class should parse the text file and return sentences." +
                System.lineSeparator() +
                "The method 'iterator' of the given class should return the iterator object - an instance of the inner class." +
                System.lineSeparator() +
                "The method Iterator#remove should throw an exception UnsupportedOperationException." +
                System.lineSeparator();
        assertEquals(STR_TEST.trim(),Part4.getOutput());
    }

}