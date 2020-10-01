package com..rd.java.basic.practice7;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.xml.stream.XMLStreamConstants.*;

/**
 * SAX parser for the XML document containing information about guns
 *
 * @author besko
 */
@SuppressWarnings("all")
public class StAXController {

    private StAXController() {}

    public static final Logger LOGGER = Logger.getLogger(StAXController.class.getName());
    /**
     * {@link GunsHandler}
     */
    private static final GunsHandler GUNS_HANDLER = new GunsHandler();

    private static void startElement(String localName, Attributes attributes) {
        try {
            GUNS_HANDLER.startElement(null, null, localName, attributes);
        } catch (SAXException e) {
            LOGGER.log(Level.SEVERE, Constants.EXCEPTION_MESSAGE, e);
        }
    }

    private static void endElement(String localName) {
        try {
            GUNS_HANDLER.endElement(null, null, localName);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, Constants.EXCEPTION_MESSAGE, e);
        }
    }

    public static Guns parse(String fileName, boolean validate) {
        if (validate) {
            try {
                XMLInputFactory factory = XMLInputFactory.newInstance();
                factory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
                factory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
                XMLStreamReader reader = factory.createXMLStreamReader(new FileReader(fileName));

                while (reader.hasNext()) {
                    int tmp = reader.next();

                    switch (tmp) {
                        case START_ELEMENT:
                            CustomAttributes attributes = null;
                            if (reader.getAttributeCount() > 0) {
                                attributes = new CustomAttributes();

                                for (int i = 0; i < reader.getAttributeCount(); i++) {
                                    attributes.addAttribute(reader.getAttributeLocalName(i),
                                            reader.getAttributeValue(i));
                                }
                            }
                            startElement(reader.getLocalName(), attributes);
                            break;

                        case CHARACTERS:
                            GUNS_HANDLER.characters(reader.getTextCharacters(),
                                    reader.getTextStart(),
                                    reader.getTextLength());
                            break;
                        case END_ELEMENT:
                            endElement(reader.getLocalName());
                            break;
                        default:
                            break;
                    }
                }
            } catch (FileNotFoundException | XMLStreamException e) {
                LOGGER.log(Level.SEVERE, Constants.EXCEPTION_MESSAGE, e);
            }
        }
        return GUNS_HANDLER.getGuns();
    }

}
@SuppressWarnings("all")
class CustomAttributes implements Attributes {

    Map<String, String> attributes = new HashMap<>();

    public String addAttribute(String key, String value) {
        return attributes.put(key, value);
    }

    @Override
    public int getLength() {
        return attributes.size();
    }

    @Override
    public String getURI(int index) {
        return null;
    }

    @Override
    public String getLocalName(int index) {
        return null;
    }

    @Override
    public String getQName(int index) {
        return null;
    }

    @Override
    public String getType(int index) {
        return null;
    }

    @Override
    public String getValue(int index) {
        return null;
    }

    @Override
    public int getIndex(String uri, String localName) {
        return 0;
    }

    @Override
    public int getIndex(String qName) {
        return 0;
    }

    @Override
    public String getType(String uri, String localName) {
        return null;
    }

    @Override
    public String getType(String qName) {
        return null;
    }

    @Override
    public String getValue(String uri, String localName) {
        return null;
    }

    @Override
    public String getValue(String qName) {
        return attributes.get(qName);
    }
}
