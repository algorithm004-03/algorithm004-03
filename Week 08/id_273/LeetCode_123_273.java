//123. 买卖股票的最佳时机III

//当前问题分析
//		对于当前题目的要求, K = 2, 也就是这几天内只能进行2笔交易, 而由于K = 2, 此时无法消除k的影响, 所以必须对交易次数K也进行穷举：
//			for (int k = 2; k >= 1; k--) {
//				DP[i][k][0] = max(DP[i - 1][k][0], DP[i - 1][k][1] + prices[i])
//				DP[i][k][1] = max(DP[i - 1][k][1], DP[i - 1][k - 1][0] - prices[i])
//			}

//解法1：三维DP		执行用时：6ms
public int maxProfit(int[] prices) {
	int[][][] dp = new int[prices.length][3][2];
	for (int i = 0; i < prices.length; i++) {
		for (int k = 2; k >= 1; k--) {
			if (i - 1 == -1) {
				dp[i][k][0] = 0;
				dp[i][k][1] = -prices[i];
				continue;
			}
			dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
			dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
		}
	}
	return dp[prices.length - 1][2][0];
}

//解法2：状态压缩		执行用时：5ms
public int maxProfit(int[] prices) {
	if (prices.length == 0 || prices == null) return 0;
	int[][] dp = new int[3][2];
	for (int i = 0; i < prices.length; i++) {
		for (int k = 2; k >= 1; k--) {
			if (i == 0) {
				dp[k][0] = 0;
				dp[k][1] = -prices[i];
				continue;
			}
			dp[k][0] = Math.max(dp[k][0], dp[k][1] + prices[i]);
			dp[k][1] = Math.max(dp[k][1], dp[k - 1][0] - prices[i]);
		}
	}
	return dp[2][0];
}

//解法3：一维		执行用时：3ms
public int maxProfit(int[] prices) {
	if (prices.length == 0 || prices == null) return 0;
	int dp_10 = 0, dp_11 = -prices[0];
	int dp_20 = 0, dp_21 = -prices[0];
	for (int i = 1; i < prices.length; i++) {
		dp_20 = Math.max(dp_20, dp_21 + prices[i]);
		dp_21 = Math.max(dp_21, dp_10 - prices[i]);
		dp_10 = Math.max(dp_10, dp_11 + prices[i]);
		dp_11 = Math.max(dp_11, -prices[i]);
	}
	return dp_20;
}