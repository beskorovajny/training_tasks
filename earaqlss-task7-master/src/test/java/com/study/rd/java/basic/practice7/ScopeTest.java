package com..rd.java.basic.practice7;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScopeTest {
    GunFactory factory = new GunFactory();
    Scope scope = factory.createScope();

    @Test
    public void getScopeType() {
        assertNull(scope.getScopeType());
        scope.setType(ScopeType.NO_SCOPE);
        assertEquals(ScopeType.NO_SCOPE, scope.getScopeType());
    }

    @Test
    public void setType() {
        scope.setType(ScopeType.NIGHT_VISION_SCOPE);
        assertNotEquals(ScopeType.NO_SCOPE, scope.getScopeType());
    }
}