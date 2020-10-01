package com..rd.java.basic.practice7;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.Assert.*;

public class DOMControllerTest {
    Document document = DOMController.getDocument(Constants.VALID_XML_FILE);
    Guns guns = DOMController.parse(Constants.OUTPUT_DOM_XML, true);

    public DOMControllerTest() throws ParserConfigurationException, SAXException, IOException {
    }

    @Test
    public void getDocument() {
        assertNotNull(document);
    }

    @Test
    public void parse() {
        assertNotNull(guns);
    }
}