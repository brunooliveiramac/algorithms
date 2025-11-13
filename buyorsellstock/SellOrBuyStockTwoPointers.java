public class SellOrBuyStockTwoPointers {

    int currentProfit = 0;

    public int maxProfit(int[] prices) {
        int left = 0; // buy
        int right = 1; // sell

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int profit = (prices[left] - prices[right]) * -1;
                if (profit > currentProfit) {
                    currentProfit = profit;
                }
            } else {
                left = right;
            }
            right ++;
        }
        return currentProfit;
    }


    public static void main(String[] args) {
        SellOrBuyStockTwoPointers solution = new SellOrBuyStockTwoPointers();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = solution.maxProfit(prices);
        System.out.println("Max Profit: " + maxProfit);
    }
}
