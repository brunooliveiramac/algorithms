public class RomanNumerals {

    public static String convert(int value) {
        String roman = "";

        for (Numerals numerals : Numerals.values()){
            while (value >= numerals.arabic){
                roman += numerals.roman;
                value -= numerals.arabic;
            }
        }
        return roman;
    }

    public enum Numerals{
        TEN(10, "IV"),
        NINE(9, "IX"),
        FIVE(5, "V"),
        FOUR(4, "IV"),
        ONE(1, "I");

        private final int arabic;
        private final String roman;

        Numerals(int arabic, String roman1) {
            this.arabic = arabic;
            this.roman = roman1;
        }
    }
}
