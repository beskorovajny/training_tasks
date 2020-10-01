package com..rd.java.basic.practice6;

import com..rd.java.basic.practice6.part1.Part1;
import com..rd.java.basic.practice6.part2.Part2;
import com..rd.java.basic.practice6.part3.Part3;
import com..rd.java.basic.practice6.part4.Part4;
import com..rd.java.basic.practice6.part5.Part5;
import com..rd.java.basic.practice6.part6.Part6;

/**
 * @author beskorovayny
 */
public class Demo {


	public static void main(String[] args) {
		Part1.main(new String[]{});
		Part2.main(new String[]{});
		Part3.main(new String[]{});
		Part4.main(new String[]{});
		Part5.main(new String[]{});

		String[] optionsArray = {"frequency", "duplicates", "length"};
		for (String option : optionsArray) {
			Part6.main(new String[]{"--input", "part6.txt", "-t", option});
		}



	}

}
