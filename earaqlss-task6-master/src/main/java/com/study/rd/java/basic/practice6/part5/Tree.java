package com..rd.java.basic.practice6.part5;

import java.util.stream.Stream;

/**
 * @author beskorovajny
 */
public class Tree<E extends Comparable<E>> {
    private static final String SHORT_TAB = "  ";
    private Node<E> rootNode = null;
    private int size = 0;

    public boolean add(E element) {
        if (rootNode == null) {
            rootNode = new Node<>(element);
            size++;
            return true;
        }
        if (add(rootNode, element)) {
            size++;
            return true;
        }
        return false;
    }

    public void add(E[] elements) {
        Stream.of(elements).forEach(this::add);
    }

    public boolean remove(E element) {
        int tmpSize = size;
        rootNode = removeHelper(rootNode, element);
        return tmpSize == size + 1;
    }

    private boolean add(Node<E> node, E value) {
        int result = value.compareTo(node.element);

        if (result == 0) {
            return false;
        } else if (result < 0) {
            if (node.leftNode == null) {
                node.leftNode = new Node<>(value);
                return true;
            } else {
                return add(node.leftNode, value);
            }
        } else {
            if (node.rightNode == null) {
                node.rightNode = new Node<>(value);
                return true;
            } else {
                return add(node.rightNode, value);
            }
        }
    }

    private E minElement(Node<E> node) {
        if (node.leftNode != null) {
            return minElement(node.leftNode);
        }
        return node.element;
    }

    private Node<E> removeHelper(Node<E> current, E value) {
        if (current == null) {
            return null;
        }
        int result = value.compareTo(current.element);
        if (result == 0) {
            size--;
            if (current.leftNode == null && current.rightNode == null) {
                return null;
            } else if (current.leftNode == null) {
                return current.rightNode;
            } else if (current.rightNode == null) {
                return current.leftNode;
            } else {
                E minValue = minElement(current.rightNode);
                current.element = minValue;
                current.rightNode = removeHelper(current.rightNode, minValue);
            }
        }
        if (result < 0) {
            current.leftNode = removeHelper(current.leftNode, value);
            return current;
        }
        current.rightNode = removeHelper(current.rightNode, value);
        return current;
    }



    public void print() {
        printHelper(rootNode, 0, "");
    }

    private void printHelper(Node<E> node, Integer integer, String str) {

        if (node != null) {

            if (integer > 0) {
                str = str + SHORT_TAB;
            }
            integer += 1;

            printHelper(node.leftNode, integer, str);

            System.out.println(str + node.element);

            printHelper(node.rightNode, integer, str);
        }

    }

    private static final class Node<E> {
        private E element;
        private Node<E> leftNode;
        private Node<E> rightNode;

        public Node(E value) {
            this.element = value;
            leftNode = null;
            rightNode = null;
        }
    }

}

