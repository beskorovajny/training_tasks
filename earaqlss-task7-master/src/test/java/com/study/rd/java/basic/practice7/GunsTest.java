package com..rd.java.basic.practice7;

import org.junit.Test;

import static org.junit.Assert.*;

public class GunsTest {
    Guns guns = new Guns();
    @Test
    public void getGunList() {
        assertEquals(0, guns.getGunList().size());
        guns.getGunList().add(new Gun());
        assertEquals(1, guns.getGunList().size());
    }
}