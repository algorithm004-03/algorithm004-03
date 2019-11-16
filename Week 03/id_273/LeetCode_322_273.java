//322. 零钱兑换

//解法1：暴力递归	提交超时
//思路：假设硬币有1, 2, 5三种面额, 总金额 = 11
//		那么兑换总金额11所需要的最小硬币数F(11)就是 " 拿了1块钱：F(10)、拿了2块钱：F(9)、拿了5块钱：F(6) " 三者中的最小值
//		那么就可以明确子问题为 F(n) = min(n - coins[0~k])
//		只要明确了重复做的事, 那么首先可以考虑交给递归完成
//时间复杂度：O(k * n^k)
//空间复杂度：O(1)
public int coinChange(int[] coins, int amount) {
	if (amount == 0) return 0;
	int ans = Integer.MAX_VALUE;
	for (int coin : coins) {
		if (amount - coin < 0) continue;
		int subProblem = coinChange(coins, amount - coin);
		if (subProblem == -1) continue;
		ans = Math.min(subProblem + 1, ans);
	}
	return ans == Integer.MAX_VALUE ? -1 : ans;
}


//解法1.1：记忆化递归	执行用时：21ms
//思路：通过缓存数组避免重复计算
//时间复杂度：O(k * n)
//空间复杂度：O(n)
public int coinChange(int[] coins, int amount) {
	int[] cache = new int[amount + 1];
	Arrays.fill(cache, -2);
	return coinChange(coins, amount, cache);
}

public int coinChange(int[] coins, int amount, int[] cache) {
	if (cache[amount] != -2) return cache[amount];
	if (amount == 0) return 0;
	int ans = Integer.MAX_VALUE;
	for (int coin : coins) {
		if (amount - coin < 0) continue;
		int subProblem = coinChange(coins, amount - coin, cache);
		if (subProblem == -1) continue;
		ans = Math.min(subProblem + 1, ans);
	}
	return cache[amount] = (ans == Integer.MAX_VALUE) ? -1 : ans;
}

//解法3： 动态规划		执行用时：13ms
//思路：通过解法1我们能够明确子问题, 因此状态方程为dp[i] = min(dp[i - coins[0~k]])
//		明确了状态方程, 剩下要做的就是一些边界条件的判断了
//时间复杂度：O(N*K)
//空间复杂度：O(N)
public int coinChange(int[] coins, int amount) {
	int[] dp = new int[amount + 1];
	int sum = 0;
	while (++sum <= amount) {
		int min = -1;
		for (int c : coins) {
			if(sum >= c && dp[sum - c] != -1) {
				int subProblem = dp[sum - c] + 1;
				min = min < 0 ? subProblem : Math.min(subProblem, min); 
			}
		}
		dp[sum] = min;
	}
	return dp[amount];
}
