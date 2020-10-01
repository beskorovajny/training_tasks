package com..rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author beskorovajny
 */
public class ListImpl implements List {
    private int size = 0;
    Node<Object> first;
    Node<Object> last;

    private static class Node<E>{
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void clear() {
        for(Node<Object> x = first; x!=null;) {
            Node<Object> next  = x.next;
            x.element = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;


    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        private Node<Object> lastReturned;
        private Node<Object> next = ListImpl.this.first;
        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public Object next() {
            if(!hasNext())throw new NoSuchElementException();
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.element;
        }

    }

    @Override
    public void addFirst(Object e) {
        final Node<Object> f = first;
        final Node<Object> newNode = new Node<Object>(null, e, f);
        first = newNode;
        if(f == null) {
            last = newNode;
        }else {
            f.prev  = newNode;
            size++;
        }
    }//addFirst

    @Override
    public void addLast(Object e) {
        final Node<Object> l = last;
        final Node<Object> newNode = new Node<Object>(l, e, null);
        last = newNode;
        if(l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }//addLast

    @Override
    public void removeFirst() {
        final Node<Object> f = first;
        if(f == null) {
            throw new NoSuchElementException();
        }
        final Node<Object> next = f.next;
        f.element = null;
        f.next = null;
        first = next;
        if(next == null)
            last = null;
        else
            next.prev = null;
        size--;
    }//removeFirst

    @Override
    public void removeLast() {
        final Node<Object> l = last;
        if(l == null) {
            throw new NoSuchElementException();

        }
        final Node<Object> prev = l.prev;
        l.element = null;
        l.prev = null;
        last = prev;
        if(prev == null)
            first = null;
        else
            prev.next = null;
        size--;
    }//removeLast

    @Override
    public Object getFirst() {
        final Node<Object> f = first;
        if(f == null) {
            return null;
        }
        if(size <= 0) {
            throw new NoSuchElementException();
        }
        return f.element;
    }//getFirst

    @Override
    public Object getLast() {
        final Node<Object> l  = last;
        if(l == null) {
            return null;
        }
        if(size == 0) {
            throw new NoSuchElementException();
        }
        return l.element;
    }//getLast

    @Override
    public Object search(Object el) {
        if(el == null) {
            for(Node<Object> x = first; x!=null; x = x.next) {
                if(x.element == null) {
                    return null;
                }
            }
        }else {
            for(Node<Object> x = first; x!=null; x = x.next) {
                if(el.equals(x.element)) {
                    return x.element;
                }
            }
        }
        return null;
    }

    @Override
    public boolean remove(Object el) {
        if( el == null) {
            for(Node<Object> x  = first; x!= null; x = x.next) {
                if(x.element == null) {
                    unlink(x);
                    return true;
                }
            }
        }else {
            for(Node<Object> x = first; x!= null; x = x.next) {
                if(el.equals(x.element)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    private void unlink(Node<Object> x) {
        final Object element = x.element;
        final Node<Object> next = x.next;
        final Node<Object> prev = x.prev;

        if(prev == null) {
            first = next;
        }else {
            prev.next = next;
            x.prev = null;
        }
        if(next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.element = null;
        size--;
    }

    @Override
    public String toString() {
        String [] myString = new String[size()];
        int counter = 0;
        for(Node<Object> e = first; e!=null; e = e.next) {
            myString[counter++] = String.valueOf(e.element);
        }
        return "[" + String.join(", ", myString) + "]";
    }

    public static void main(String[] args) {

    }
}
