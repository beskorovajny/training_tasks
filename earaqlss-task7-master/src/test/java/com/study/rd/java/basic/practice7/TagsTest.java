package com..rd.java.basic.practice7;

import org.junit.Test;

import static org.junit.Assert.*;

public class TagsTest {

    @Test
    public void getByName() {
        assertNotNull(Tags.getByName("ACOG"));
    }

    @Test
    public void values() {
        assertNotNull(Tags.values());
    }

    @Test
    public void valueOf() {
        assertEquals(Tags.AUTO, Tags.valueOf("AUTO"));
    }
}