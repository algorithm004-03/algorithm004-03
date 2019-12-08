package com.company.leetcode.editor.cn;

//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
// 示例 1:
//
// 输入: [2,4,1], k = 2
//输出: 2
//解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
//
//
// 示例 2:
//
// 输入: [3,2,6,5,0,3], k = 2
//输出: 7
//解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
//
// Related Topics 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution_188 {
    public int maxProfit(int k, int[] prices) {

        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int len = prices.length;
        int profit = 0;
        if (k >= len / 2) {
            for (int i = 1; i < len; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        //动态规划
        int[][][] dp = new int[len][k + 1][2];

        for (int i = 0; i < prices.length; i++) {
            for (int j = k; j >= 1 ; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0],dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1],dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[len -1][k][0];
    }



//    public static void main(String[] args) {
//        Solution s = new Solution();
//        //Wrong Answer: input:2 [3,2,6,5,0,3] Output:6 Expected:7
//        int[] prices = new int[]{3,2,6,5,0,3};
//        System.out.println(s.maxProfit(2,prices));
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
