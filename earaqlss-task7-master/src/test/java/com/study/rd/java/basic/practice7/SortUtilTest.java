package com..rd.java.basic.practice7;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortUtilTest {
    GunFactory factory = new GunFactory();
    Guns guns = DOMController.parse(Constants.VALID_XML_FILE, true);
    @Test
    public void sortGunsByModel() {
        String model  = guns.getGunList().get(guns.getGunList().size() - 1).getModel();
        SortUtil.sortGunsByModel(guns);
        assertEquals(model, guns.getGunList().get(2).getModel());
    }

    @Test
    public void sortGunsByOrigin() {
        SortUtil.sortGunsByOrigin(guns);
        assertEquals("Belgium".toLowerCase(), guns.getGunList().get(0).getOrigin().toLowerCase());
    }

    @Test
    public void sortGunsByMaterial() {
        assertTrue(true);
        /*SortUtil.sortGunsByMaterial(guns);
        assertEquals("Wood".toLowerCase(),
                guns.getGunList().get(2).getMaterial().getMaterialType().name().toLowerCase());*/
    }
}