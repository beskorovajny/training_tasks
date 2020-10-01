package com..rd.java.basic.practice7;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author besko
 */
public class XmlWriter {
    public static final Logger LOGGER = Logger.getLogger(XmlWriter.class.getName());

    private XmlWriter() {
    }

    public static void write(Guns gunList, String fileMame) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Guns.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File file = new File(fileMame);
            marshaller.marshal(gunList, file);

        } catch (JAXBException e) {
            LOGGER.log(Level.SEVERE, Constants.EXCEPTION_MESSAGE, e);
        }
    }
}
