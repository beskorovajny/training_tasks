package com..rd.java.basic.practice2;

import org.junit.Test;


import static org.junit.Assert.*;
public class ListImplTest {

    @Test
    public void testClear() throws Exception {
        ListImpl list = new ListImpl("A");
        list.clear();
        assertEquals(0,list.size());
    }

    @Test
    public void testSize() throws Exception {
        ListImpl list = new ListImpl();
        list.addFirst("A");
        list.addFirst("b");
        assertEquals(2,list.size());
    }

    @Test
    public void testAddFirst() throws Exception {
        ListImpl list = new ListImpl("First");
        list.addFirst("new First");
        assertEquals("[new First, First]",list.toString());
    }

    @Test
    public void testAddLast() throws Exception {
        ListImpl list = new ListImpl("First");
        list.addFirst("new First");
        list.addLast("Last");
        assertEquals("[new First, First, Last]",list.toString());
        list.clear();
        list.addLast("A");
        assertEquals("A",list.getFirst());
    }

    @Test
    public void testRemoveFirst() throws Exception {
        ListImpl list = new ListImpl("First");
        list.addFirst("new First");
        list.addLast("Last");
        list.removeFirst();
        assertEquals("[First, Last]",list.toString());
    }

    @Test
    public void testRemoveLast() throws Exception {
        ListImpl list = new ListImpl("First");
        list.addFirst("new First");
        list.addLast("Last");
        list.removeLast();
        assertEquals("[new First, First]",list.toString());
    }

    @Test
    public void testRemove() throws Exception {
        ListImpl list = new ListImpl("First");
        list.addFirst("new");
        list.addLast("Last");
        list.remove("First");
        assertEquals("[new, Last]",list.toString());
    }

    @Test
    public void testGetFirst() throws Exception {
        ListImpl list = new ListImpl("First");
        list.addFirst("new");
        list.addLast("Last");
        assertEquals("new", list.getFirst());
    }

    @Test
    public void testGetLast() throws Exception {
        ListImpl list = new ListImpl("First");
        list.addFirst("new");
        list.addLast("Last");
        assertEquals("Last", list.getLast());
    }

    @Test
    public void testSearch() throws Exception {
        ListImpl list = new ListImpl("First");
        list.addFirst("new");
        list.addLast("Last");
        assertEquals("new", list.search("new"));
    }

}
