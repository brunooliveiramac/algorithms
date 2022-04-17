import java.util.*;

class NonConstructibleChange {


	public int nonConstructibleChange(int[] coins) {

		if(coins.length == 0){
			return 1;
		}

		Arrays.sort(coins);
		// 1, 1, 2, 3, 5, 7, 22

		int sum = 0;
		int changeThatCannotBeCreated = 0		;

		for (int i = 0; i < coins.length; i++){
			changeThatCannotBeCreated = sum + 1;
			if (changeThatCannotBeCreated < coins[i]){
				return changeThatCannotBeCreated;
			}
			sum += coins[i];
			if (coins.length == i + 1){
				return changeThatCannotBeCreated + coins[i];
			}
			changeThatCannotBeCreated = 0;
		}

		return -1;
	}
}

