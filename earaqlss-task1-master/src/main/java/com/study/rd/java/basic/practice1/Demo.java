package com.study.rd.java.basic.practice1;


/**
 * @author beskorovajny
 */
public class Demo {

    public static void main(String[] args) {
        /* Task 1 */
        print("Task 1\n");
        Part1.main(new String[]{});
        print("\n");

        /* Task 2 */
        print("Task 2\n");
        Part2.main(new String[]{"6", "2", "3", "4"});
        print("\n");

        /* Task 3 */
        print("Task 3\n");
        Part3.main(new String[]{"a","asd","212","5"});
        print("\n");

        /* Task 4 */
        print("Task 4\n");
        Part4.main(new String[]{"196","112"});
        print("\n");

        /* Task 5 */
        print("Task 5\n");
        Part5.main(new String[]{"123780"});
        print("\n");

        /* Task 6 */
        print("Task 6\n");
        Part6.main(new String[]{"6"});
        print("\n");

        print("Task 7\n");
        Part7.main(new String[]{});
        print("\n");
        print("Check rightColumn method : ");
        print(Part7.rightColumn("Z") + "\n");


    }

    static void print(String s) {
        System.out.print(s);
    }

}
