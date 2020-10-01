package com..rd.java.basic.practice7;

import java.io.File;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SAX parser for the XML document containing information about guns
 *
 * @author besko
 */
@SuppressWarnings("all")
public class SAXController {

    private SAXController() {}

    public static final Logger LOGGER = Logger.getLogger(SAXController.class.getName());

    public static Guns parse(String fileName, boolean validate) {
        if (validate) {
            try {
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser parser = factory.newSAXParser();
                parser.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
                parser.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
                GunsHandler gunsHandler = new GunsHandler();

                parser.parse(new File(fileName), gunsHandler);

                return gunsHandler.getGuns();

            } catch (SAXException | ParserConfigurationException | IOException e) {
                LOGGER.log(Level.SEVERE, Constants.EXCEPTION_MESSAGE, e);
            }
        }
        return null;

    }

}
@SuppressWarnings("all")
class GunsHandler extends DefaultHandler {
    public static final Logger LOGGER = Logger.getLogger(GunsHandler.class.getName());
    private static final String SCOPE_TYPE = "type";
    private static final String RANGE = "range";
    private static final String FIRE_MODE = "fireMode";
    private static final String MATERIAL = "material";

    private Tags currentElement;
    private Gun currentGun;
    private Guns guns;
    private final StringBuilder stringBuilder = new StringBuilder();

    public Guns getGuns() {
        return guns;
    }

    @Override
    public void startElement(String uri,
                             String name,
                             String qName,
                             Attributes attributes) throws SAXException {

        String data = null;

        currentElement = Tags.getByName(qName);

        try {
            switch (currentElement) {
                case GUNS:
                    guns = new Guns();
                    break;
                case GUN:
                    currentGun = new Gun();
                    break;
                case MODEL:
                case HANDY:
                case ORIGIN:
                    break;
                case TTC:
                    currentGun.setTacticalCharacteristics(new TacticalCharacteristics());
                    break;
                case SCOPE:
                    Scope scope = new Scope();
                    data = attributes.getValue(SCOPE_TYPE);
                    if (data == null) {
                        throw new NoSuchAttributeException(SCOPE_TYPE);
                    } else {
                        try {
                            scope.setType(ScopeType.findScope(data));
                        } catch (IllegalArgumentException e) {
                            throw new IllegalXmlException(SCOPE_TYPE, data, true);
                        }
                    }
                    currentGun.getTacticalCharacteristics().setScope(scope);
                    break;
                case EFFECTIVE_RANGE:
                    Range range = new Range();
                    data = attributes.getValue(RANGE);
                    if (data == null) {
                        throw new NoSuchAttributeException(RANGE);
                    } else {
                        try {
                            range.setEffectiveRange(EffectiveRange.findRange(data));
                        } catch (IllegalArgumentException e) {
                            throw new IllegalXmlException(RANGE, data, true);
                        }
                    }
                    currentGun.getTacticalCharacteristics().setEffectiveRange(range);
                    break;
                case FIRE_MODE:
                    FireMode fireMode = new FireMode();
                    data = attributes.getValue(FIRE_MODE);
                    if (data == null) {
                        throw new NoSuchAttributeException(FIRE_MODE);
                    } else {
                        try {
                            fireMode.setFireMode(FireModeType.findRange(data));
                        } catch (IllegalArgumentException e) {
                            throw new IllegalXmlException(FIRE_MODE, data, true);
                        }
                    }
                    currentGun.getTacticalCharacteristics().setFireMode(fireMode);
                    break;
                case MATERIAL:
                    Gun.MaterialType material = new Gun.MaterialType();
                    data = attributes.getValue(MATERIAL);
                    if (data == null) {
                        throw new NoSuchAttributeException(MATERIAL);
                    } else {
                        try {
                            material.setMaterial(Material.findMaterial(data));
                        } catch (IllegalArgumentException e) {
                            throw new IllegalXmlException(MATERIAL, data, true);
                        }
                    }
                    currentGun.setMaterial(material);
                    break;

                default:
                    currentGun = null;
                    throw new SAXException("Unknown element : " + qName);
            }
        } catch (NoSuchAttributeException |
                SAXException |
                IllegalXmlException |
                NullPointerException e) {

            LOGGER.log(Level.SEVERE, Constants.EXCEPTION_MESSAGE, e);

        }


    }

    @Override
    public void characters(char[] chars, int start, int length) {
        if (currentElement == Tags.MODEL ||
                currentElement == Tags.HANDY ||
                currentElement == Tags.ORIGIN) {
            stringBuilder.append(chars, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        String data = stringBuilder.toString().trim();

        switch (Tags.getByName(qName)) {
            case GUN:
                guns.getGunList().add(currentGun);
                break;
            case MODEL:
                currentGun.setModel(data);
                break;
            case HANDY:
                currentGun.setHandy(Integer.parseInt(data));
                break;
            case ORIGIN:
                currentGun.setOrigin(data);
                break;
            default:
                break;
        }
        stringBuilder.setLength(0);

    }
}

