package com..rd.java.basic.practice7;

import org.junit.Test;

import static org.junit.Assert.*;

public class RangeTest {
    Range range = new Range();

    @Test
    public void getEffectiveRange() {
        assertNull(range.getEffectiveRange());
    }

    @Test
    public void setEffectiveRange() {
        range.setEffectiveRange(EffectiveRange.SHORT);
        assertEquals(EffectiveRange.SHORT, range.getEffectiveRange());
    }
}