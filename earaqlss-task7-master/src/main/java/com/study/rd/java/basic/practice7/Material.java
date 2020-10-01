package com..rd.java.basic.practice7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

/**
 * @author besko
 * Java enum class for gun production material
 */

@XmlType(name = "material")
@XmlEnum
public enum Material {
    /**
     * Plastic material for gun
     */
    @XmlEnumValue("plastic")
    PLASTIC("plastic"),
    /**
     * Steel material for gun
     */
    @XmlEnumValue("steel")
    STEEL("steel"),
    /**
     * Natural wood material for gun
     */
    @XmlEnumValue("wood")
    WOOD("wood");

    private final String value;

    /**
     * @param value - string argument for constructor
     */
    Material(String value) {
        this.value = value;
    }

    /**
     * @return string value of enum element
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value - string value what user looking for
     * @return value if found
     * @throws IllegalArgumentException throws if value is not found
     */
    public static Material findMaterial(String value) {
        Material result = null;
        boolean finished = false;
        for (Material material : Material.values()) {
            if (Objects.equals(material.getValue(), value)) {
                result = material;
                finished = true;
                break;
            }
        }
        if (!finished) {
            throw new IllegalArgumentException(value);
        }
        return result;
    }
}
