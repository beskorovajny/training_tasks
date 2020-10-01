package com..rd.java.basic.practice7;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScopeTypeTest {
    GunFactory factory = new GunFactory();
    Scope scope = factory.createScope();
    @Test
    public void getScope() {
        assertNull(scope.getScopeType());
    }

    @Test
    public void findScope() {
        assertNotNull(ScopeType.findScope("noScope"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void findScopeExc() {
        ScopeType.findScope("4x");
    }

    @Test
    public void values() {
        assertNotNull(ScopeType.values());
    }

    @Test
    public void valueOf() {
        assertEquals(ScopeType.NO_SCOPE, ScopeType.valueOf("NO_SCOPE"));
    }
}