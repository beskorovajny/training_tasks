package com..rd.java.basic.practice6.part5;

/**
 * @author beskorovajny
 */
public class Part5 {
    
    public static void main(String[] args) {
        Tree<Integer> testTree = new Tree<>();
        System.out.println(testTree.add(6));
        testTree.add(new Integer[]{1, 4, 3, 0, 2, 6, 5});
        System.out.println(testTree.add(6));
        testTree.print();
        System.out.println(testTree.remove(5));
        System.out.println(testTree.remove(5));

        testTree.print();
    }
    
}
