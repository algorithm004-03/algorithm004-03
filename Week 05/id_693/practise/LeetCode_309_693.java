package id_693.practise;

/**
 * @Desc 309. 最佳买卖股票时机含冷冻期	https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/14
 */
public class LeetCode_309_693 {
    //dp解法：与122一样，只是需要再买的时候多减1天
    /*
    dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
    dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
    解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
     */
    public int maxProfit(int[] prices) {
        int days = prices.length;
        if (days == 0) return 0;
        // 0  没有股票，  1  持有股票
        int[][] dp = new int[days][2];
        for (int i = 0; i < days; i++) {
            if (i - 1 == -1) {
                //base处理
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                continue;
            } else if (i - 1 == 0) {
                //处理第一次交易
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);//不动，卖
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);//不动，买
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);//不动，卖
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);//不动，买
        }
        return dp[days - 1][0];
    }
}
