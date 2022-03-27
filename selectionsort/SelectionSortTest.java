import org.junit.Test;

public class SelectionSortTest {


    @Test
    public void sort() {
        int[] arr = new int[7];
        arr[0] = 8;
        arr[1] = 5;
        arr[2] = 2;
        arr[3] = 9;
        arr[4] = 5;
        arr[5] = 6;
        arr[6] = 3;


        int[]ar = SelectionSort.selectionSort(arr);

        for (int i = 0; i < ar.length; i ++){
            System.out.println(ar[i]);
        }
    }


}
