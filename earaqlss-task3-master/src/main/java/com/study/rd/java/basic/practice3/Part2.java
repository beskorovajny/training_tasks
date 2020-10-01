package com..rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author beskorovajny
 */
public class Part2 {


    public static void main(String[] args) {
        String text2 = Util.getInput("part2.txt");
        System.out.println(text2);
        System.out.println();
        System.out.println(convert(text2));

}

    public static String convert(String input) {
        Matcher matcher = Pattern.compile("(?<=^|\\s|\\-|\\'|)[a-zA-Z\\u0410-\\u044F]*")
                .matcher(input);
        SetP2 splitedSet = new SetP2();
        MinMax minMax = new MinMax(matcher).addValuesToArray(splitedSet);
        int min = minMax.getMin();
        int max = minMax.getMax();
        return getResultAsString(splitedSet,min,max);
    }

    private static String getResultAsString(SetP2 setP2, int min, int max) {
        StringBuilder sb = new StringBuilder();
        sb.append("Min: ");
        for (String s : setP2) {
            if (s.length() == min) {
                sb.append(s).append(", ");
            }
        }
        sb.replace(sb.length() - 2, sb.length(), System.lineSeparator())
                .append("Max: ");
        for (String s : setP2) {
            if (s.length() == max) {
                sb.append(s).append(", ");
            }
        }
        return sb.toString().replaceFirst(System.lineSeparator() + "\\[a-z]|\\,\\s*$", "");
    }
    private static class MinMax {
        private final Matcher matcher;
        private int min;
        private int max;

        MinMax(Matcher matcher) {
            this.matcher = matcher;
        }

        int getMin() {
            return min;
        }

        int getMax() {
            return max;
        }

        MinMax addValuesToArray(SetP2 splited) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            while (matcher.find()) {
                String s = matcher.group();
                min = (min > s.length() && s.length() != 0) ? s.length() : min;
                max = (max < s.length()) ? s.length() : max;
                splited.insert(matcher.group());
            }
            return this;
        }
    }
    private static class SetP2 implements Iterable<String> {
        String[] dataStore;
        int lastIndex = -1;

        public SetP2(int extremelyLargeInt) {
            dataStore = new String[extremelyLargeInt];
        }

        public SetP2() {
            dataStore = new String[10];
        }

        public void insert(String item) {
            if (lastIndex <= dataStore.length / 2) {
                for (int i = 0; i <= lastIndex; i++) {
                    if (dataStore[i].equals(item)) {
                        return;
                    }
                }
                lastIndex++;
                dataStore[lastIndex] = item;
            } else {
                String[] tempDataStore = new String[dataStore.length * 2];
                    System.arraycopy(dataStore,0,tempDataStore,0,dataStore.length);

                dataStore = tempDataStore;
                insert(item);
            }
        }

        public int size() {
            return lastIndex + 1;
        }


        @Override
        public java.util.Iterator<String> iterator() {
            return new SetIteratorImpl();
        }
        private class SetIteratorImpl implements java.util.Iterator<String>{
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < lastIndex;
            }

            @Override
            public String next() {
               if (this.hasNext()) {
                   return dataStore[currentIndex++];
               } else {
                 throw new java.util.NoSuchElementException();
               }
            }
        }
    }
}
