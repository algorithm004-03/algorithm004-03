//746. 使用最小花费爬楼梯

public int minCostClimbingStairs(int[] cost) {
	int[] dp = new int [cost.length + 1];
	dp[0] = cost[0];
	dp[1] = Math.min(dp[0] + cost[1], cost[1]);
	for (int i = 2; i < dp.length; i++) {
		if (i == cost.length) {
			dp[i] = Math.min(dp[i - 1], dp[i - 2]);
			break;
		}
		dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);

	}
	return dp[cost.length];
}