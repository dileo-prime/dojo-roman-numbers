package de.doubleslash.dojo.romannumbers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class RomanToArabicNumberConverter {

    private static final String ROMAN_NUMBER_REGEX = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
    private static final Pattern ROMAN_NUMBER_PATTERN = Pattern.compile(ROMAN_NUMBER_REGEX);

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
            new RomanDigit("IV",   4),
            new RomanDigit("V",    5),
            new RomanDigit("I",    1)
    );

    public int convertToArabic(final String romanNumber) {
        throwExceptionForInvalid(romanNumber);

        return parseToArabicNumber(romanNumber);
    }

    private void throwExceptionForInvalid(String romanNumber) {
        if (isInvalid(romanNumber)) {
            throw new IllegalArgumentException("Invalid Roman Number: " + romanNumber);
        }
    }

    private boolean isInvalid(String romanNumber) {
        return !ROMAN_NUMBER_PATTERN.matcher(romanNumber).matches();
    }

    private int parseToArabicNumber(final String romanNumber) {
        String stringToParse = romanNumber;

        List<RomanDigit> digits = new LinkedList<>();

        while(stringToParse.length() > 0) {
            for (RomanDigit romanDigit : ROMAN_DIGITS) {
                String digit = romanDigit.getDigit();
                if (stringToParse.startsWith(digit)) {
                    digits.add(romanDigit);
                    stringToParse = stringToParse.substring(digit.length());
                    break;
                }
            }
        }

        return digits.stream()
                .mapToInt(RomanDigit::arabicValue)
                .sum();
    }

}
