public class FindThreeLargestNumbers {

    public static int[] findThreeLargestNumbers(int[] array) {
        int counter = 0;
        int arrToReturn[] = new int[3];
        arrToReturn[0] = Integer.MIN_VALUE;
        arrToReturn[1] = Integer.MIN_VALUE;
        arrToReturn[2] = Integer.MIN_VALUE;
        while ( counter < array.length ) {
            for(int i = 0; i < array.length; i ++) {
                int outer = array[counter];
                int inner = array[i];
                if(outer >= inner){
                    swap(arrToReturn, array[counter]);
                    break;
                }
            }
            counter ++;
        }
        return arrToReturn;
    }

    private static void swap(int[] arrToReturn, int newValue) {
        var first = arrToReturn[0];
        var second = arrToReturn[1];
        var third = arrToReturn[2];

        if ( newValue >= first ){
            arrToReturn[0] = newValue;
        }

        if (newValue >= second ) {
            arrToReturn[1] = newValue;
            arrToReturn[0] = second;
        }

        if ( newValue >= third ) {
            arrToReturn[0] = second;
            arrToReturn[1] = third;
            arrToReturn[2] = newValue;
        }
    }
}
