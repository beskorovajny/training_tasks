package com..rd.java.basic.practice6.part3;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkingTest {
    @Test
    public void testArrive1() {
        Parking parking = new Parking(4);
        parking.arrive(2);
        parking.arrive(3);
        assertTrue(parking.arrive(1));
    }
    @Test
    public void testArrive2() {
        Parking parking = new Parking(4);
        parking.arrive(2);
        parking.arrive(3);
        parking.arrive(1);
        parking.arrive(2);
        assertFalse(parking.arrive(1));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testArrive3() throws IllegalArgumentException {
        Parking parking = new Parking(4);
        parking.arrive(6);
    }

    @Test
    public void testDepart1() throws IllegalArgumentException {
        Parking parking = new Parking(4);
        parking.arrive(2);
        parking.arrive(3);
        assertTrue(parking.depart(2));
    }
    @Test
    public void testDepart2() throws IllegalArgumentException {
        Parking parking = new Parking(4);
        parking.arrive(2);
        parking.arrive(3);
        parking.depart(2);
        assertFalse(parking.depart(2));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDepart3() throws IllegalArgumentException {
        Parking parking = new Parking(4);
        parking.arrive(2);
        parking.arrive(3);
        parking.depart(10);
    }

}