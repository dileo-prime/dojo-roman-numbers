package de.doubleslash.dojo.romannumbers;

public class RomanDigit {

    private String romanDigit;

    private Integer value;

    RomanDigit(String romanDigit, Integer value) {
        this.romanDigit = romanDigit;
        this.value = value;
    }

    public String getRomanDigit() {
        return romanDigit;
    }

    public Integer arabicValue() {
        return value;
    }

}
