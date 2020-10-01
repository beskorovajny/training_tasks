package com..rd.java.basic.practice3;

import org.junit.Test;
import static org.junit.Assert.*;
public class Part6Test {

    @Test
    public void testPart6() {
        String s1 = "This is a test\n" +
                "And this is also a test\n" +
                "And these are also tests\n" +
                "test\n" +
                "Это тест\n" +
                "Это также тест\n" +
                "И это также тесты";
        String s2 = "This _is _a _test\n" +
                "_And this _is _also _a _test\n" +
                "_And these are _also tests\n" +
                "_test\n" +
                "_Это _тест\n" +
                "_Это _также _тест\n" +
                "И это _также тесты";
        assertEquals(s2,Part6.convert(s1));
    }

}