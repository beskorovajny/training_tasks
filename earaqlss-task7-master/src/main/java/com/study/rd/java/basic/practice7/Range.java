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
public class Range {

    @XmlAttribute(name = "range", required = true)
    protected EffectiveRange effectiveRange;

    /**
     * getter for range value
     *
     * @return {@link EffectiveRange}
     */
    public EffectiveRange getEffectiveRange() {
        return effectiveRange;
    }

    /**
     * setter for range value
     *
     * @param value allowed object is {@link EffectiveRange}
     */
    public void setEffectiveRange(EffectiveRange value) {
        this.effectiveRange = value;
    }


    @Override
    public String toString() {
        return "Range{" +
                "effectiveRange=" + effectiveRange +
                '}';
    }
}
