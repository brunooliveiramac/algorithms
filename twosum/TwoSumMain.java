import java.util.HashMap;
import java.util.Map;

public class TwoSumMain {


    public static void main(String[] args) {
        int[] arr = {4, 5, 6};
        int[] ints = twoSum(arr, 10);
        System.out.println();

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                arr[0] = map.get(difference);
                arr[1] = i;
            }
        }

        return arr;
    }

}
