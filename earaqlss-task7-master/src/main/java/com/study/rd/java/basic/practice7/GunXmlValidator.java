package com..rd.java.basic.practice7;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author besko
 */
@SuppressWarnings("all")
public class GunXmlValidator {
    private GunXmlValidator() {
    }

    public static final Logger LOGGER = Logger.getLogger(GunXmlValidator.class.getName());

    public static boolean validate(String xmlFile, String xsdFile) {
        try {
            SchemaFactory schemaFactory = SchemaFactory
                    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
            schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");

            Schema schema = schemaFactory.newSchema(new File(xsdFile));
            Validator validator = schema.newValidator();

            validator.validate(new StreamSource(new File(xmlFile)));
            return true;
        } catch (SAXException | IOException e) {
            LOGGER.log(Level.SEVERE, Constants.EXCEPTION_MESSAGE, e);
            return false;
        }
    }
}
