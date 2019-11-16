//122. 买卖股票的最佳时机II

//解法1：贪心思想	执行用时：1ms
//思路：若当天价格大于前一天的价格, 就进行买卖操作, 也就是获取差值总额
//时间复杂度O(n)
//空间复杂度O(1)
public int maxProfit(int[] prices) {
	if (prices.length == 0 || prices == null) return 0;
	int sum = 0;
	for (int i = 0; i < prices.length - 1; i++) {
		if (prices[i] < prices[i + 1]) sum += prices[i + 1] - prices[i];
	}
	return sum;
}

//解法2：动态规划		执行用时：3ms
//思路：和121题基本一致, 通过一个二维数组存储每一天持有股票和未持有股票的利润最大值
//		不同点在于：现在我们可以进行多笔交易。因此, 若当天选择持有股票, 情况就稍有变化：
//			当天可以选择继续持有前一天的股票以及买入股票。若选择买入股票, 那么就需要加上当天抛售股票获得的利润额
//			dp[i][1] = max(dp[i - 1][1], dp[i][0] - prices[i])
//时间复杂度：O(n)
//空间复杂度：O(n)
public int maxProfit(int[] prices) {
	if (prices.length == 0 || prices == null) return 0;
	int[][] dp = new int[prices.length][2];
	dp[0][1] = -prices[0];
	dp[0][0] = 0;
	for (int i = 1; i < prices.length; i++) {
		dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
		dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] - prices[i]);
	}
	return dp[dp.length - 1][0];
}

//解法2.1：动态规划-空间压缩 执行用时：2ms
//思路：参考121动态规划的空间压缩
//时间复杂度：O(n)
//空间复杂度：O(1)
public int maxProfit(int[] prices) {
	if (prices.length == 0 || prices == null) return 0;
	int[] dp = new int[2];
	dp[0] = 0;
	dp[1] = -prices[0];
	for (int i = 1; i < prices.length; i++) {
		dp[0] = Math.max(dp[0], dp[1] + prices[i]);
		dp[1] = Math.max(dp[1], dp[0] - prices[i]);
	}
	return dp[0];
}
