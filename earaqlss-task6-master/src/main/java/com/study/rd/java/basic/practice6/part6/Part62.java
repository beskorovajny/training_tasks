package com..rd.java.basic.practice6.part6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * @author beskorovajny
 */
public class Part62 {
    private Part62() {}
    static void getLength(String[] inputFromFile) {
        class CountPlace {
            private final int length;
            private final int place;

            public int getLength() {
                return length;
            }

            public CountPlace(int length, int place) {
                this.length = length;
                this.place = place;
            }
        }
        final HashMap<String, CountPlace> wordCounts = new HashMap<>();
        for (int place = 0; place < inputFromFile.length; place++) {
            String tmpString = inputFromFile[place];
            int finalPlace = place;
            wordCounts.computeIfAbsent(tmpString,
                    v -> new CountPlace(tmpString.length(), finalPlace));
        }
        TreeMap<String, CountPlace> sortedWords = new TreeMap<>((a, b) -> {
            CountPlace countWithPlaceA = wordCounts.get(a);
            CountPlace countWithPlaceB = wordCounts.get(b);

            int length = countWithPlaceB.length - countWithPlaceA.length;
            if (length == 0) {
                return countWithPlaceA.place - countWithPlaceB.place;
            } else {
                return length;
            }
        });
        sortedWords.putAll(wordCounts);


        int i = 0;
        for (Iterator<String> iterator = sortedWords.keySet().iterator(); iterator.hasNext(); ) {
            String s = iterator.next();
            if (i == 3) {
                break;
            }
            i++;
            System.out.println(s + " ==> " + sortedWords.get(s).getLength());
        }
    }
}
