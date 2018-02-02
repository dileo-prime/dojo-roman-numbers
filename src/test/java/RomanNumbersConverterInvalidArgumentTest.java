import org.junit.Test;

public class RomanNumbersConverterInvalidArgumentTest {
    private final RomanNumbersConverter testee = new RomanNumbersConverter();

    @Test(expected = IllegalArgumentException.class)
    public void invalidMaxTest() {
        testee.convertToRoman(4000);
    }

}