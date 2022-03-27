import java.util.Scanner;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        long[] fibArr = new long[n + 1];
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
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

