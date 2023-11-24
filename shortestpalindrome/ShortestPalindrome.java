public class ShortestPalindrome {

    public static int shortestPalindrome(String s) {
        return insertionsNeeded(s, 0, s.length() - 1);
    }

    private static int insertionsNeeded(String s, int left, int right) {
        if (left >= right) {
            return 0;
        }
        if (s.charAt(left) == s.charAt(right)) {
            return insertionsNeeded(s, left + 1, right - 1);
        } else {
            int insertLeft = insertionsNeeded(s, left, right - 1);
            int insertRight = insertionsNeeded(s, left + 1, right);
            return Math.min(insertLeft, insertRight) + 1;
        }
    }
    public static void main(String[] args) {
        int shortestPalindrome = shortestPalindrome("aasdwqxxax");
        System.out.println(shortestPalindrome);// should be 6
    }

}
