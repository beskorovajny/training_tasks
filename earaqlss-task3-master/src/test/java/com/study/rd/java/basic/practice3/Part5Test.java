package com..rd.java.basic.practice3;
import org.junit.Test;

import static org.junit.Assert.*;

public class Part5Test {
    @Test
    public void testDecimal2Roman() {
        assertEquals("X",Part5.decimal2Roman(10));
        assertEquals("VI",Part5.decimal2Roman(6));
        assertEquals("XXV",Part5.decimal2Roman(25));
        assertEquals("XXXIV",Part5.decimal2Roman(34));
        assertEquals("LII",Part5.decimal2Roman(52));
        assertEquals("LXXIII",Part5.decimal2Roman(73));
        assertEquals("C",Part5.decimal2Roman(100));
    }

    @Test
    public void testRoman2Decimal() {
        assertEquals(5,Part5.roman2Decimal("V"));
        assertEquals(12,Part5.roman2Decimal("XII"));
        assertEquals(46,Part5.roman2Decimal("XLVI"));
        assertEquals(66,Part5.roman2Decimal("LXVI"));
        assertEquals(90,Part5.roman2Decimal("XC"));
        assertEquals(7,Part5.roman2Decimal("VII"));
        assertEquals(94,Part5.roman2Decimal("XCIV"));

    }
}