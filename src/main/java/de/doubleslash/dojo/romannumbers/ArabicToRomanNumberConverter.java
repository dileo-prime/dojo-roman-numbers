package de.doubleslash.dojo.romannumbers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class ArabicToRomanNumberConverter {

    private static final int MIN_VALUE = 1;

    private static final int MAX_VALUE = 3999;

    private static final List<RomanDigit> ROMAN_DIGITS = Arrays.asList(
            new RomanDigit("M", 1000),
            new RomanDigit("CM", 900),
            new RomanDigit("D",  500),
            new RomanDigit("CD", 400),
            new RomanDigit("C",  100),
            new RomanDigit("XC",  90),
            new RomanDigit("L",   50),
            new RomanDigit("XL",  40),
            new RomanDigit("X",   10),
            new RomanDigit("IX",   9),
            new RomanDigit("V",    5),
            new RomanDigit("IV",   4),
            new RomanDigit("I",    1)
    );

    public String convertToRoman(final int arabicNumber) {
        validate(arabicNumber);

        List<RomanDigit> romanDigits = romanValuesFromArabicNumber(arabicNumber);

        return romanDigits.stream()
                .map(RomanDigit::getRomanDigit)
                .collect(joining());
    }

    private void validate(int arabicNumber) {
        if (arabicNumber < MIN_VALUE || arabicNumber > MAX_VALUE) {
            throw new IllegalArgumentException("Value too high: " + arabicNumber);
        }
    }

    private List<RomanDigit> romanValuesFromArabicNumber(int arabicNumber) {
        List<RomanDigit> resultList = new LinkedList<>();

        int number = arabicNumber;
        while(number > 0) {
            for (RomanDigit rv : ROMAN_DIGITS) {
                int val = rv.arabicValue();
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
