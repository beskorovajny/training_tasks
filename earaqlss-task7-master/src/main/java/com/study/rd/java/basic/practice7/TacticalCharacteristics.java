package com..rd.java.basic.practice7;

import javax.xml.bind.annotation.*;

/**
 * @author besko
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "scope",
        "effectiveRange",
        "fireMode"
})
public class TacticalCharacteristics {

    @XmlElement(required = true)
    protected Scope scope;
    @XmlElement(required = true)
    protected Range effectiveRange;
    @XmlElement(required = true)
    protected FireMode fireMode;

    /**
     * getter for scope value
     *
     * @return {@link Scope}
     */
    public Scope getScope() {
        return scope;
    }

    /**
     * setter for scope filed
     *
     * @param value {@link Scope}
     */
    public void setScope(Scope value) {
        this.scope = value;
    }

    /**
     * getter for effective range field
     *
     * @return {@link Range}
     */
    public Range getEffectiveRange() {
        return effectiveRange;
    }

    /**
     * setter for range field
     *
     * @param value {@link Range} object
     */
    public void setEffectiveRange(Range value) {
        this.effectiveRange = value;
    }

    /**
     * getter for fire mode field
     *
     * @return {@link FireMode}
     */
    public FireMode getFireMode() {
        return fireMode;
    }

    /**
     * set fire mode
     *
     * @param fireMode {@link FireMode} object
     */
    public void setFireMode(FireMode fireMode) {
        this.fireMode = fireMode;
    }

    @Override
    public String toString() {
        return "GunOptions{" +
                "\n\tscope=" + scope +
                "\n\teffectiveRange=" + effectiveRange +
                "\n\tfireMode=" + fireMode +
                '}';
    }

}

