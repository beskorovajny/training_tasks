package com..rd.java.basic.practice7;

import org.junit.Test;

import static org.junit.Assert.*;

public class TacticalCharacteristicsTest {
    GunFactory factory = new GunFactory();
    TacticalCharacteristics ttc = factory.createTacticalCharacteristics();
    Scope scope = factory.createScope();
    FireMode fireMode = factory.createFireMode();
    Range range = factory.createRange();

    public void init() {
        scope.setType(ScopeType.NO_SCOPE);
        fireMode.setFireMode(FireModeType.AUTO);
        range.setEffectiveRange(EffectiveRange.SHORT);
        ttc.setFireMode(fireMode);
        ttc.setEffectiveRange(range);
        ttc.setScope(scope);
    }

    @Test
    public void getScope() {
        init();
        assertEquals(ScopeType.NO_SCOPE, ttc.getScope().getScopeType());
    }

    @Test
    public void setScope() {
        scope.setType(ScopeType.ACOG);
        ttc.setScope(scope);
        assertEquals(ScopeType.ACOG, ttc.getScope().getScopeType());
    }

    @Test
    public void getEffectiveRange() {
        init();
        assertEquals(EffectiveRange.SHORT, ttc.getEffectiveRange().getEffectiveRange());
    }

    @Test
    public void setEffectiveRange() {
        range.setEffectiveRange(EffectiveRange.LONG);
        ttc.setEffectiveRange(range);
        assertEquals(EffectiveRange.LONG, ttc.getEffectiveRange().getEffectiveRange());
    }

    @Test
    public void getFireMode() {
        init();
        assertEquals(FireModeType.AUTO, ttc.getFireMode().getFireMode());
    }

    @Test
    public void setFireMode() {
        fireMode.setFireMode(FireModeType.REGULAR);
        ttc.setFireMode(fireMode);
        assertEquals(FireModeType.REGULAR, ttc.getFireMode().getFireMode());
    }
}