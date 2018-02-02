package de.doubleslash.dojo.romannumbers;

import org.junit.Test;

public class BetterRomanNumbersConverterInvalidArgumentTest {

    private final BetterRomanNumbersConverter testee = new BetterRomanNumbersConverter();

    @Test(expected = IllegalArgumentException.class)
    public void invalidMaxTest() {
        testee.convertToRoman(4000);
    }

}
