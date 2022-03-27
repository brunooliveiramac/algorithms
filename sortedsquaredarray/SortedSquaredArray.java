import java.util.*;

class SortedSquaredArray {

  public int[] sortedSquaredArray(int[] array) {
        int[] finalArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            finalArr[i]	= array[i] * array[i];
        }
		Arrays.sort(finalArr);
        return finalArr;
  }
}

