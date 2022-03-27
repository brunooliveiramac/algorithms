public class PalindromeCheck {

    public static boolean isPalindrome(String str) {
        if ( str.length() == 1){
            return true;
        }
        char[] chars = str.toCharArray();
        StringBuilder newString = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            newString.append(chars[i]);
        }
        return newString.toString().intern() == str.intern();
    }

    public static void main(String[] args) {
        boolean abba = isPalindrome("abcdcba");
        System.out.println(abba);
    }

}
