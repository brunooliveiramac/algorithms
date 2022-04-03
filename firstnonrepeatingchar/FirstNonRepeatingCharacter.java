public class FirstNonRepeatingCharacter {

    public static int firstNonRepeatingCharacter(String string) {

        char[] chars = string.toCharArray();
        int count = 0;
        boolean aux;
        while (chars.length > count) {
            aux = false;
            for (int i = 0; i < chars.length; i++) {
                char current = chars[count];
                char comparable = chars[i];
                if (current == comparable && i != count) {
                    aux = true;
                }
            }
            if (aux == false){
                return count;
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharacter("abcdcaf"));
    }

}
