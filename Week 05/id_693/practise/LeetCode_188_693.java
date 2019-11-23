package id_693.practise;

/**
 * @Desc 188. 买卖股票的最佳时机 IV	https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/14
 */
public class LeetCode_188_693 {

    //dp解法，如果交易次数大于天数的2倍，则表示交易无限制，直接用2方法，否则直接走限制交易
    /*
        原始方程和k = 2 一样，
            只是多一个判断(防止超时)，如果交易次数 > 天数 / 2  那么就直接代表交易无限制，就调用之前的无限制方法
     */
    public int maxProfit(int k, int[] prices) {
        int days = prices.length;
        if (days == 0) return 0;
        if (k > days / 2) return new LeetCode_122_693().maxProfit(prices);
        // 0  没有股票，  1  持有股票
        int[][][] dp = new int[days][k + 1][2];
        for (int i = 0; i < days; i++) {
            for (int j = k; j >= 1; j--) {
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
        return dp[days - 1][k][0];
    }

    public static void main(String[] args) {
        // System.out.println(new LeetCode_188_693().maxProfit(2, new int[]{2, 4, 1}) + "          " + 2);
        System.out.println(new LeetCode_188_693().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}) + "          " + 7);
        System.out.println(new LeetCode_188_693().maxProfit(0, new int[]{3, 2, 6, 5, 0, 3}) + "          " + 0);
        System.out.println(new LeetCode_188_693().maxProfit(2, new int[]{2, 4, 1}) + "          " + 2);
        System.out.println(new LeetCode_188_693().maxProfit(4, new int[]{2, 4, 1}) + "          " + 2);
    }
}
