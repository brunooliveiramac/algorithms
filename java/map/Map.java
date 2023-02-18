import java.util.Arrays;

public class Map {

    public static boolean isTwin(String a, String b) {

        a = a.toLowerCase();
        b = b.toLowerCase();

        if (a.length() == b.length()) {

            char[] charArray1 = a.toCharArray();
            char[] charArray2 = b.toCharArray();

            Arrays.sort(charArray1);
            Arrays.sort(charArray2);

            return Arrays.equals(charArray1, charArray2);

        }
        return false;
    }

    public static void main(String[] args) {

    }
}
