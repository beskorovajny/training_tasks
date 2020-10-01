package com..rd.java.basic.practice7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

/**
 * @author besko
 */

@XmlType(name = "effectiveRange")
@XmlEnum
public enum EffectiveRange {
    /**
     * Short effective fire range
     */
    @XmlEnumValue("500")
    SHORT("500"),
    /**
     * Medium effective fire range
     */
    @XmlEnumValue("1000")
    MEDIUM("1000"),
    /**
     * Long effective fire range
     */
    @XmlEnumValue("1500")
    LONG("1500");

    /**
     * range value
     */
    private final String range;

    /**
     * @param range - string value for constructor Range enum class
     */
    EffectiveRange(String range) {
        this.range = range;
    }

    /**
     * range getter
     *
     * @return string value of Range enum
     */
    public String getRange() {
        return range;
    }

    /**
     * @param value - string value what user looking for
     * @return range enum value
     */
    public static EffectiveRange findRange(String value) {
        EffectiveRange result = null;
        for (EffectiveRange range : EffectiveRange.values()) {
            if (Objects.equals(range.getRange(), value)) {
                result = range;
                break;
            }
        }
        if (result == null) {
            throw new IllegalArgumentException(value);
        }
        return result;
    }


}
