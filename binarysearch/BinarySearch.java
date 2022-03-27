public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        return searchHelper(array, target, 0, array.length - 1);
    }


    public static int searchHelper(int[] array, int target, int left, int right){

        if (left > right) {
            return -1;
        }

        var mid = (left + right)/2;

        int roundedMid = Math.round(mid);

        if (array[roundedMid] == target) {
            return roundedMid;
        }

        if (array[roundedMid] < target) {
            return searchHelper(array, target, roundedMid + 1, right);
        }

        if (array[roundedMid] > target) {
            return searchHelper(array, target, left, roundedMid - 1);
        }

        return -1;

    }


}
