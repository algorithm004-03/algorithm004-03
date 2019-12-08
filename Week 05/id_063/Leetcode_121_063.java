/*
定义
dp[i][0] 是第i天还没买股票最大利润
dp[i][1] 是第i天持有股票最大利润
dp[i][2]  是第i天已经把股票卖掉的最大利润

递推公式为

dp[i][0] = max (
    dp[i-1][0],                     // 上一天为止还没买，今天也不做任何操作
)

dp[i][1] = max (
    dp[i-1][1],                 // 上一天为止已近买了，今天什么都做不了
    dp[i-1][0] - price[i],      // 上一天为止还没买，今天买股票
)

dp[i][2] = max {
    dp[i-1][2],             // 前一天为止股票已经卖了，今天什么都做不了
    dp[i-1][1] + price[i]   // 前一天为止还持有股票，今天卖股票
}

最后答案是 max ( dp[n-1][0], dp[n-1][2] )

推导可以发现 dp[i][0] 一直都是0

所以其实最后答案是 dp[n-1][2] > 0 ? dp[n-1][2] : 0;

 */

class Solution {
    public int maxProfit(int[] prices) {
        if ((prices == null) || (prices.length == 0)) {
            return 0;
        }

        int dp1, dp2;
        int max1, max2;
        dp1 = -prices[0]; dp2 = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            max1 = Math.max(dp1, 0 - prices[i]);
            max2 = Math.max(dp2, dp1 + prices[i]);

            dp1 = max1; dp2 = max2;
        }

        return Math.max(dp2, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {7,1,5,3,6,4}));
    }
}