//188. 买卖股票的最佳时机IV

//当前问题分析
//		一次完整的交易由一次买入和卖出构成, 至少需要两天, 那么限制k次交易也就意味着只有当price.length = 2*k才是有效的
//		对于k > price.length/2的情况, 我们可以认为k = +无穷, 也就可以转换为股票问题II
//			


//解法1：三维DP + 贪心	执行用时：9ms
//时间复杂度：O(n*k)
//空间复杂度：O(n*k*2)
public int maxProfit(int k, int[] prices) {
	if (prices.length == 0 || prices == null) return 0;
	if (k > prices.length >> 1) {
		return maxProfitWithoutLimit(prices);
	}
	int[][][] dp = new int[prices.length][k + 1][2];
	for (int i = 0; i < prices.length; i++) {
		for (int j = k; j >= 1; j--) {
			if (i - 1 == -1) {
				dp[i][j][0] = 0;
				dp[i][j][1] = -prices[i];
				continue;
			}
			dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
			dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
		}
	}
	return dp[prices.length - 1][k][0];
}

private int maxProfitWithoutLimit(int[] prices) {
	int sum = 0;
	for (int i = 0; i < prices.length - 1; i++) {
		if (prices[i] < prices[i + 1]) {
			sum+= prices[i + 1] - prices[i];
		} 
	}
	return sum;
}

//解法2：降维 + 贪心	执行用时：7ms
//时间复杂度：O(n*k)
//空间复杂度：O(2 * K)
public int maxProfit(int k, int[] prices) {
	if (prices.length == 0 || prices == null) return 0;
	if (k > prices.length >> 1) {
		return maxProfitWithoutLimit(prices);
	}
	int[][] dp = new int[k + 1][2];
	for (int i = 0; i < prices.length; i++) {
		for (int j = k; j >= 1; j--) {
			if (i == 0) {
				dp[j][0] = 0;
				dp[j][1] = -prices[i];
				continue;
			}
			dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
			dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
		}
	}
	return dp[k][0];
}

//贪心....
