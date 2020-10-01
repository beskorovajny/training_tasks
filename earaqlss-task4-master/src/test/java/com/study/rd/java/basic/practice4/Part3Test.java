package com..rd.java.basic.practice4;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Part3Test {
    @Test
    public void testPart3() throws Exception {
        final String STR_TEST_RESOURCE = "a Р С Р 432 89 43.43  bcd .98 Рё РІС";
        final String CHAR_TEST = "a Р С Р ";
        final String INT_TEST = "432 89 ";
        final String DOUBLE_TEST = "43.43 .98 ";
        final String STRING_TEST = "bcd Рё РІС ";

        assertEquals(CHAR_TEST,Part3.convertInputToRegexRule(STR_TEST_RESOURCE,Part3.CHARACTER));
        assertEquals(INT_TEST,Part3.convertInputToRegexRule(STR_TEST_RESOURCE,Part3.INTEGER));
        assertEquals(DOUBLE_TEST,Part3.convertInputToRegexRule(STR_TEST_RESOURCE,Part3.DOUBLE));
        assertEquals(STRING_TEST,Part3.convertInputToRegexRule(STR_TEST_RESOURCE,Part3.STRING));
    }


}