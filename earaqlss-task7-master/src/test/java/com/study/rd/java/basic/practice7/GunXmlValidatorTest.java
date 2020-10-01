package com..rd.java.basic.practice7;

import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

import static org.junit.Assert.*;

public class GunXmlValidatorTest {

    @Test
    public void validate() {
        assertTrue(GunXmlValidator.validate(Constants.VALID_XML_FILE, Constants.XSD_FILE));
    }
}