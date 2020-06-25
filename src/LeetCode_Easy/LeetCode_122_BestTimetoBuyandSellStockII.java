package LeetCode_Easy;

public class LeetCode_122_BestTimetoBuyandSellStockII {
    public static void main(String[] args) {
        System.out.println(new LeetCode_122_BestTimetoBuyandSellStockII().maxProfit(new int[]{7, 1, 5, 3, 6, 4})); //7
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int max = 0;
        int sum = 0;
        int min = prices[0];
        int prev = prices[0];
        for (int price : prices) {
            if (price < prev) {
                sum += max;
                max = 0;
                min = price;
            }

            if (price < min) {
                min = price;
            }

            max = Math.max(max, price - min);
            prev = price;
        }
        return sum + max;
    }
}
