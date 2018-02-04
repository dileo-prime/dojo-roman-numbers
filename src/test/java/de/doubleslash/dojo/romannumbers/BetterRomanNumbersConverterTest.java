package de.doubleslash.dojo.romannumbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BetterRomanNumbersConverterTest {

    private final BetterRomanNumbersConverter testee = new BetterRomanNumbersConverter();

    @ParameterizedTest(name = "result of convertToToman({0}) is {1}")
    @CsvFileSource(resources = "/arabicToRomanNumbers.csv")
    void convertToRomanReturnsExpectedResult(int arabicNumber, String expected) {
        assertEquals(expected, testee.convertToRoman(arabicNumber));
    }

    @Test
    void tooSmallArabicNumberThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> testee.convertToRoman(0));
    }

    @Test()
    void tooHighArabicNumberThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> testee.convertToRoman(4000));
    }

}
