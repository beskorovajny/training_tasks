package com..rd.java.basic.practice4;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Part2Test {
    @Test
    public void sortTest() {
        int[] arr = new int[]{5,12,11,56,23,111,0,563};
        int[] sorted = new int[]{0,5,11,12,23,56,111,563};
        Part2.bubbleSort(arr);
        assertEquals(Part2.arrayToString(sorted),Part2.arrayToString(arr));
    }


}