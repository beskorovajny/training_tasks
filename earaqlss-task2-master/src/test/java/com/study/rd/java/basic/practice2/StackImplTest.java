package com..rd.java.basic.practice2;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackImplTest {

    @Test
    public void testPush() throws Exception {
        StackImpl stack1 = new StackImpl(10);
        stack1.push("A");
        stack1.push("B");
        stack1.push("C");
        stack1.push("D");
        assertEquals("[A, B, C, D]",stack1.toString());
    }

    @Test
    public void testPop() throws Exception {
        StackImpl stack2 = new StackImpl(10);
        stack2.push("A");
        stack2.push("B");
        stack2.push("C");
        stack2.push("D");
        assertEquals("[A, B, C, D]",stack2.toString());
        assertEquals("D",stack2.pop());
        assertEquals("[A, B, C]",stack2.toString());
    }

    @Test
    public void testTop() throws Exception {
        StackImpl stack3 = new StackImpl(10);
        stack3.push("A");
        stack3.push("B");
        stack3.push("C");
        stack3.push("D");
        assertEquals("D",stack3.top());
    }

    @Test
    public void testClear() throws Exception {
        StackImpl stack3 = new StackImpl();
        stack3.push("A");
        stack3.push("B");
        stack3.push("C");
        stack3.push("D");
        assertEquals(4,stack3.size());
        stack3.clear();
        assertEquals(0,stack3.size());
    }
}
