package de.doubleslash.dojo.romannumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BetterRomanNumbersConverterInvalidArgumentTest {

    private final BetterRomanNumbersConverter testee = new BetterRomanNumbersConverter();

    @Test()
    void invalidMaxTest() {
        assertThrows(IllegalArgumentException.class, () -> testee.convertToRoman(4000));
    }

}
