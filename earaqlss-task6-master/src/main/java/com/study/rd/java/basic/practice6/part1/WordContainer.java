package com..rd.java.basic.practice6.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.stream.Collectors.*;

/**
 * @author beskorovajny
 */
public class WordContainer {
    private static final Logger LOGGER = Logger.getLogger(WordContainer.class.getName());


    static List<Word> wordCounter(String[] arr) {
        Map<String, Integer> collect
                = Arrays.stream(arr)
                .collect(groupingBy(Function.identity(),
                        collectingAndThen(counting(), Long::intValue)));


        List<Word> collectedWordList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : collect.entrySet()) {
            collectedWordList.add(new Word(entry.getKey(), entry.getValue()));
        }
        collectedWordList.sort(new Word.CompareByFrequency());


        return collectedWordList;
    }

    public static void main(String[] args) {
        String tmpInput = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(System.in));

            StringBuilder stringBuilder = new StringBuilder();

            String[] tmpArray;
            boolean check = true;
            while (check) {
                tmpInput = bufferedReader.readLine();
                tmpArray = tmpInput.split("\\s+");
                for (String str : tmpArray) {
                    if ("stop".equalsIgnoreCase(str)) {
                        check = false;
                        break;
                    } else {
                        stringBuilder.append(str).append(" ");
                    }
                }
            }
            tmpInput = stringBuilder.toString().trim();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Exception : ", e);
        }
        assert tmpInput != null;
        Part1.actionMaker(tmpInput, System.out);
    }
}
