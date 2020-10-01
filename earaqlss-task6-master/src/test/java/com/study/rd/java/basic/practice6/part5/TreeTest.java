package com..rd.java.basic.practice6.part5;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTest {
    @Test
    public void addMethodShouldReturnTrueIfElementDoesNotExists() {
        Tree<Integer> testTree = new Tree<>();
        assertTrue(testTree.add(2));
    }

    @Test
    public void addMethodShouldReturnFalseIfElementIsExists() {
        Tree<Integer> testTree = new Tree<>();
        testTree.add(2);
        assertFalse(testTree.add(2));
    }

    @Test
    public void removeMethodShouldReturnFalseIfElementDoesNotExists() {
        Tree<Integer> testTree = new Tree<>();
        assertFalse(testTree.remove(2));
    }

    @Test
    public void removeMethodShouldReturnTrueIfElementIsExists() {
        Tree<Integer> testTree = new Tree<>();
        testTree.add(2);
        assertTrue(testTree.remove(2));
    }

    
}
