package de.doubleslash.dojo.romannumbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BetterRomanNumbersConverterTest {

    private final BetterRomanNumbersConverter testee = new BetterRomanNumbersConverter();

    @ParameterizedTest(name = "convertToToman({0}) should be {1}")
    @CsvFileSource(resources = "/arabicToRomanNumbers.csv")
    void paramTest(int arabicNumber, String expected) {
        assertEquals(expected, testee.convertToRoman(arabicNumber));
    }

    @Test
    void invalidMinTest() {
        assertThrows(IllegalArgumentException.class, () -> testee.convertToRoman(0));
    }

    @Test()
    void invalidMaxTest() {
        assertThrows(IllegalArgumentException.class, () -> testee.convertToRoman(4000));
    }
}
