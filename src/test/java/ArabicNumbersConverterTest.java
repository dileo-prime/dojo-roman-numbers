import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ArabicNumbersConverterTest {

    private ArabicNumbersConverter testee;

    @ParameterizedTest(name = "{1}->{0}")
    @CsvFileSource(resources = "/allArabicToRomanNumbers.csv")
    void convertToArabic(final int expectedArabic, final String romanNumber) {
        testee = new ArabicNumbersConverter();

        final int arabic = testee.convertToArabic(romanNumber);

        if (expectedArabic != arabic) {
            System.exit(0);
        }

        assertEquals(expectedArabic, arabic);
    }
}