package com..rd.java.basic.practice6.part6;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author beskorovajny
 */
public class Part61{
    private Part61() {}

    static void getFrequency(String[] inputFromFile) {
        class CountWithPlace {
            private int count = 1;
            private final int place;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public CountWithPlace(int place) {
                this.place = place;
            }
        }
        final HashMap<String, CountWithPlace> wordCounts = new HashMap<>();
        for (int place = 0; place < inputFromFile.length; place++) {
            String tmpString = inputFromFile[place];
            CountWithPlace countWithPlace = wordCounts.get(tmpString);
            if (countWithPlace == null) {
                wordCounts.put(tmpString, new CountWithPlace(place));
            } else {
                countWithPlace.setCount(countWithPlace.getCount()+1);
            }
        }
        TreeMap<String, CountWithPlace> sortedWords = new TreeMap<>((a, b) -> {
            CountWithPlace countWithPlaceA = wordCounts.get(a);
            CountWithPlace countWithPlaceB = wordCounts.get(b);
            int count = countWithPlaceB.count - countWithPlaceA.count;
            if (count == 0) {
                return countWithPlaceA.place - countWithPlaceB.place;
            } else {
                return count;
            }
        });
        sortedWords.putAll(wordCounts);

        TreeSet<String> firstStrings = new TreeSet<>((o1, o2) -> o2.compareTo(o1));
        int i = 0;
        for (String s : sortedWords.keySet()) {
            if (i == 3) {
                break;
            }
            i++;
            firstStrings.add(s);
        }
        for (String s : firstStrings) {
            System.out.println(s + " ==> " + sortedWords.get(s).getCount());
        }
    }
    
}
