public class InsertionSorting {

    public static int[] insertionSort(int[] array) {
        int count = 0;
        while ( count < array.length ) {
            // Looping Backwards
            for (int i = count + 1; i > 0; i--){
                if (i <= array.length -1) {
                    int last = array[i];
                    int before = array[i-1];

                    if (last < before){
                        swap(array, i, i -1);
                    }
                }
            }
            count ++;
        }
        return array;
    }

    private static void swap(int[] array, int last, int before) {
       int mainValue = array[last];
       int internalValue = array[before];

       array[last] = internalValue;
       array[before] = mainValue;
    }

    public static void main(String[] args) {
        int[] arr = new int[4];
        arr[0] = 2;
        arr[1] = 1;
        arr[2] = 5;
        arr[3] = 4;

        int[] sort = insertionSort(arr);
        for (int i = 0; i < sort.length; i++){
            System.out.println(sort[i]);
        }
    }

}
