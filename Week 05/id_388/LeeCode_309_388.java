package com.company.leetcode.editor.cn;
//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
//
//
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
//
//
// 示例:
//
// 输入: [1,2,3,0,2]
//输出: 3
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
// Related Topics 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution_309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];

        for (int i = 0; i < prices.length; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }

            if (i - 2 == -1) {
                dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
                continue;
            }

            //1、昨天就没有股票 2、昨天有股票，今天卖掉
            dp[i][0] = Math.max(dp[i - 1][0],dp[i-1][1] + prices[i]);

            //1、昨天就有股票  2、前天卖了，冷冻一天，今天买的
            dp[i][1] = Math.max(dp[i - 1][1],dp[i-2][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[] prices = new int[]{1,2,3,0,2};
//        System.out.println(s.maxProfit(prices));
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
