package com..rd.java.basic.practice6.part1;

import java.util.Comparator;

/**
 * @author beskorovajny
 */
public class Word{

    private final String content;

    private final int frequency;

    Word(String content, int frequency) {
        this.content = content;
        this.frequency = frequency;
    }

    public String getContent() { return content; }

    public int getFrequency() { return frequency; }



    @Override
    public String toString() {
        return "Word{" +
                "content='" + content + '\'' +
                ", frequency=" + frequency +
                '}';
    }

    static class CompareByWord implements Comparator<Word> {
        @Override
        public int compare(Word o1, Word o2) {
            return o1.getContent().compareTo(o2.getContent());
        }
    }
    static class CompareByFrequency implements Comparator<Word> {
        @Override
        public int compare(Word o1, Word o2) {
            int compare = -o1.getFrequency() + o2.getFrequency();
            if (compare == 0) {
                return new CompareByWord().compare(o1, o2);
            }
            return compare;
        }
    }
}
