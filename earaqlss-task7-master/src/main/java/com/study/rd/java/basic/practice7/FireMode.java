package com..rd.java.basic.practice7;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * @author besko
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class FireMode {

    @XmlAttribute(name = "fireMode", required = true)
    protected FireModeType fireModeType;

    /**
     * getter for fire mode value
     *
     * @return {@link FireModeType}
     */
    public FireModeType getFireMode() {
        return fireModeType;
    }

    /**
     * setter for fire mode value
     *
     * @param value allowed object is {@link FireModeType}
     */
    public void setFireMode(FireModeType value) {
        this.fireModeType = value;
    }

    @Override
    public String toString() {
        return "FireMode{" +
                "fireModeType=" + fireModeType +
                '}';
    }
}


