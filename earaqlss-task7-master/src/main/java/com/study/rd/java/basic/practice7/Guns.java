package com..rd.java.basic.practice7;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author besko
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"gun"})
@XmlRootElement(name = "guns")
public class Guns {

    private List<Gun> gun;

    /**
     * {@link Gun}
     *
     * @return ArrayList of guns
     */
    public List<Gun> getGunList() {
        if (gun == null) {
            gun = new ArrayList<>();
        }
        return this.gun;
    }
}
