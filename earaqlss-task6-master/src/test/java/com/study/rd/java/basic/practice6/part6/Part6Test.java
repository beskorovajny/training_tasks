package com..rd.java.basic.practice6.part6;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class Part6Test {
    @Test
    public void shouldReturnTrueIfArgumentsIsCorrect() {
        Part6 part6 = new Part6();
        assertTrue(part6.console("--input","part6.txt","--task","duplicates"));
        assertTrue(part6.console("--input","part6.txt","-t","length"));
        assertTrue(part6.console("-i","part6.txt","--task","frequency"));
    }
    @Test
    public void shouldReturnFalseIfArgumentsIsIncorrect() {
        Part6 part6 = new Part6();
        assertFalse(part6.console("--inpu","part6.txt","--task","duplicates"));
        assertFalse(part6.console("--i","part6.txt","--task","length"));
        assertFalse(part6.console("--input","part6.txt","--t","frequency"));
    }



}
