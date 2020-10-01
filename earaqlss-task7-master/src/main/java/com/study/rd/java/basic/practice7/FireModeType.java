package com..rd.java.basic.practice7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

/**
 * @author besko
 */
@XmlType(name = "fireMode")
@XmlEnum
public enum FireModeType {
    /**
     * Regular fire mode
     */
    @XmlEnumValue("regular")
    REGULAR("regular"),

    /**
     * Semi-auto fire mode
     */
    @XmlEnumValue("semi-auto")
    SEMI_AUTO("semi-auto"),
    /**
     * Auto fire mode
     */
    @XmlEnumValue("auto")
    AUTO("auto");

    /**
     * fire mode value
     */
    private final String fireMode;

    /**
     * @param fireMode - string value for constructor FireModeType enum class
     */
    FireModeType(String fireMode) {
        this.fireMode = fireMode;
    }

    /**
     * range getter
     *
     * @return string value of FireModeType enum
     */
    public String getFireMode() {
        return fireMode;
    }

    /**
     * @param value - string value what user looking for
     * @return range enum value
     */
    public static FireModeType findRange(String value) {
        FireModeType result = null;
        for (FireModeType mode : FireModeType.values()) {
            if (Objects.equals(mode.getFireMode(), value)) {
                result = mode;
                break;
            }
        }
        if (result == null) {
            throw new IllegalArgumentException(value);
        }
        return result;
    }
}
