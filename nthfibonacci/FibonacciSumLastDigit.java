import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        long[] fibArr = new long[(int) (n + 1)];
        if (n == 0){
            return 0;
        }
        fibArr[0] = 0;
        if (n == 1){
            return 1;
        }
        fibArr[1] = 1;
        if (n == 2){
            return 1;
        }

        for (int i = 2; i < n + 1; i++){
            fibArr[i] = Math.abs((fibArr[i -1] + fibArr[i -2]) % 10);
        }

        return (int) fibArr[fibArr.length - 1];

    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

