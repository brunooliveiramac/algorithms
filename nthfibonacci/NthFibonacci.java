import java.util.HashMap;
import java.util.Map;

class NthFibonacci {
    //0   - F1
    //1   - F2
    //1   - F3
    //2   - F4
    //3   - F5
    //5   - F6
    //8   - F7

    // Naive solution
    // O(2^n) time | O(n) space
    public static int getNthFib(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 1) {
            return 0;
        } else {
            return getNthFib(n - 1) + getNthFib(n - 2);
        }
    }

    // O(n) time | O(n) space
    static Map cache = new HashMap<Integer, Integer>();

    public static int getNthFibWithCache(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 1) {
            return 0;
        } else {
            if (!cache.containsKey(n)) {
                cache.put(n, getNthFibWithCache(n - 1) + getNthFibWithCache(n - 2));
            }
            return (int) cache.get(n);
        }
    }
}
