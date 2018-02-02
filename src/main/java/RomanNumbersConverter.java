public class RomanNumbersConverter {
    public static final int MAX_VALUE = 3999;

    public String convertToRoman(final int arabicNumber) {
        if (MAX_VALUE < arabicNumber) {
            throw new IllegalArgumentException("Nananananaaa");
        } else if (arabicNumber == 0) {
            return "";
        }

        final StringBuilder sb = new StringBuilder();

        if (arabicNumber <= 3) {
            sb.append("I");
            sb.append(convertToRoman(arabicNumber - 1));
        } else if (arabicNumber == 4) {
            sb.append("IV");
        } else if (arabicNumber <= 8) {
            sb.append("V");
            sb.append(convertToRoman(arabicNumber - 5));
        } else if (arabicNumber == 9) {
            sb.append("IX");
        } else if (arabicNumber <= 39) {
            sb.append("X");
            sb.append(convertToRoman(arabicNumber - 10));
        } else if (arabicNumber <= 49) {
            sb.append("XL");
            sb.append(convertToRoman(arabicNumber - 40));
        } else if (arabicNumber <= 89) {
            sb.append("L");
            sb.append(convertToRoman(arabicNumber - 50));
        } else if (arabicNumber <= 99) {
            sb.append("XC");
            sb.append(convertToRoman(arabicNumber - 90));
        } else if (arabicNumber <= 399) {
            sb.append("C");
            sb.append(convertToRoman(arabicNumber - 100));
        } else if (arabicNumber <= 499) {
            sb.append("CD");
            sb.append(convertToRoman(arabicNumber - 400));
        } else if (arabicNumber <= 899) {
            sb.append("D");
            sb.append(convertToRoman(arabicNumber - 500));
        }else  if (arabicNumber <= 999) {
            sb.append("CM");
            sb.append(convertToRoman(arabicNumber - 900));
        }else {
            sb.append("M");
            sb.append(convertToRoman(arabicNumber - 1000));
        }

        return sb.toString();
    }
}
