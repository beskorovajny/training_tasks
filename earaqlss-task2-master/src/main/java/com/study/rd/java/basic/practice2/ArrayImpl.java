package com.study.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;


/**
 * @author beskorovajny
 */
public class ArrayImpl implements Array {
    private Object[] arrayData;
    private int arrayElementsCount;
    private static final int ARRAY_DEFAULT_SIZE = 10;

    public ArrayImpl() {
        this(ARRAY_DEFAULT_SIZE);
    }

    public ArrayImpl(int size) {
        if (size >= 0) {
             arrayData = new Object[size];
             arrayElementsCount = 0;
        }
    }

	@Override
    public void clear() {
        for (int i = 0; i < arrayData.length; i++) {
            arrayData[i] = null;
        }
        arrayElementsCount = 0;
    }

	@Override
    public int size() {
        return arrayElementsCount;
    }
	
	@Override
    public Iterator<Object> iterator() {
	    return new IteratorImpl();
    }
	
	private class IteratorImpl implements Iterator<Object> {
        private int currentArrayIndex = 0;

        @Override
        public boolean hasNext() {
            return currentArrayIndex < arrayElementsCount;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return arrayData[currentArrayIndex++];
            } else {
                throw  new NoSuchElementException();
            }
        }

    }

	@Override
    public void add(Object element) {
        if ((((arrayElementsCount - 1) + 1) + 1) >= arrayData.length) {
            Object[] oldData = arrayData;
            int newSize = (arrayData.length * 3) / 2 + 1;
            arrayData = new Object[newSize];
            System.arraycopy(oldData, 0, arrayData, 0, arrayElementsCount);
        }
        arrayData[arrayElementsCount++] = element;
    }

	@Override
    public void set(int index, Object element) {
        if (index >= 0 && index < arrayElementsCount) {
            arrayData[index] = element;
        }
    }

	@Override
    public Object get(int index) {
        if (index >= 0 && index < arrayElementsCount) {
            return arrayData[index];
        }
        return null;
    }

	@Override
    public int indexOf(Object element) {
        if (element == null) {
            for (int i = 0;i < arrayElementsCount; i++) {
                if (arrayData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < arrayElementsCount; i++) {
                if (element.equals(arrayData[i])){
                    return i;
                }
            }
        }
        return  -1;
    }

	@Override
    public void remove(int index) {
        if (index >= 0 && index < arrayElementsCount) {
            int tmp = index;
            arrayData[index] = null;

            while(tmp < arrayElementsCount) {
                arrayData[tmp] = arrayData[tmp + 1];
                arrayData[tmp + 1] = null;
                tmp++;
            }
            arrayElementsCount--;
        }
    }

    @Override
    public String toString() {
        StringBuilder arraySb = new StringBuilder("[");
        for (int i = 0; i < arrayElementsCount; i++) {
            if (i > 0) {
                arraySb.append(", ");
            }
            arraySb.append(arrayData[i]);

        }
        arraySb.append("]");

        return arraySb.toString();
    }

    public static void main(String[] args) {
        ArrayImpl list = new ArrayImpl();

            list.add("A");
            list.add("B");
            list.add("C");
            list.add("3");
            list.add("Hello");
            list.add(null);
            list.clear();

    }

}
