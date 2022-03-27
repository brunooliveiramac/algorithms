import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {


    @Test
    public void shouldReturnValue(){

        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        arr[5] = 6;
        arr[6] = 7;
        arr[7] = 8;

        int tg = BinarySearch.binarySearch(arr, 6);

        Assert.assertEquals(5, tg);

    }



}
