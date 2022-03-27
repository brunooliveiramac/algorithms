import org.junit.Test;

public class MinimumWaitingTimeTest {

    @Test
    public void shouldReturn17GivenTheListNumbers(){
        MinimumWaitingTime minimumWaitingTime = new MinimumWaitingTime();

        int[] arr = new int[5];
        arr[0] = 3;
        arr[1] = 2;
        arr[2] = 1;
        arr[3] = 2;
        arr[4] = 6;

        System.out.println(minimumWaitingTime.minimumWaitingTime(arr));

    }

}
