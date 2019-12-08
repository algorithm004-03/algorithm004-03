package id_693.practise;

/**
 * @Desc 122. 买卖股票的最佳时机 II	https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/14
 */
public class LeetCode_122_693 {
    //1、算差解题
    //2、峰谷法解题
    //3、dp解题
    /*
        原始方程：
        dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
        dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
     */
    public int maxProfit(int[] prices) {
        int days = prices.length;
        if (days == 0) return 0;
        // 0  没有股票，  1  持有股票
        int[][] dp = new int[days][2];
        for (int i = 0; i < days; i++) {
            if (i - 1 == -1){
                //base处理
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
                continue;
            }
            //当前没有股票，但是我之前有，我卖一股
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);//不动，卖
            //当前持有股票，但是我之前没有，我买了一股
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);//不动，买
        }
        return dp[days - 1][0];
    }
}
