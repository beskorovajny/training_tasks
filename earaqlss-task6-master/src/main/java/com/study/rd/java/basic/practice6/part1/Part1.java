package com..rd.java.basic.practice6.part1;

import java.io.*;
import java.util.*;

/**
 * @author beskorovajny
 */

public class Part1 {
	private Part1() {
	}

	public static void main(String[] args) {
			WordContainer.main(new String[]{});
	}

	public static void actionMaker(String tmpInput,PrintStream printStream) {
		    String [] tmpArray;
			tmpArray = tmpInput.split("\\s+");
			List<Word> list = WordContainer.wordCounter(tmpArray);

			for (Word word : list) {
				printStream.println(word.getContent() + " : " + word.getFrequency());
			}
	}

}
