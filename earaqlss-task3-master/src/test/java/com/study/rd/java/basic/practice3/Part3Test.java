package com..rd.java.basic.practice3;
import org.junit.Test;

import static org.junit.Assert.*;

public class Part3Test {
    @Test
    public void testConvertP3() {
        String s1 = "When I was younger\n" +
                "I never needed";
        String s2 = "when I Was Younger\n" +
                "I Never Needed";

        assertEquals(s2,Part3.convert(s1));
    }
}