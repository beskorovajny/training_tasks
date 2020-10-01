package com..rd.java.basic.practice7;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com..rd.java.basic.practice7.Gun.*;

/**
 *  DOM parser for the XML document containing information about guns
 * @author besko
 */
@SuppressWarnings("all")
public class DOMController {

    public static final Logger LOGGER = Logger.getLogger(DOMController.class.getName());

    private DOMController() {
    }

    /**
     * Creates DOM model from the XML file.
     *
     * @param fileName the input XML document
     * @return corresponding DOM document
     * @throws IOException                  -- throws IOException
     * @throws ParserConfigurationException -- throws ParseConfiguration exception
     * @throws SAXException                 -- throws SAXException
     */
    public static Document getDocument(String fileName) throws
            IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        builderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();

        return documentBuilder.parse(new File(fileName));
    }

    /**
     * Parses the XML document and creates the list of guns.
     *
     * @param fileName the input XML document
     * @return the GunList object instance
     */
    public static Guns parse(String fileName, boolean validate) {
        List<Gun> guns = new ArrayList<>();
        Gun gun = null;
        Node current = null;
        if (validate) {
            try {
                Document document = getDocument(fileName);
                NodeList data = document.getDocumentElement().
                        getElementsByTagName("gun");

                for (int i = 0; i < data.getLength(); i++) {
                    current = data.item(i);

                    gun = new Gun();

                    NodeList child = current.getChildNodes();

                    for (int k = 0; k < child.getLength(); k++) {
                        Node node = child.item(k);

                        if (node instanceof Element) {
                            switch (Tags.getByName(node.getNodeName())) {
                                case MODEL:
                                    gun.setModel(node.getTextContent());
                                    break;
                                case HANDY:
                                    gun.setHandy(Integer.parseInt(node.getTextContent()));
                                    break;
                                case ORIGIN:
                                    gun.setOrigin(node.getTextContent());
                                    break;
                                case TTC:
                                    gun.setTacticalCharacteristics(new TacticalCharacteristics());

                                    NodeList tactical = node.getChildNodes();

                                    for (int j = 0; j < tactical.getLength(); ++j) {

                                        Node tacticalNode = tactical.item(j);

                                        if (tacticalNode instanceof Element) {
                                            switch (Tags.getByName(tacticalNode.getNodeName())) {
                                                case SCOPE:
                                                    Scope scope = new Scope();
                                                    scope.setType(ScopeType.findScope(((Element) tacticalNode).
                                                            getAttribute("type")));
                                                    gun.getTacticalCharacteristics().setScope(scope);
                                                    break;
                                                case FIRE_MODE:
                                                    FireMode fireMode = new FireMode();
                                                    fireMode.setFireMode(FireModeType.findRange(((Element) tacticalNode).
                                                            getAttribute("fireMode")));
                                                    gun.getTacticalCharacteristics().setFireMode(fireMode);
                                                    break;
                                                case EFFECTIVE_RANGE:
                                                    Range range = new Range();
                                                    range.setEffectiveRange(EffectiveRange.findRange(((Element) tacticalNode).
                                                            getAttribute("range")));
                                                    gun.getTacticalCharacteristics().setEffectiveRange(range);
                                                    break;
                                                default:
                                                    throw new IllegalArgumentException();
                                            }
                                        }
                                    }
                                    break;
                                case MATERIAL:
                                    MaterialType material = new MaterialType();
                                    material.setMaterial(Material.findMaterial(((Element) node).
                                            getAttribute("material")));
                                    gun.setMaterial(material);
                                    break;
                                default:
                                    throw new IllegalArgumentException();
                            }
                        }
                    }
                    guns.add(gun);
                }
            } catch (SAXException | ParserConfigurationException | IOException e) {
                LOGGER.log(Level.SEVERE, Constants.EXCEPTION_MESSAGE, e);
            }
            Guns gunsTmp = new Guns();
            gunsTmp.getGunList().addAll(guns);
            return gunsTmp;
        }
        return null;
    }


}
