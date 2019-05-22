package com.example.convertor;

/**
 * Created by cloud on 2019/5/21.
 */
public class MobileConvertor {
    //Letter mapping of a Phone Number
    static String[] btns = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * print all possible letter combinations that the numbers could represent
     * e.g.
     * Input: arr[] = {2, 3}
     * Output: ad ae af bd be bf cd ce cf
     *
     * Input: arr[] = {9}
     * Output: w x y z
     *
     * @param input digit array
     * @return
     */
    public static String convert(String[] input) {
        StringBuilder output = new StringBuilder();
        if (null != input && input.length > 0) {
            String[] letters = new String[input.length];
            for (int i = 0; i < input.length; i++) {
                letters[i] = btns[Integer.valueOf(input[i])];
            }
            int index = 0;
            String letter = "";
            group(letters, index, letter, output);
        }
        return output.toString();
    }

    /**
     * recursion to get all possible letter combinations
     * @param letters   letter mappings
     * @param index     index of the combined letters
     * @param letter    possible letter combination
     * @param output    all possible letter combinations
     */
    private static void group(String[] letters, int index, String letter, StringBuilder output) {
        char[] chars = letters[index].toCharArray();
        //skip 0 and 1 as there were no letter mapped to them
        if (chars.length == 0) {
            group(letters, index + 1, letter, output);
        }
        //get all possible letter combinations
        for (int i = 0; i < chars.length; i++) {
            if (index == letters.length - 1) {
                output.append(letter + chars[i] + " ");
            } else {
                group(letters, index + 1, letter + chars[i], output);
            }
        }
    }

    public static void main(String[] args) {
        String[] input = {"0", "1", "2", "3", "4"};
        String output = MobileConvertor.convert(input);
        System.out.println(output);
    }
}
