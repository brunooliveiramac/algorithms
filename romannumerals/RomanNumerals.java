public class RomanNumerals {

    public static String convert(int value) {
        String roman = "";

        if (value >= 5){
            roman += "V";
            value -= 5;
        }

        for (int i = 0; i < value ; i++) {
            roman += "I";
        }

        return roman;
    }
}
