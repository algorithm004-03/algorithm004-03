//122. 买卖股票的最佳时机II


//股票问题统一分析：
//1. 穷举所有的"状态"
//		每天都可以有三种选择分别是：买入buy, 卖出sell, 无操作rest
//			买入必须在卖出之后, 因为题目限制只能完成一次交易后才能开始第二次交易
//			卖出必须在买入之后, 因为卖出的前提是要持有股票
//			无操作可以在买入后继续保持持有股票, 也可以在卖出后继续保持不持有股票

//		那么可以通过一个三维数组存放这几种状态的全部组合：DP[i][k][0 or 1]
//			语义为：当前为第i天,还能再进行k次交易,当前未持有/持有股票
//			最后要求的结果则是：DP[n - 1][0][0]
//			即：最后一天, 不能再进行交易, 且手上没持有股票

//2. 状态转移方程：
//		那么统一的状态转移方程就可以确定如下：
//			1. DP[i][k][0] = max(DP[i - 1][k][0], DP[i - 1][k][1] + prices[i])
//				即：第i天未持有股票, 那么可以从中择优：i - 1天也未持有股票, 第i天继续保持未持有; i - 1天持有股票, 第i天抛售股票完成一次交易
//			2. DP[i][k][1] = max(DP[i - 1][k][1], DP[i - 1][k - 1][0] - prices[i])
//				即：第i天持有股票, 那么可以从中择优：i - 1天持有股票, 第i天继续保持持有; i - 1天未持有股票, 进行一次交易k - 1, 买入一支股票
//		BaseCase：
//			DP[i][0][0] = 0 ：因为可交易次数为0, 不允许进行买入操作, 因此利润一定是0

//3. 当前问题分析
//		对于当前题目的要求, K = +infinite, 也就是这几天内可以进行多笔交易, 则状态方程如下：
//			1. DP[i][k][0] = max(DP[i - 1][k][0], DP[i - 1][k][1] + prices[i])
//			2. DP[i][k][1] = max(DP[i - 1][k][1], DP[i - 1][k - 1][0] - prices[i])
//		可以发现第2个转移方程中出现的"DP[i - 1][k - 1][0]", 由于k为正无穷, 因此k - 1 = k
//		而所有k对状态转移不产生影响, 因此状态K可以省略不写
//		到最后, 这个问题的状态转移方程如下：
//			1. DP[i][0] = max(DP[i - 1][0], DP[i - 1][1] + prices[i])
//			2. DP[i][1] = max(DP[i - 1][1], DP[i - 1][0] - prices[i])




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