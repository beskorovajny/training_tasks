package com..rd.java.basic.practice4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author beskorovajny
 */
public class Part4 implements Iterable<String> {
    private static final String SENTENCE = "\\p{Lu}[^.]*\\.";
    static String input = Demo.getInput("part4.txt", "CP1251");

    public static void main(String[] args) {
       Demo.print(getOutput());
    }

    public static String getOutput() {
        Part4 part4 = new Part4();
        StringBuilder sb = new StringBuilder();
        for (String element : part4) {
            sb.append(element).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
    @Override
    public Iterator<String> iterator() {
        return new IteratorImpl();
    }

    private static class IteratorImpl implements Iterator<String> {
        private final Pattern pattern = Pattern.compile(SENTENCE, Pattern.UNICODE_CASE);
        private final Matcher matcher = pattern.matcher(Part4.input);
        private boolean hasNext;

        @Override
        public boolean hasNext() {
            hasNext = matcher.find();
            return hasNext;
        }

        @Override
        public String next() {
            if (!hasNext) {
                throw new NoSuchElementException();
            }
            return matcher.group().replaceAll(System.lineSeparator(), " ");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
