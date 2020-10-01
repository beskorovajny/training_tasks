package com..rd.java.basic.practice7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

/**
 * @author besko
 */
@XmlType(name = "scope")
@XmlEnum
public enum ScopeType {
    /**
     * option for gun without scope
     */
    @XmlEnumValue("noScope")
    NO_SCOPE("noScope"),
    /**
     * gun with ACOG scope
     */
    @XmlEnumValue("ACOG")
    ACOG("ACOG"),
    /**
     * gun with long range zoom optics scope
     */
    @XmlEnumValue("sniperScope")
    SNIPER_SCOPE("sniperScope"),
    /**
     * gun with scope for night operations
     */
    @XmlEnumValue("nightVisionScope")
    NIGHT_VISION_SCOPE("nightVisionScope");

    /**
     * scope string value
     */
    private final String scope;

    /**
     * Scope constructor
     */
    ScopeType(String value) {
        this.scope = value;
    }

    /**
     * scope value getter
     *
     * @return scope string value
     */
    public String getScope() {
        return scope;
    }

    /**
     * @param value -  string value what user looking for
     * @return Scope enum value
     */
    public static ScopeType findScope(String value) {
        ScopeType result = null;
        for (ScopeType scope : ScopeType.values()) {
            if (Objects.equals(scope.getScope(), value)) {
                result = scope;
                break;
            }
        }
        if (result == null) {
            throw new IllegalArgumentException(value);
        }
        return result;
    }


}
