package com..rd.java.basic.practice7;

import javax.xml.XMLConstants;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author besko
 */
public class HtmlController {
    public static final Logger LOGGER = Logger.getLogger(HtmlController.class.getName());

    private HtmlController() {
    }

    public static void parseToHtml(String xmlFile, String htmlFile, String xslFile) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
            Transformer transformer = transformerFactory
                    .newTransformer(new StreamSource(xslFile));

            transformer.transform(new StreamSource(xmlFile),
                    new StreamResult(htmlFile));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, Constants.EXCEPTION_MESSAGE, e);
        }
    }
}
