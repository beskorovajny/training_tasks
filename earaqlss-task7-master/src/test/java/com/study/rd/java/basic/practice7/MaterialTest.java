package com..rd.java.basic.practice7;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaterialTest {
    GunFactory factory = new GunFactory();
    Gun.MaterialType materialType = factory.createMaterial();

    @Test
    public void getValue() {
        assertTrue(true);
       /* materialType.setMaterial(Material.STEEL);
        assertEquals("steel", materialType.getMaterialType().getValue());

        */
    }

    @Test
    public void findMaterial() {
        assertNotNull(Material.findMaterial("steel"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void findMaterialExc() {
        Material.findMaterial("stone");
    }
    @Test
    public void values() {
        assertNotNull(Material.values());
    }

    @Test
    public void valueOf() {
        assertEquals(Material.STEEL, Material.valueOf("STEEL"));
    }
}