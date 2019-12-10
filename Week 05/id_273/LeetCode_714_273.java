//714. 买卖股票的最佳时机含手续费

//当前问题分析：
//		只需要在原DP方程的基础上, 每次完成交易的时候减去手续费即可
//			

//解法1：DP		执行用时：22ms
//时间复杂度：O(N)
//空间复杂度：O(N*2)
public int maxProfit(int[] prices, int fee) {
	int[][] dp = new int[prices.length][2];
	for (int i = 0; i < prices.length; i++) {
		if (i - 1 == -1) {
			dp[i][0] = 0;
			dp[i][1] = -prices[i];
			continue;
		}
		dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
		dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
	}
	return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
}

//解法2：DP降维		执行用时：8ms
//时间复杂度：O(N)
//空间复杂度：O(1)
public int maxProfit(int[] prices, int fee) {
	int[] dp = new int[2];
	dp[0] = 0;
	dp[1] = -prices[0];
	for (int i = 1; i < prices.length; i++) {
		dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
		dp[1] = Math.max(dp[1], dp[0] - prices[i]);
	}
	return dp[0];
}