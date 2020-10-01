package com..rd.java.basic.practice6.part4;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;

public class RangeTest {
    @Test
    public void rangeIteratorTest() throws Exception {
        Range range = new Range(0,3);
        Iterator<Integer> iterator = range.iterator();
        assertTrue(iterator.hasNext());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void rangeIteratorRemoveTest() {
        Range range = new Range(3,5);
        Iterator<Integer> iterator = range.iterator();
        iterator.remove();
    }

    @Test(expected = IllegalArgumentException.class)
    public void rangeArgumentsExceptionTest() {
        Range range = new Range(3,1);
    }

    @Test(expected = NoSuchElementException.class)
    public void rangeIteratorNextExceptionTest() {
        Range range = new Range(3,3);
        Iterator<Integer> iterator = range.iterator();
        int tmp = iterator.next();
        int tmp2 = iterator.next();
    }


}
