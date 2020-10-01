package com..rd.java.basic.practice3;

import org.junit.Test;

import static org.junit.Assert.*;

public class Part1Test {
    @Test
    public void testConvert1() {
        String s1 = "Login;Name;Email\n" +
                "ivanov;Ivan Ivanov;ivanov@mail.com\n" +
                "петров;Петр Петров;petrov@google.com\n" +
                "obama;Barack Obama;obama@google.com\n" +
                "bush;Джордж Буш;bush@mail.com";
        String s2 = "ivanov: ivanov@mail.com\n" +
                "петров: petrov@google.com\n" +
                "obama: obama@google.com\n" +
                "bush: bush@mail.com\n";

        assertEquals(s2,Part1.convert1(s1));
    }
    @Test
    public void textConvert4() {
        String s1 = "Login;Name;Email \n" +
                "ivanov;Ivan Ivanov;ivanov@mail.com\n" +
                "петров;Петр Петров;petrov@google.com\n" +
                "obama;Barack Obama;obama@google.com\n" +
                "bush;Джордж Буш;bush@mail.com";
        String s2 = "Login;Name;Email \n" +
                "ivanov;Ivan Ivanov;ivanov@mail.com;1488\n" +
                "петров;Петр Петров;petrov@google.com;1488\n" +
                "obama;Barack Obama;obama@google.com;1488\n" +
                "bush;Джордж Буш;bush@mail.com;1488";
        assertEquals(s2,Part1.convert4(s1));
    }
}