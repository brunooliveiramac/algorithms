import java.util.Arrays;

public class TandemBicycle {


    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {


        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);


        int sum = 0;
        int count = fastest ? 0 : blueShirtSpeeds.length - 1;
        for (int i = redShirtSpeeds.length - 1; i >= 0; i--) {
            if (redShirtSpeeds[i] > blueShirtSpeeds[count]) {
                sum += redShirtSpeeds[i];
            } else {
                sum += blueShirtSpeeds[count];
            }
            count = fastest ? count + 1 : count - 1;
        }
        return sum;
    }

    public static void main(String[] args) {


//        int[] red = {5, 5, 3, 9, 2};
//
//        int[] blue = {3, 6, 7, 2, 1};

        int[] red = {5, 5, 3, 9, 2};

        int[] blue = {3, 6, 7, 2, 1};

        int sum = tandemBicycle(red, blue, false);

        System.out.println(sum);

    }

}
