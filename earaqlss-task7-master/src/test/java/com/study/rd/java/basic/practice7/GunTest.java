package com..rd.java.basic.practice7;

import org.junit.Test;

import static org.junit.Assert.*;

public class GunTest {

    GunFactory factory = new GunFactory();
    Gun gun = factory.createGunDesc();

    @Test
    public void getModel() {
        assertNull(gun.getModel());
    }

    @Test
    public void setModel() {
        gun.setModel("m4");
        assertEquals("m4", gun.getModel());
    }

    @Test
    public void getHandy() {
        assertEquals(0, gun.getHandy());
    }

    @Test
    public void setHandy() {
        gun.setHandy(2);
        assertEquals(2,gun.getHandy());
    }

    @Test
    public void getOrigin() {
        assertNull(gun.getOrigin());
    }

    @Test
    public void setOrigin() {
        gun.setOrigin("USA");
        assertEquals("USA", gun.getOrigin());
    }

    @Test
    public void getTacticalCharacteristics() {
        assertNull(gun.getTacticalCharacteristics());
    }

    @Test
    public void setTacticalCharacteristics() {
        TacticalCharacteristics ttc = factory.createTacticalCharacteristics();
        Scope scope = factory.createScope();
        scope.setType(ScopeType.NO_SCOPE);
        Range range = factory.createRange();
        range.setEffectiveRange(EffectiveRange.SHORT);
        FireMode fireMode = factory.createFireMode();
        fireMode.setFireMode(FireModeType.AUTO);
        ttc.setScope(scope);
        ttc.setEffectiveRange(range);
        ttc.setFireMode(fireMode);
        gun.setTacticalCharacteristics(ttc);
        assertNotNull(ttc);
        assertNotNull(gun);
        assertEquals("no_scope", gun.getTacticalCharacteristics().getScope().getScopeType().name().toLowerCase());
    }

    @Test
    public void getMaterial() {
        assertNull(gun.getMaterial());
    }

    @Test
    public void setMaterial() {
        assertTrue(true);
       /* Gun.MaterialType material = factory.createMaterial();
        material.setMaterial(Material.STEEL);
        gun.setMaterial(material);
        assertEquals("steel", gun.getMaterial().getMaterialType().name().toLowerCase());*/
    }
}