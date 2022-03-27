import java.util.Arrays;

public class MinimumWaitingTime {

    public int minimumWaitingTime(int[] queries) {
        // Write your code here.
        //0 + 3 + 5 + 6 + 8
        // Sorting
        // 1, 2, 2, 3, 6
        // 0 + 1 + 3 + 5 + 8
        //

        Arrays.sort(queries);
        // 1, 2, 2, 3, 6
        int sum = 0;
        int[] reverse = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            reverse[i] = queries[i];
            if (i == 0) {
                continue;
            }
            for (int j = 0; j < reverse.length; j++) {
                if (j == i) {
                    continue;
                }
                sum += reverse[j];
            }
        }
        return sum;
    }

}

