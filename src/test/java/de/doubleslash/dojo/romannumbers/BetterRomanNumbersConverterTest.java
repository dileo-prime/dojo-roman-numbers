package de.doubleslash.dojo.romannumbers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BetterRomanNumbersConverterTest {

    @Parameterized.Parameters(name = "{index}: convert({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 1, "I" }, { 2, "II" }, { 3, "III"}, { 4, "IV"},
                { 5, "V" }, { 6, "VI" }, { 7, "VII" }, { 8, "VIII" },
                { 9, "IX"}, { 10, "X" }, { 11, "XI" }, { 12, "XII" },
                { 13, "XIII" }, { 14, "XIV" }, {38, "XXXVIII"},
                { 39, "XXXIX"}, {40, "XL"}, {41, "XLI"}, {42, "XLII"},
                {43, "XLIII"}, {44, "XLIV"}, {45, "XLV"}, {49, "XLIX"},
                {50, "L"},{51, "LI"},{89, "LXXXIX"},{90, "XC"},{99, "XCIX"},
                {100, "C"}, {101, "CI"}, {399, "CCCXCIX"} , {400, "CD"}, {401, "CDI"},
                {499, "CDXCIX"}, {500, "D"}, {501, "DI"},{599, "DXCIX"},{600, "DC"},
                {899, "DCCCXCIX"}, {900, "CM"}, {901, "CMI"}, {1000, "M"},{2018, "MMXVIII"},
                {2999, "MMCMXCIX"},{3000, "MMM"}, {3999, "MMMCMXCIX"}
        });
    }

    private int input;
    private String expected;

    public BetterRomanNumbersConverterTest(int input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    private final BetterRomanNumbersConverter testee = new BetterRomanNumbersConverter();

    @Test
    public void paramTest() {
        assertEquals(expected, testee.convertToRoman(input));
    }

}
