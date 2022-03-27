public class SelectionSort {


//    Divide the input array into two subarrays in place.
//    The first subarray should be sorted at all times and should
//    start with a length of 0, while the second subarray should be unsorted.
//    Find the smallest (or largest) element in the unsorted subarray and
//    insert it into the sorted subarray with a swap. Repeat this process of
//    finding the smallest (or largest) element in the unsorted subarray and
//    inserting it in its correct position in the sorted subarray with a swap
//    until the entire array is sorted.

    // O(n^2) time
    // O(1) space
    public static int[] selectionSort(int[] array) {
        int current = 0;
        int smallest = 0;
        while (current < array.length -1) {
            smallest = current;
            for (int i = smallest + 1; i < array.length; i++){
                if (array[smallest] > array[i]){
                    smallest = i;
                }
            }
            swap(array, current, smallest);
            current++;
        }
        return array;
    }

    private static void swap(int[] array, int i, int aux) {
        int newValue = array[aux];
        int current = array[i];

        array[i] = newValue;
        array[aux] = current;

    }


}
