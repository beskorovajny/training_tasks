package com..rd.java.basic.practice4;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import static org.junit.Assert.assertEquals;

public class Part5Test {

    @Test
    public void test1() throws UnsupportedEncodingException {
        System.setIn(new ByteArrayInputStream(
                ("apple ru\napple en\ntable ru\ntable en\nstop\n...")
                        .getBytes("CP1251")));
        Part5.main(new String[0]);
        String test = "яблоко";
        String test2 = "яблоко";
        assertEquals(test,test2);
    }

}

