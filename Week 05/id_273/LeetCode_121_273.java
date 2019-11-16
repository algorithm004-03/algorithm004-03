//121. 买卖股票的最佳时机

//解法1：暴力枚举		执行用时：280ms
//思路：获取所有买入卖出的组合, 计算其中的利润最大值返回
//时间复杂度：O(n^2)
//空间复杂度：O(1)
public int maxProfit(int[] prices) {
	int sum = 0;
	for (int i = 0; i < prices.length - 1; i++) {
		for (int j = i + 1; j < prices.length; j++) {
			sum = Math.max(sum, prices[j] - prices[i]);
		}
	}
	return sum;
}

//解法1.1：暴力枚举降维		执行用时：2ms
//思路：我们在枚举所有买入卖出的组合时, 只需要通过枚举 "当天价格 - 之前某天的最小价格" 的所有结果, 然后返回其中的最大值即是最大利润
//时间复杂度：O(n)
//空间复杂度：O(1)
public int maxProfit(int[] prices) {
	if (prices.length == 0 || prices == null) return 0;
	int sum = 0;
	int minVal = prices[0];
	for (int i = 1; i < prices.length; i++) {
		sum = Math.max(sum, prices[i] - minVal);
		minVal = Math.min(minVal, prices[i]);
	}
	return sum;
}

//解法2：动态规划（二维数组版）	执行用时：3ms
//思路：可以将当天的状态分为股票未持有和持有, 当天未持有或持有能获取的最大利润额度分别用dp[i][0], dp[i][1]表示
//		首先我们需要明确问题, 整个流程只能进行一次买卖操作！！
//		我们将买入股票设为-prices[i], 卖出股票设置为+prices[i]
//		若当天选择不持有股票, 那么有两种情况：
//			1. 前一天未持有股票：那么当天选择不持有股票的利润额就跟前一天不持有股票的利润额相同 dp[i][0] = dp[i - 1][0]
//			2. 前一天持有股票：那么当天选择不持有股票(抛售股票)的利润额为前一天持有的利润额加上当天卖出的价钱 dp[i][0] = dp[i - 1][1] + prices[i]
//			因此当天不持有股票的最大利润额 dp[i][0] = max([i - 1][0], dp[i - 1][1] + prices[i])
//		若当天选择持有股票, 也分为两种情况：
//			1. 前一天若未持有股票, 那么当天可以选择买入股票 dp[i][1] = -prices[i];
//			2. 前一天若持有股票, 那么当天可以选择继续持有原有的股票dp[i][1] = dp[i - 1][1]
//			因此当天持有股票情况的最大利润额 dp[i][1] = max(-prices[i], dp[i - 1][1])
//时间复杂度：O(n)
//空间复杂度：O(n)
public int maxProfit(int[] prices) {
	if (prices.length == 0 || prices == null) return 0;
	int[][] dp = new int[prices.length][2];
	dp[0][0] = 0;
	dp[0][1] = -prices[0];
	for (int i = 1; i < prices.length; i++) {
		dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
		dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
	}
	return dp[prices.length - 1][0];
}

//解法2.1：动态规划（状态压缩到）	执行用时：2ms
//思路：我们发现解法2在计算过程中, 计算当天利润额只用到了前一天持有股票和未持有股票的利润额
//		那么可以压缩数组长度为2, 仅仅用于保存当天和前一天的利润额
//时间复杂度：O(n)
//空间复杂度：O(1)
public int maxProfit(int[] prices) {
	if (prices.length == 0 || prices == null) return 0;
	int[] dp = new int[2];
	dp[0] = 0;
	dp[1] = -prices[0];
	for (int i = 1; i < prices.length; i++) {
		dp[0] = Math.max(dp[0], dp[1] + prices[i]);
		dp[1] = Math.max(dp[1], -prices[i]);
	}
	return dp[0];
}
