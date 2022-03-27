import java.util.*;

class TwoNumberSum {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    int aux = 0;
		for(int j = 0; j < array.length; j ++){
			for (int i = 0; i < array.length; i ++) {
				if (aux != i){
					 int result = array[aux] + array[i];
					 if (result == targetSum){
						 int arrToReturn[] = {array[aux], array[i]};
						 return arrToReturn;
					 }
				}
			}
			aux ++;
		}	
    return new int[0];
  }
}

