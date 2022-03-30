import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CaesarCipherEncryptor {


    public static String caesarCypherEncryptor(String str, int key) {

        key = key % 26;

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char letter = chars[i];
            char newLetter = (char) (letter + key);
            if (newLetter > 'z') {
                newLetter = (char) (((letter + key) % 'z') + 96);
            }
            newChar(chars, i, newLetter);
        }

        return String.valueOf(chars);
    }

    static void newChar(char[] letters, int pos, char newChar) {
        letters[pos] = newChar;
    }

    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor("xyz", 2));
    }


}
