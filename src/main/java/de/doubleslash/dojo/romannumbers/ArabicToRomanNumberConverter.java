package de.doubleslash.dojo.romannumbers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class ArabicToRomanNumberConverter {

    private static final int MIN_VALUE = 1;

    private static final int MAX_VALUE = 3999;

    private static final List<RomanValue> ROMAN_VALUES = Arrays.asList(
            new RomanValue("M", 1000),
            new RomanValue("CM", 900),
            new RomanValue("D",  500),
            new RomanValue("CD", 400),
            new RomanValue("C",  100),
            new RomanValue("XC",  90),
            new RomanValue("L",   50),
            new RomanValue("XL",  40),
            new RomanValue("X",   10),
            new RomanValue("IX",   9),
            new RomanValue("V",    5),
            new RomanValue("IV",   4),
            new RomanValue("I",    1)
    );

    public String convertToRoman(final int arabicNumber) {
        validate(arabicNumber);

        List<RomanValue> romanValues = romanValuesFromArabicNumber(arabicNumber);

        return romanValues.stream()
                .map(RomanValue::getRomanDigit)
                .collect(joining());
    }

    private void validate(int arabicNumber) {
        if (arabicNumber < MIN_VALUE || arabicNumber > MAX_VALUE) {
            throw new IllegalArgumentException("Value too high: " + arabicNumber);
        }
    }

    private List<RomanValue> romanValuesFromArabicNumber(int arabicNumber) {
        List<RomanValue> resultList = new LinkedList<>();

        int number = arabicNumber;
        while(number > 0) {
            for (RomanValue rv : ROMAN_VALUES) {
                int val = rv.getValue();
                if (number >= val) {
                    resultList.add(rv);
                    number -= val;
                    // leave for-loop
                    break;
                }
            }
        }
        return resultList;
    }

}
