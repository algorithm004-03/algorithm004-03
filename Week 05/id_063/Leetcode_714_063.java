/*
思路

dp[i][0] 表示第i天不持有股票的最大利润
dp[i][1] 表示第i天持有股票的最大利润

dp[i][0] = max (
    dp[i-1][1] + prices[i] -fee // 昨天为止持有股票，今天卖股票
    dp[i-1][0]                  // 昨天为止没股票，今天什么都不干
)

dp[i][1] = max (
    dp[i-1][1],                 // 昨天为止有股票，今天什么都不干
    dp[i-1][0] - prices[i]      // 昨天为止没股票，今天买股票
)

最后答案是dp[n-1][0] (因为最后一天肯定手上不持有股票才可能是利润最大的)

 */

class Solution {
    public int maxProfit(int[] prices, int fee) {
        if ((prices == null) || (prices.length == 0)) {
            return 0;
        }

        int dp0 = 0;
        int dp1 = -prices[0];
        int max0, max1;
        for (int i = 1; i < prices.length; i++) {
            max0 = Math.max(dp1 + prices[i] - fee, dp0);
            max1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = max0; dp1 = max1;
        }

        return dp0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {1,3,2,8,4,9}, 2));
    }
}
