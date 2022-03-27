import java.util.*;

public class GCD {
  private static int gcd_naive(int first, int second) {
    int remain = first % second;
    if (remain == 0){
      return second;
    }
    return gcd_naive(second, remain);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_naive(a, b));
  }
}
