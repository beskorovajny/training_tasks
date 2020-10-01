package com..rd.java.basic.practice4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Part1Test {
    @Test
    public void removeChar() throws Exception {
        final String TEST_TEXT = "Create a class that displays the";
        String changedText = Part1.removeCharacters(TEST_TEXT);
        final String TMP = "eate a ass at splays the";
        assertEquals(changedText,TMP);
    }

}