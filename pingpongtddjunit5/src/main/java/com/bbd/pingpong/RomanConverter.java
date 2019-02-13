package com.bbd.pingpong;

import java.util.*;
import java.util.regex.Pattern;

public class RomanConverter {
    static Map<Character, Integer> reference = new HashMap<>();
    static Pattern pattern = Pattern.compile("^M*(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
    static {
        reference.put('I', 1);
        reference.put('V', 5);
        reference.put('X', 10);
        reference.put('L', 50);
        reference.put('C', 100);
        reference.put('D', 500);
        reference.put('M', 1000);
    }

    public static int convert(String inputString) {
        //TODO: FIX THIS SHIT!


        if (inputString == null)
            throw new NullPointerException("Reference String can't be null");
        if (inputString.length() == 0) return 0;
        String newString = inputString.toUpperCase();

        for (char c : newString.toCharArray()) {
            if (reference.get(c) == null)
                throw new IllegalArgumentException("Invalid characters in input");
        }

        if (!pattern.asPredicate().test(newString))
            throw new IllegalArgumentException("Invalid Character Order");

        int total = 0;
        int last_Value = 0;
        char[] s_Array = newString.toCharArray();

        for (int i = newString.length() - 1; i >= 0; i--) {
            int new_Value = reference.get(s_Array[i]);

            if (new_Value < last_Value)
                total -= new_Value;
            else {

                total += new_Value;
                last_Value = new_Value;
            }
        }
        return total;
    }
}