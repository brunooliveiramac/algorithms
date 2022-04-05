import java.util.Arrays;

public class RunLengthEncoding {

    public static void main(String[] args) {
        System.out.println(runLengthEncoding("122333"));
    }


    public static String runLengthEncoding(String string) {
        char[] chars = string.toCharArray();

        int count = 1;
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars.length > i + 1 && chars[i] == chars[i + 1] && count < 9) {
                count++;
            } else {
                result += count + "" +  chars[i];
                count = 1;
            }
        }


        return result;
    }

}
