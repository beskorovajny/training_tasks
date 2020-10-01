package com..rd.java.basic.practice7;

import org.junit.Test;

import static org.junit.Assert.*;

public class XmlWriterTest {
    Guns guns = DOMController.parse(Constants.VALID_XML_FILE, true);
    @Test
    public void write() {
        SortUtil.sortGunsByOrigin(guns);
        XmlWriter.write(guns, Constants.INVALID_XML_FILE);
        guns = DOMController.parse(Constants.INVALID_XML_FILE, true);
        assertEquals("Belgium".toLowerCase(), guns.getGunList().get(0).getOrigin().toLowerCase());

    }
}