package de.doubleslash.dojo.romannumbers;

public class RomanDigit {

    private String digit;

    private Integer arabicValue;

    RomanDigit(String digit, Integer value) {
        this.digit = digit;
        this.arabicValue = value;
    }

    public String getDigit() {
        return digit;
    }

    public Integer arabicValue() {
        return arabicValue;
    }

}
