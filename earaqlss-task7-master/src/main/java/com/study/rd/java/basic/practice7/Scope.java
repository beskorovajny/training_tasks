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
public class Scope {

    @XmlAttribute(name = "type", required = true)
    protected ScopeType type;

    /**
     * ScopeType value getter
     *
     * @return {@link ScopeType}
     */
    public ScopeType getScopeType() {
        return type;
    }

    /**
     * setter for ScopeType value
     *
     * @param value allowed object is {@link ScopeType}
     */
    public void setType(ScopeType value) {
        this.type = value;
    }

    @Override
    public String toString() {
        return "Scope{" +
                "type=" + type +
                '}';
    }
}
