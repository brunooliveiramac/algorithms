import java.util.*;

public class GroupAnagrams {


    public static Collection<List> groupAnagrams(String[] strs) {

        HashMap<String, List> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            int[] count = new int[26];

            char[] chars = strs[i].toCharArray();

            for (int j = 0; j < chars.length; j++) {

                int ascii = (int) chars[j];

                char character = 'a';

                int a = (int) character;

                count[ascii - a] += 1;
            }

            String key = new String(Arrays.toString(count));

            if (map.get(key) == null) {
                List list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(key, list);
            } else {
                map.get(key).add(strs[i]);
            }
        }

        return map.values();

    }

    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(arr));
    }
}
