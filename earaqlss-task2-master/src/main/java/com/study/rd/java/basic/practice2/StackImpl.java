package com..rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * @author beskorovajny
 */
public class StackImpl implements Stack {
    private Object[] stackData;
    private int stackElementsCount;
    private static final int DEFAULT_SIZE = 10;

    public StackImpl() {
        this(DEFAULT_SIZE);
    }

    public StackImpl(int size) {
        if (size >= 0) {
            stackData = new Object[size];
            stackElementsCount = 0;
        }
    }

    @Override
    public void clear() {
        if (stackData.length > 0) {
            for (int i = 0; i < stackData.length; i++) {
                stackData[i] = null;
            }
            stackElementsCount = 0;
        }
    }

    @Override
    public int size() {
        return stackElementsCount;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        private int currentIndex = stackElementsCount - 1;

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public Object next()  {
            if (this.hasNext()) {
                return stackData[currentIndex--];
            } else {
                throw  new NoSuchElementException();
            }

        }

    }

    @Override
    public void push(Object element) {
        if ((stackElementsCount + 1) >= stackData.length) {
            Object[] oldData = stackData;
            int newSize = (stackData.length * 3) / 2 + 1;
            stackData = new Object[newSize];
            System.arraycopy(oldData, 0, stackData, 0, stackElementsCount);
        }
        stackData[stackElementsCount++] = element;
    }

    @Override
    public Object pop() {
        if (stackElementsCount > 0) {
            Object tmp = stackData[stackElementsCount - 1];
            Object[] old = stackData;
            int newSize = stackData.length;
            stackData = new Object[newSize - 1];
            System.arraycopy(old,0,stackData,0,newSize - 1);
            stackElementsCount--;
            return tmp;
        }
        return null;
    }

    @Override
    public Object top() {
        if (stackElementsCount > 0) {
            return stackData[stackElementsCount - 1];
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < stackElementsCount; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(stackData[i]);

        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        StackImpl stack1 = new StackImpl();
        stack1.push("A");
        stack1.push("B");
        stack1.push("C");

        stack1.pop();

        stack1.clear();
    }

}
