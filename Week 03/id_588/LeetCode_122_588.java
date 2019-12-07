/**
 * 买股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class LeetCode_122_588 {

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            // 只要是今天比前一天上涨，就进行买卖
            if (prices[i] > prices[i - 1]) {
                max = max + (prices[i] - prices[i - 1]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LeetCode_122_588 solution = new LeetCode_122_588();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
