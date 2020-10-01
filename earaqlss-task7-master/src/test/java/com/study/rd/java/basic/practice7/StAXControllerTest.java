package com..rd.java.basic.practice7;

import org.junit.Test;

import static org.junit.Assert.*;

public class StAXControllerTest {
    Guns guns = StAXController.parse(Constants.OUTPUT_SAX_XML, true);
    @Test
    public void parse() {
        assertNotNull(guns);
    }
}