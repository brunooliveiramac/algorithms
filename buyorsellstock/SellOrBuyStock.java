import java.util.Arrays;
import java.util.OptionalInt;

public class SellOrBuyStock {

    int currentProfit = 0;

    public int maxProfit(int[] prices) {


        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i; j < prices.length - 1; j++) {
                if (prices[i] < prices[j + 1]) {
                    int profit = (prices[i] - prices[j + 1]) * -1;
                    if (profit > currentProfit) {
                        currentProfit = profit;
                    }
                }
            }
        }

        return currentProfit;
    }


    public static void main(String[] args) {
        SellOrBuyStock solution = new SellOrBuyStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = solution.maxProfit(prices);
        System.out.println("Max Profit: " + maxProfit);
    }
}
