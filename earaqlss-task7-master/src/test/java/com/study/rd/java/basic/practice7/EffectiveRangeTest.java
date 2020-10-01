package com..rd.java.basic.practice7;

import org.junit.Test;

import static org.junit.Assert.*;

public class EffectiveRangeTest {
    GunFactory factory = new GunFactory();
    Range range = factory.createRange();
    @Test
    public void getRange() {
        assertNull(range.getEffectiveRange());
    }

    @Test
    public void findRange() {
        assertNotNull(EffectiveRange.findRange("1000"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void findRangeExc() {
        EffectiveRange.findRange("999");
    }

    @Test
    public void values() {
        assertNotNull(EffectiveRange.values());
    }

    @Test
    public void valueOf() {
        assertEquals(EffectiveRange.SHORT, EffectiveRange.valueOf("SHORT"));
    }
}