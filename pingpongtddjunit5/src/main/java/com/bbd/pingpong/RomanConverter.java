package com.bbd.pingpong;

import com.sun.javaws.exceptions.InvalidArgumentException;

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
        if (inputString == null)
            throw new NullPointerException("Reference String can't be null");
        inputString = inputString.trim();
        if (inputString.length() == 0 || inputString.isEmpty())
            throw new IllegalArgumentException("Reference String Can't be empty");
        String newString = inputString.toUpperCase();

        for (char c : newString.toCharArray()) {
            if (reference.get(c) == null)
                throw new IllegalArgumentException("Invalid characters in input");
        }

        if (!pattern.asPredicate().test(newString))
            throw new IllegalArgumentException("Invalid Character Order");

        int total = 0;
        int lastValue = 0;
        char[] sArray = newString.toCharArray();

        for (int i = newString.length() - 1; i >= 0; i--) {
            int newValue = reference.get(sArray[i]);

            if (newValue < lastValue)
                total -= newValue;
            else {
                total += newValue;
                lastValue = newValue;
            }
        }
        return total;
    }
}