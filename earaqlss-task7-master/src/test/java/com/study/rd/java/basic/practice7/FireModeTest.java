package com..rd.java.basic.practice7;

import org.junit.Test;

import static org.junit.Assert.*;

public class FireModeTest {

    FireMode fireMode = new FireMode();


    @Test
    public void getFireMode() {
        fireMode.setFireMode(FireModeType.AUTO);
        assertEquals("auto", fireMode.getFireMode().name().toLowerCase());
    }

    @Test
    public void setFireMode() {
        fireMode.setFireMode(FireModeType.SEMI_AUTO);
        assertEquals("semi_auto", fireMode.getFireMode().name().toLowerCase());
    }
}