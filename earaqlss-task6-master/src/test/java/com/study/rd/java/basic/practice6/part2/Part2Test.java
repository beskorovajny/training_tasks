package com..rd.java.basic.practice6.part2;

import org.junit.Test;

import java.util.List;
import static org.junit.Assert.assertTrue;

public class Part2Test {
    @Test
    public void part2Test1() {
        int k = 4;
        int n = 10_000;
        List<Integer> arrayImpl = Part2.getArrayList(n);
        List<Integer> listImpl = Part2.getLinkedList(n);
        assertTrue(Part2.removeByIndex(arrayImpl,k) < Part2.removeByIndex(listImpl, k));
    }
    @Test
    public void part2Test2() {
        int k = 4;
        int n = 10_000;
        List<Integer> arrayImpl = Part2.getArrayList(n);
        List<Integer> listImpl = Part2.getLinkedList(n);
        assertTrue(Part2.removeByIterator(arrayImpl,k) < Part2.removeByIterator(listImpl, k));
    }

}