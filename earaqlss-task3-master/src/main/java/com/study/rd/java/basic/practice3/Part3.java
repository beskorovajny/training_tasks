package com..rd.java.basic.practice3;


public class Part3 {

    public static void main(String[] args) {
        String text3 = Util.getInput("part3.txt");
        System.out.println(text3);
        System.out.println();
        System.out.println(convert(text3));
    }

    public static String convert(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder current;
        for(String line:input.split(System.lineSeparator())){
            for(String word:line.split(" ")){
                current=new StringBuilder();
                if(word.length()>=3){
                    if(Character.isLowerCase(word.toCharArray()[0])){
                        current.append(Character.toUpperCase(word.toCharArray()[0]));
                    }
                    if(Character.isUpperCase(word.toCharArray()[0])){
                        current.append(Character.toLowerCase(word.toCharArray()[0]));
                    }
                    stringBuilder.append(current.toString()).append(word.substring(1)).append(" ");
                    continue;
                }
                stringBuilder.append(word).append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.append(System.lineSeparator());
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString().trim();
    }

}
