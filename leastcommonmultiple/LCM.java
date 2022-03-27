import java.util.*;

public class LCM {
  private static long lcm_naive(int first, int second) {
    long result = (long) first * second;
    return result / gcd(first, second);
  }

  private static long gcd(long first, long second) {
    long remain = first % second;
    if (remain == 0){
      return second;
    }
    return gcd(second, remain);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
  }
}
