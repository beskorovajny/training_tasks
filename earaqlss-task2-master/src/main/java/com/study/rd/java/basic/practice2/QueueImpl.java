package com.study.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * @author beskorovajny
 */
public class QueueImpl implements Queue {

    private Object[] queueData;
    private int queueElementsCount;
    private static final int QUEUE_DEFAULT_SIZE = 10;


    public QueueImpl() {
        this(QUEUE_DEFAULT_SIZE);
    }

    public QueueImpl(int size) {
        if (size >= 0) {
            queueData = new Object[size];
            queueElementsCount = 0;
        }
    }

    @Override
    public void clear() {
        if (queueData.length > 0) {
            for (int i = 0; i < queueData.length; i++) {
                queueData[i] = null;
            }
            queueElementsCount = 0;
        }
    }

    @Override
    public int size() {
        return queueElementsCount;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        private int queueCurrentIndex = 0;

        @Override
        public boolean hasNext() {
            return queueCurrentIndex < queueElementsCount;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return queueData[queueCurrentIndex++];
            } else {
                throw  new NoSuchElementException();
            }
        }

    }

    @Override
    public void enqueue(Object element) {
        if ((queueElementsCount + 1) >= queueData.length) {
            Object[] oldQueueData = queueData;
            int newSize = (queueData.length * 3) / 2 + 1;
            queueData = new Object[newSize];
            System.arraycopy(oldQueueData, 0, queueData, 0, queueElementsCount);
        }
        queueData[queueElementsCount++] = element;
    }

    @Override
    public Object dequeue() {
        if (queueElementsCount > 0) {
           Object tmp = queueData[0];
            for (int i = 0; i < queueElementsCount - 1; i++) {
                queueData[i] = queueData[i + 1];
            }
            queueElementsCount--;
            return tmp;
        }
        return null;
    }

    @Override
    public Object top() {
        if (queueElementsCount > 0) {
            return queueData[0];
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder queueSb = new StringBuilder("[");
        for (int i = 0; i < queueElementsCount; i++) {
            if (i > 0) {
                queueSb.append(", ");
            }
            queueSb.append(queueData[i]);

        }
        queueSb.append("]");

        return queueSb.toString();
    }
    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl(10);

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        queue.clear();
    }

}
