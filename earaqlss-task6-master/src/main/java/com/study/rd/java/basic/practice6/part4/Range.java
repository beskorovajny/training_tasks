package com..rd.java.basic.practice6.part4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author beskorovajny
 */
public class Range implements Iterable<Integer>{

    private final int start;
    private final int end;
    private final boolean descending;

    public Range(int n, int m) {
        this(n, m, false);
    }

    public Range(int firstBound, int secBound, boolean reversedOrder) {
        if (firstBound > secBound) {
            throw new IllegalArgumentException();
        }
        this.start = firstBound;
        this.end = secBound;
        this.descending = reversedOrder;
    }


    @Override
    public Iterator<Integer> iterator() {
        if (descending) {
            return new DescendingIterator();
        } else {
            return new AscendingIterator();
        }

    }


    private class AscendingIterator implements Iterator<Integer> {
        private int tmp;

        AscendingIterator() {
            tmp = start - 1;
        }

        @Override
        public boolean hasNext() {
            return tmp < end;
        }

        @Override
        public Integer next() {
            if (this.hasNext()) {
                return ++tmp;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class DescendingIterator implements Iterator<Integer> {
        private int tmp;

        DescendingIterator() {
            tmp = end + 1;
        }

        @Override
        public boolean hasNext() {
            return tmp > start;
        }

        @Override
        public Integer next() {
            if (this.hasNext()) {
                return --tmp;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }
    public void print() {
        for (Integer integer : this) {
            System.out.printf("%d", integer);
        }
    }

}
