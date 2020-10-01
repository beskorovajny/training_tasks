package com..rd.java.basic.practice2;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ArrayImplTest {
    @Test
    public void testAdd() throws Exception {
        ArrayImpl list1 = new ArrayImpl();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        assertEquals("[A, B, C]", list1.toString());
    }

    @Test
    public void testGet() throws Exception {
        ArrayImpl list2 = new ArrayImpl(10);
        list2.add("node1");
        list2.add("node2");
        list2.add("node3");
        assertEquals("node3",list2.get(2));
    }

    @Test
    public void testSize() throws Exception{
        ArrayImpl list3 = new ArrayImpl();
        list3.add("ww");
        list3.add("ww2");
        list3.add("w22");
        assertEquals(3,list3.size());
    }

    @Test
    public void testIndexOf() throws Exception{
        ArrayImpl list4 = new ArrayImpl();
        list4.add(1);
        list4.add(2);
        list4.add(4);
        assertEquals(0, list4.indexOf(1));
        assertEquals(2,list4.indexOf(4));
    }

    @Test
    public void testSet() throws Exception{
        ArrayImpl list5 = new ArrayImpl(5);
        list5.add("222s");
        list5.add("asda");
        list5.set(1,"setvalue");
        assertEquals("setvalue",list5.get(1));
    }

    @Test
    public void testClear() throws Exception {
        ArrayImpl list6 = new ArrayImpl();
        list6.add("c");
        list6.add("z");
        list6.add("X");
        assertEquals(3,list6.size());
        list6.clear();
        assertEquals(0,list6.size());
    }

    @Test
    public void testRemove() throws Exception {
        ArrayImpl list7 = new ArrayImpl();
        list7.add("A");
        list7.add("B");
        list7.add("C");
        list7.add("D");
        assertEquals("[A, B, C, D]",list7.toString());
        list7.remove(3);
        assertEquals("[A, B, C]",list7.toString());

    }

    @Test
    public void testHasNext() throws Exception {
        ArrayImpl list7 = new ArrayImpl();
        list7.add("A");
        list7.add("B");
        list7.add("C");
        list7.add("D");
        Iterator<Object> iterator = list7.iterator();
        assertTrue(iterator.hasNext());
    }

    @Test
    public void testNext() throws Exception {
        ArrayImpl list7 = new ArrayImpl();
        list7.add("A");
        list7.add("B");
        list7.add("C");
        list7.add("D");
        Iterator<Object> iterator = list7.iterator();
        assertEquals("A",iterator.next());
    }

    @Test
    public void testToString() throws Exception {
        ArrayImpl list7 = new ArrayImpl();
        list7.add("A");
        list7.add("B");
        list7.add("C");
        list7.add("D");
        assertEquals("[A, B, C, D]",list7.toString());
    }

}
