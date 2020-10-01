package com..rd.java.basic.practice2;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class QueueImplTest {

    @Test

    public void testEnqueue() throws Exception {
        QueueImpl queue1 = new QueueImpl();
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        queue1.enqueue(4);
        queue1.enqueue(5);
        assertEquals("[1, 2, 3, 4, 5]",queue1.toString());
        queue1 = new QueueImpl();
    }

    @Test
    public void testDequeue() throws Exception {
        QueueImpl queue2 = new QueueImpl();
        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);
        queue2.enqueue(4);
        queue2.enqueue(5);
        assertEquals("[1, 2, 3, 4, 5]",queue2.toString());
        queue2.dequeue();
        assertEquals("[2, 3, 4, 5]",queue2.toString());
        assertEquals(2,queue2.dequeue());
    }

    @Test
    public void testTop() throws Exception {
        QueueImpl queue3 = new QueueImpl();
        queue3.enqueue("Lol");
        queue3.enqueue("Kek");
        queue3.enqueue("Cheburek");
        queue3.enqueue("4");
        assertEquals("Lol", queue3.top());
        queue3.clear();
        assertNull(queue3.top());
    }

    @Test
    public void testSize() throws Exception {
        QueueImpl queue4 = new QueueImpl();
        queue4.enqueue(1);
        queue4.enqueue(2);
        queue4.enqueue(3);
        queue4.enqueue(4);
        assertEquals(4,queue4.size());
    }

    @Test
    public void testClear() throws Exception {
        QueueImpl queue5 = new QueueImpl();
        queue5.enqueue(1);
        queue5.enqueue(2);
        queue5.enqueue(3);
        queue5.enqueue(4);
        assertEquals(4,queue5.size());
        queue5.clear();
        assertEquals(0,queue5.size());
    }

    @Test
    public void testHasNext() throws Exception {
        QueueImpl queue5 = new QueueImpl();
        queue5.enqueue(1);
        queue5.enqueue(2);
        queue5.enqueue(3);
        queue5.enqueue(4);
        Iterator<Object> iter = queue5.iterator();
        assertTrue(iter.hasNext());
    }

    @Test
    public void testNext() throws Exception {
        QueueImpl queue5 = new QueueImpl();
        queue5.enqueue(1);
        queue5.enqueue(2);
        queue5.enqueue(3);
        queue5.enqueue(4);
        Iterator<Object> iter = queue5.iterator();
        assertEquals(1, iter.next());
    }


}
