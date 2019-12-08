package id_693.practise;

/**
 * @Desc 123. 买卖股票的最佳时机 III	https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/14
 */
public class LeetCode_123_693 {
    //dp方程
    /*
        原始的动态转移方程，没有可化简的地方
        dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
        dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     */
    public int maxProfit(int[] prices) {
        int days = prices.length;
        if (days == 0) return 0;
        // 3 表示 可以交易2次
        int[][][] dp = new int[days][3][2];
        for (int i = 0; i < days; i++) {
            for (int j = 2; j >= 1; j--) {
                //跳过base
                if (i - 1 == -1) {
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[0];
                    continue;
                }
                //当前没有股票，但是我之前有，我卖一股
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);//不动，卖
                //当前持有股票，但是我之前没有，我买了一股
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);//不动，买
            }
        }
        return dp[days - 1][2][0];
    }

    public static void main(String[] args) {
        assert new LeetCode_123_693().maxProfit(new int[]{3, 2, 6, 5, 0, 3}) == 7;
        assert new LeetCode_123_693().maxProfit(new int[]{2, 4, 1}) == 2;
    }
}
