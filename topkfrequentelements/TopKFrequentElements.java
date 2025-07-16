import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3};
        System.out.println(Arrays.toString(topKFrequent(arr, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = freqMap.entrySet()
                .stream()
                .sorted((a, b) -> {
                    int cmp = b.getValue().compareTo(a.getValue());
                    if (cmp == 0) {
                        return Integer.compare(a.getKey(), b.getKey()); // break ties by key ascending
                    }
                    return cmp;
                })
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return result.stream().mapToInt(i -> i).toArray();
    }
}
