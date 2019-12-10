//309. 最佳买卖股票时机含冷冻期

//当前问题分析：
//		每当完成一次完整的交易后, 需要间隔一天再继续下一次交易
//		因此, 状态方程为：
//				dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//				dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);

//解法1：二维DP		执行用时：2ms
//时间复杂度：O(n)
//空间复杂度：O(2 * n)
public int maxProfit(int[] prices) {
	if (prices.length <= 1 || prices == null) return 0;
	int[][] dp = new int[prices.length][2];
	dp[0][0] = 0;
	dp[0][1] = -prices[0];
	dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
	dp[1][1] = Math.max(dp[0][1], -prices[1]);
	for (int i = 2; i < prices.length; i++) {
		dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
		dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
	}
	return dp[prices.length - 1][0];
}

//解法2：DP降维		执行用时：1ms
//时间复杂度：O(n)
//空间复杂度：O(1)
public int maxProfit(int[] prices) {
	if (prices.length <= 1 || prices == null) return 0;
	int dp_0 = 0, dp_1 = -prices[0], dp_pre_0 = 0;
	for (int i = 1; i < prices.length; i++) {
		int temp = dp_0;
		dp_0 = Math.max(dp_0, dp_1 + prices[i]);
		dp_1 = Math.max(dp_1, dp_pre_0 - prices[i]);
		dp_pre_0 = temp;
	}
	return dp_0;
}