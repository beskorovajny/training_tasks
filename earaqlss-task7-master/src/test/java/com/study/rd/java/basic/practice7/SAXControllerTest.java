package com..rd.java.basic.practice7;

import org.junit.Test;

import static org.junit.Assert.*;

public class SAXControllerTest {
    Guns guns = SAXController.parse(Constants.VALID_XML_FILE, true);

    @Test
    public void parse() {
        assertNotNull(guns);
    }
}