import org.junit.Test;

public class FindThreeLargestNumbersTest {

    @Test
    public void sort() {
        int[] arr = new int[6];
        arr[0] = 7;
        arr[1] = 8;
        arr[2] = 3;
        arr[3] = 11;
        arr[4] = 43;
        arr[5] = 55;


        int[]ar = FindThreeLargestNumbers.findThreeLargestNumbers(arr);

        for (int i = 0; i < ar.length; i ++){
            System.out.println(ar[i]);
        }
    }

}
