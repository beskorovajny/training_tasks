package com..rd.java.basic.practice7;

import javax.xml.bind.annotation.*;
import java.util.Objects;

/**
 * @author besko
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gunDescription", propOrder = {
        "model",
        "handy",
        "origin",
        "tacticalCharacteristics",
        "material"
})
public class Gun {
    @XmlElement(required = true)
    protected String model;
    @XmlElement(required = true)
    protected int handy;
    @XmlElement(required = true)
    protected String origin;
    @XmlElement(required = true)
    protected TacticalCharacteristics tacticalCharacteristics;
    @XmlElement(required = true)
    protected MaterialType material;


    /**
     * getter for model field
     *
     * @return string value of model
     */
    public String getModel() {
        return model;
    }

    /**
     * setter for model field
     *
     * @param value string representation of model
     */
    public void setModel(String value) {
        this.model = value;
    }

    /**
     * getter for handy field
     *
     * @return int value of handy
     */
    public int getHandy() {
        return handy;
    }

    /**
     * setter for handy filed
     *
     * @param value integer
     */
    public void setHandy(int value) {
        if (value <= 0 || value > 2) {
            throw new IllegalArgumentException();
        }
        this.handy = value;
    }

    /**
     * getter for origin field
     *
     * @return string value
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * setter for origin field
     *
     * @param value string value to set
     */
    public void setOrigin(String value) {
        this.origin = value;
    }

    /**
     * get tactical characteristics value
     *
     * @return {@link TacticalCharacteristics}
     */
    public TacticalCharacteristics getTacticalCharacteristics() {
        return tacticalCharacteristics;
    }

    /**
     * set tactical characteristic field
     *
     * @param tacticalCharacteristics {@link TacticalCharacteristics} object
     */
    public void setTacticalCharacteristics(TacticalCharacteristics tacticalCharacteristics) {
        this.tacticalCharacteristics = tacticalCharacteristics;
    }

    /**
     * getter for material field
     *
     * @return {@link Material} object instance
     */
    public MaterialType getMaterial() {
        return material;
    }

    /**
     * setter for material field
     *
     * @param material instance of {@link Material} object
     */
    public void setMaterial(MaterialType material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Gun)) {
            return false;
        }
        Gun gun = (Gun) o;
        return getHandy() == gun.getHandy() &&
                Objects.equals(getModel(), gun.getModel()) &&
                Objects.equals(getOrigin(), gun.getOrigin()) &&
                Objects.equals(getTacticalCharacteristics(), gun.getTacticalCharacteristics()) &&
                Objects.equals(getMaterial(), gun.getMaterial());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getHandy(), getOrigin(), getTacticalCharacteristics(), getMaterial());
    }

    @Override
    public String toString() {
        return "Gun{" +
                "\nmodel='" + model + '\'' +
                ", handy=" + handy +
                ", origin='" + origin + '\'' +
                "\n, tacticalCharacteristics=" + tacticalCharacteristics +
                "\n, material=" + material +
                '}';
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class MaterialType {
        @XmlAttribute(name = "material", required = true)
        protected Material materialT;

        /**
         * @return enum Material {@link Material}
         */
        public Material getMaterialType() {
            return materialT;
        }

        public void setMaterial(Material materialType) {
            this.materialT = materialType;
        }

        @Override
        public String toString() {
            return "MaterialType{" +
                    "materialType=" + materialT +
                    '}';
        }
    }

    }
