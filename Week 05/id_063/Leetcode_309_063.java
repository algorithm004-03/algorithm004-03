
/*
思路

dp[i][0] 表示第i天不持有股票且当天没有卖股票的最大利润
dp[i][1] 表示第i天持有股票的最大利润
dp[i][2] 表示第i天不持有股票且当天卖了股票的最大利润


dp[i][0] = max (
    dp[i-1][2]                  // 昨天卖了股票，今天什么都不干
    dp[i-1][0]                  // 昨天没股票，今天什么都不干
)

dp[i][1] = max (
    dp[i-1][1],                 // 昨天为止有股票，今天什么都不干
    dp[i-1][0] - prices[i]      // 昨天为止没股票，今天买股票
    dp[i-1][2] - prices[i]      // 昨天刚卖了股票，今天买股票 ************ 根据题目描述，这种状态不合法，代码里面去除掉即可
)

dp[i][2] = max (
    dp[i-1][1] + prices[i]      // 昨天有股票，今天卖股票
)

最后答案是max (dp[n-1][0], dp[n-1][2]) (因为最后一天肯定手上不持有股票才可能是利润最大的)

 */

class Solution {
    public int maxProfit(int[] prices) {
        if ((prices == null) || (prices.length == 0)) {
            return 0;
        }

        long dp0 = 0;
        long dp1 = -prices[0];
        long dp2 = Integer.MIN_VALUE;

        long max0, max1, max2;
        for (int i = 1; i < prices.length; i++) {
            max0 = Math.max(dp2, dp0);
            max1 = Math.max(dp1, dp0 - prices[i]);
            max2 = dp1 + prices[i];

            dp0 = max0; dp1 = max1; dp2 = max2;
        }

        return (int)Math.max(dp0, dp2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {1,2,3,0,2}));
    }
}