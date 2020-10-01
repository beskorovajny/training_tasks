package com..rd.java.basic.practice4;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Part6Test {
    @Test
    public void testP6() {
        String input = "Is there anybody going to listen to my story\n" +
                "Р С РіР С Р Р Р С Р С Р РІС Р Р\" +\n" +
                "Р С С РІР С Р Р Р С С Р Р С С Р Р Р +\n" +
                "С С Р РёРєРё Р Р Р Р С РёР РёС С РїС Р +\n" +
                "С С РІР С Рё Р Р Р С Р Р Р Р Р Р С Р Р +\n" +
                "РёС С Р РёРє Р С Р Р С Р Р С Р";
        String latnText = "Is there anybody going to listen to my story";
        String cyrlText = "Р С РіР С Р Р Р С Р С Р РІС Р Р" +
                " Р С С РІР С Р Р Р С С Р Р С С Р Р Р " +
                "С С Р РёРєРё Р Р Р Р С РёР РёС С РїС Р " +
                "С С РІР С Рё Р Р Р С Р Р Р Р Р Р С Р Р" +
                " РёС С Р РёРє Р С Р Р С Р Р С Р";

        assertEquals(cyrlText,Part6.convertInputToRule(input, Part6.CYRL));
        assertEquals(latnText,Part6.convertInputToRule(input,Part6.LATN));
    }

}