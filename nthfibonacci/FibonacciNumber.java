import java.util.Scanner;
import java.util.stream.IntStream;

public class FibonacciNumber {
  private static long calc_fib(int n) {

    long[] fibArr = new long[n];

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

    for (int i = 2; i < n; i++){
      fibArr[i] = fibArr[i -1] + fibArr[i -2];
    }

    return fibArr[fibArr.length -1] + fibArr[fibArr.length -2];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
