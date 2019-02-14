package hello;

import java.util.*;
import java.util.regex.Pattern;

public class RomanConverter {
    private static Map<Character, Integer> reference = new HashMap<>();
    private static Map<Integer, Character> arabicReference = new HashMap<>();
    private static Pattern pattern = Pattern.compile("^M*(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

    static {
        reference.put('I', 1);
        reference.put('V', 5);
        reference.put('X', 10);
        reference.put('L', 50);
        reference.put('C', 100);
        reference.put('D', 500);
        reference.put('M', 1000);

        arabicReference.put(1, 'I');
        arabicReference.put(5, 'V');
        arabicReference.put(10, 'X');
        arabicReference.put(50, 'L');
        arabicReference.put(100, 'C');
        arabicReference.put(500, 'D');
        arabicReference.put(1000, 'M');
    }

    public static int convert(String inputString) {
        if (inputString == null)
            throw new NullPointerException("Reference String can't be null");
        inputString = inputString.trim();
        if ((inputString.length() == 0) || inputString.isEmpty())
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

    public static String GetReference(int num) {
        return arabicReference.get(num).toString();
    }

    public static String convertBack(int number, boolean v2) {
        String _refed = "";

        if (number >= 1000) {
            int times = (number / 1000);
            number -= 1000 * times;
            if (times == 9) {
                _refed += GetReference(900);
                times -= 9;
            }
            for (int i = 0; i < times; i++) {
                _refed += GetReference(1000);
            }
        }

        if (number >= 100) {
            int times = (int) (number / 100);
            number -= 100 * times;

            if (times == 9) {
                if (v2) {
                    _refed += GetReference(10);
                    _refed += GetReference(100);
                } else {
                    _refed += GetReference(900);
                }
                times -= 9;
            }

            if (times >= 5) {
                _refed += GetReference(500);
                times -= 5;
            }

            if (times == 4) {
                if (v2) {
                    _refed += GetReference(100);
                    _refed += GetReference(500);
                } else {
                    _refed += GetReference(400);
                }
                times -= 4;
            }

            for (int i = 0; i < times; i++) {
                _refed += GetReference(100);
            }

        }

        if (number > 10) {
            int times = (int) (number / 10);
            number -= 10 * times;

            if (times == 9) {
                if (v2) {
                    _refed += GetReference(10);
                    _refed += GetReference(100);
                } else {
                    _refed += GetReference(90);
                }
                times -= 9;
            }

            if (times >= 5) {
                _refed += GetReference(50);
                times -= 5;
            }

            if (times == 4) {
                if (v2) {
                    _refed += GetReference(10);
                    _refed += GetReference(50);
                } else {
                    _refed += GetReference(40);
                }
                times -= 4;
            }


            for (int i = 0; i < times; i++) {
                _refed += GetReference(10);
            }
        }

        if (number > 0) {
            int times = number;

            if (times == 9) {
                if (v2) {
                    _refed += GetReference(1);
                    _refed += GetReference(10);
                } else {
                    _refed += GetReference(9);
                }
                times -= 9;
            }

            if (times >= 5) {
                _refed += GetReference(5);
                times -= 5;
            }

            if (times == 4) {
                if (v2) {
                    _refed += GetReference(1);
                    _refed += GetReference(5);
                } else {
                    _refed += GetReference(4);
                }
                times -= 4;
            }

            for (int i = 0; i < times; i++) {
                _refed += GetReference(1);
            }
        }

        return (_refed);
        // throw new NotImplementedException("OI! use me you fat fuck");
    }
}