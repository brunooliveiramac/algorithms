import java.util.*;

class SubSequence {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
		int arrIndex = 0;
		int seqIndex = 0;
		
		while( arrIndex < array.size() && seqIndex < sequence.size() ){
			if (array.get(arrIndex) == sequence.get(seqIndex)){
				seqIndex += 1;
			}
			arrIndex += 1;
		}
    return seqIndex == sequence.size();
  }
}

