package com..rd.java.basic.practice6.part2;

import java.util.*;

/**
 * @author beskorovajny
 */
public class Part2 {

    public static void main(String[] args) {
        int k = 4;
        int n = 10_000;
        List<Integer> arrayImpl = Part2.getArrayList(n);
        List<Integer> listImpl = Part2.getLinkedList(n);

        System.out.println("ArrayList#Index: " + removeByIndex(arrayImpl, k) + " ms");
        System.out.println("LinkedList#Index: " + removeByIndex(listImpl, k) + " ms");
        arrayImpl = Part2.getArrayList(n);
        listImpl = Part2.getLinkedList(n);
        System.out.println("ArrayList#Iterator: " + removeByIterator(arrayImpl, k) + " ms");
        System.out.println("LinkedList#Iterator: " + removeByIterator(listImpl, k) + " ms");



    }

    public static List<Integer> getArrayList(long size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }
    public static List<Integer> getLinkedList(long size) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }


    public static long removeByIndex(final List<Integer> list, final int k) {
        long time = System.currentTimeMillis();
        int local = 0;
        while (list.size() > 1) {
            local += k;
            if (local >= list.size()) {
                local %= list.size();
            }
            list.remove(local);
        }
        return System.currentTimeMillis() - time;
    }

    public static long removeByIterator(final List<Integer> list, int k) {
        long start = System.currentTimeMillis();

        int tmpIndex = 0;

        while(!list.isEmpty()){
            Iterator<Integer> iterator = list.iterator();

            tmpIndex+=k;

            while (tmpIndex > list.size()) { tmpIndex -= list.size(); }

            int iterIndex = tmpIndex;
            while (iterIndex>0){
                iterator.next();
                iterIndex--;
            }
            iterator.remove();
            tmpIndex--;
        }

        long end = System.currentTimeMillis();
        return end - start;
    }


}
