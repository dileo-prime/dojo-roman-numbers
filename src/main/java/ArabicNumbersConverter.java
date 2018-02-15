import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ArabicNumbersConverter {

    final HashMap<String, Integer> arabicRoman = new LinkedHashMap<>();

    {
        arabicRoman.put("M", 1000);
        arabicRoman.put("CM", 900);
        arabicRoman.put("D", 500);
        arabicRoman.put("CD", 400);
        arabicRoman.put("C", 100);
        arabicRoman.put("XC", 90);
        arabicRoman.put("L", 50);
        arabicRoman.put("XL", 40);
        arabicRoman.put("X", 10);
        arabicRoman.put("IX", 9);
        arabicRoman.put("V", 5);
        arabicRoman.put("IV", 4);
        arabicRoman.put("I", 1);
    }

    public int convertToArabic(final String romanNumber) {
        String romanNumberToParse = romanNumber;

        int result = 0;
        // System.out.println(arabicRoman);

        while (romanNumberToParse.length() > 0) {
            for (final Map.Entry<String, Integer> entry : arabicRoman.entrySet()) {
                if (romanNumberToParse.startsWith(entry.getKey())) {
                    result += entry.getValue();
                    romanNumberToParse = romanNumberToParse.substring(entry.getKey().length());
                    break;
                }
            }
        }


        return result;
    }

}
