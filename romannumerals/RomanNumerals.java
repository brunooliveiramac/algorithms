public class RomanNumerals {

    public static String convert(int value) {
        String roman = "";

        for (int i = 0; i < value ; i++) {
            roman += "I";
        }

        return roman;
    }
}
