public class NthFibonacciArray {

    //0
    //1
    //1
    //2
    //3
    static int[] fib(int n) {
        int[] fibArr = new int[n];
        if (n == 0){
            return new int[0];
        }
        fibArr[0] = 0;
        if (n == 1){
            return fibArr;
        }
        fibArr[1] = 1;
        if (n == 2){
            return fibArr;
        }

        for (int i = 2; i < n; i++){
            fibArr[i] = fibArr[i -1] + fibArr[i -2];
        }
        return fibArr;
    }

    public static void main(String[] args) {
        int[] fib = fib(100);
        for (int i = 0; i < fib.length; i ++){
            System.out.println(fib[i]);
        }
    }


}
