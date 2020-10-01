package com..rd.java.basic.practice7;

import org.junit.Test;

import static org.junit.Assert.*;

public class GunFactoryTest {
    GunFactory factory = new GunFactory();
    @Test
    public void createGunDesc() {
        Gun gun = factory.createGunDesc();
        assertNotNull(gun);
    }

    @Test
    public void createTacticalCharacteristics() {
        TacticalCharacteristics ttc = factory.createTacticalCharacteristics();
        assertNotNull(ttc);
    }

    @Test
    public void createScope() {
        Scope scope = factory.createScope();
        assertNotNull(scope);
    }

    @Test
    public void createRange() {
        Range range = factory.createRange();
        assertNotNull(range);
    }

    @Test
    public void createFireMode() {
        FireMode fireMode = factory.createFireMode();
        assertNotNull(fireMode);
    }

    @Test
    public void createMaterial() {
        Gun.MaterialType material = factory.createMaterial();
        assertNotNull(material);
    }

    @Test
    public void createGuns() {
        Guns guns = factory.createGuns();
        assertNotNull(guns);
    }
}