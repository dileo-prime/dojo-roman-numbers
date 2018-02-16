package de.doubleslash.dojo.romannumbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RomanToArabicNumberConverterTest {

    private final RomanToArabicNumberConverter testee = new RomanToArabicNumberConverter();

    @ParameterizedTest
    @MethodSource("invalidRomanNumbersProvider")
    void invalidRomanNumberThrowsIllegalArgumentException(String invalidRomanNumber) {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> testee.convertToArabic(invalidRomanNumber));
        assertEquals(ex.getMessage(), "Invalid Roman Number: " + invalidRomanNumber);
    }

    private static Stream<String> invalidRomanNumbersProvider() {
        return Stream.of("XXXX", "IIII", "VVVV", "CCCC", "LLLL", "MMMM", "IL", "MMMLXIIIA", "ABC", "IM", "IC");
    }

    @ParameterizedTest(name = "result of convertToArabic({1}) is {0}")
    @CsvFileSource(resources = "/allArabicToRomanNumbers.csv")
    void convertToRomanReturnsExpectedResult(int expected, String romanNumber) {
        assertEquals(expected, testee.convertToArabic(romanNumber));
    }

}
