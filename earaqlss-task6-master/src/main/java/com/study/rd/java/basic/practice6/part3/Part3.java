package com..rd.java.basic.practice6.part3;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author beskorovajny
 */
public class Part3 {
    private static final Logger LOGGER = Logger.getLogger(Part3.class.getName());
    
    public static void main(String[] args) {

        Parking parking1 = new Parking(4);
        parking1.arrive(2);
        parking1.print();
        parking1.arrive(2);
        parking1.print();
        parking1.arrive(2);
        parking1.depart(2);
        parking1.print();
        parking1.arrive(2);
        try {
            parking1.arrive(10);
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, "Exception : ", e);
        }
        try {
            parking1.depart(7);
        }catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, "Exception : ", e);
        }
        parking1.depart(2);


    }

}
