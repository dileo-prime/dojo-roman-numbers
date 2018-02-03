package de.doubleslash.dojo.romannumbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BetterRomanNumbersConverterTest {

    private final BetterRomanNumbersConverter testee = new BetterRomanNumbersConverter();

    @ParameterizedTest(name = "convertToToman({0}) should be {1}")
    @CsvFileSource(resources = "/arabicToRomanNumbers.csv")
    void paramTest(int arabicNumber, String expected) {
        assertEquals(expected, testee.convertToRoman(arabicNumber));
    }

}
