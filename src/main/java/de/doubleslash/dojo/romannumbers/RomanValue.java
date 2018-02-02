package de.doubleslash.dojo.romannumbers;

public class RomanValue {

    private String romanDigit;

    private Integer value;

    RomanValue(String romanDigit, Integer value) {
        this.romanDigit = romanDigit;
        this.value = value;
    }

    public String getRomanDigit() {
        return romanDigit;
    }

    public Integer getValue() {
        return value;
    }

}
