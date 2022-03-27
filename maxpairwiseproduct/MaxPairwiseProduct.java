import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers, int n) {
        Arrays.sort(numbers);
        long num1, num2;

        // Calculate product of two smallest numbers
        long sum1 = numbers[0] * numbers[1];

        // Calculate product of two largest numbers
        long sum2 = numbers[n - 1] * numbers[n - 2];

        // print the pairs whose product is greater
        if (sum1 > sum2) {
            num1 = numbers[0];
            num2 = numbers[1];

        }
        else {
            num1 = numbers[n - 2];
            num2 = numbers[n - 1];
        }
        return num1 * num2;

    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers, n));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}