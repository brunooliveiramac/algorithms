public class BubbleSort {


    public static int[] bubbleSort(int[] array) {
        int next = 0;
        for (int i = 0; i < array.length; i ++) {
            int current = array[i];
            for (int j = i; j < array.length; j ++) {
                    if (j + 1 <= array.length -1) {
                        next = array[j + 1];
                        if (current > next) {
                            array[j + 1] = current;
                            array[i] = next;
                            current = next;
                        }
                    }
                }
            }
        return array;
    }



}
