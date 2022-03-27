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
                if (j == i){
                    continue;
                }
                sum += reverse[j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MinimumWaitingTime minimumWaitingTime = new MinimumWaitingTime();

        int[] arr = new int[5];
        arr[0] = 3;
        arr[1] = 2;
        arr[2] = 1;
        arr[3] = 2;
        arr[4] = 6;

        System.out.println(minimumWaitingTime.minimumWaitingTime(arr));

    }

}

