package id_693.practise;

/**
 * @Desc 121. 买卖股票的最佳时机	https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/14
 */
public class LeetCode_121_693 {
    //简单解决：找出最小的值，然后和每个值计算差值。最大的差值就是结果了
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            ans = Math.max(price - min, ans);
        }
        return ans;
    }

    //DP解法 ：规律 这个只有一次交易
    /*
    原始方程：
    dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
    dp[i][1] = max(dp[i-1][1], -prices[i])
     */
    public int maxProfit1(int[] prices) {
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
            dp[i][1] = Math.max(dp[i - 1][1],- prices[i]);//不动，买
        }
        return dp[days - 1][0];
    }
}
