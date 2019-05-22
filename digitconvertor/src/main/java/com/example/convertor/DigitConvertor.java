package com.example.convertor;

/**
 * Created by cloud on 2019/5/21.
 */
public class DigitConvertor {
    //0 - 19 digits
    static String[] units = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    //tens digits
    static String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    /**
     * converting the digits from 0 to 99 into letters
     * @param input digits from 0 to 99
     * @return
     */
    public static String convert(int input) {
        String result = "invalid input";
        if (input < 0 || input > 99) {
            return result;
        }
        String tensFormat = "%s-%s";
        int tensDigit = input / 10;
        int unitDigit = input % 10;
        if (input < 20) {
            result = units[input];
        } else if (unitDigit == 0) {
            result = tens[tensDigit];
        } else {
            result = String.format(tensFormat, tens[tensDigit], units[unitDigit]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(DigitConvertor.convert(0));
        System.out.println(DigitConvertor.convert(9));
        System.out.println(DigitConvertor.convert(11));
        System.out.println(DigitConvertor.convert(20));
        System.out.println(DigitConvertor.convert(90));
        System.out.println(DigitConvertor.convert(99));
    }
}
