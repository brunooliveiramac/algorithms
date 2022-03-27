import org.junit.Test;

public class BubbleSortTest {


    @Test
    public void sort() {
        int[] arr = new int[8];
        arr[0] = 3;
        arr[1] = 7;
        arr[2] = 2;
        arr[3] = 5;
        arr[4] = 6;
        arr[5] = 9;
        arr[6] = 8;
        arr[7] = 1;

        int[]ar = BubbleSort.bubbleSort(arr);

        for (int i = 0; i < ar.length; i ++){
            System.out.println(ar[i]);
        }
    }


}
