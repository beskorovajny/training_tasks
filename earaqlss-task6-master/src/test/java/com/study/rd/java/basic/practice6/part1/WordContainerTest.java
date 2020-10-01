package com..rd.java.basic.practice6.part1;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class WordContainerTest {
    @Test
    public void WordConstructorTest() {
        Word word = new Word("content",5);
        assertEquals("content", word.getContent());
        assertEquals(5, word.getFrequency());
    }

    @Test
    public void wordCounterTest() {
        String strTest = "asd 43 asdf asd 43\n" +
                "\n" +
                "434 asdf \n" +
                "\n" +
                "kasdf asdf";
        String[] testArr = strTest.split("\\s+");
        List<Word> list = WordContainer.wordCounter(testArr);

        Word word1 = list.get(0);
        assertEquals("asdf",word1.getContent());
        assertEquals(3, word1.getFrequency());
    }

    @Test
    public void toStringTest() {
        String strTest = "Word{content='content', frequency=5}";
        Word word = new Word("content", 5);
        assertEquals(strTest, word.toString());
    }

}
