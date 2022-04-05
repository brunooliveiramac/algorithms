import java.util.Arrays;
import java.util.stream.Stream;

public class RunLengthEncoding {

    public static void main(String[] args) {
        System.out.println(runLengthEncoding("aaaabbcccc"));
    }


    public static String runLengthEncoding(String string) {
        char[] chars = string.toCharArray();

        Arrays.sort(chars);

        int count = 1;
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars.length > i + 1 && chars[i] == chars[i + 1] && count < 9) {
                count++;
            } else {
                result += count + "" +  chars[i - 1];
                count = 1;
            }
        }


        return result;
    }

}
