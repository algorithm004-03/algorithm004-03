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
public int coinChange(int[] coins, int amount, int[] cache) {
	int[] cache = new int[amount + 1];
	return recur(coins, amount, cache);
}

private int recur(int[] coins, int amount, int[] cache) {
	if (cache[amount] != 0) return cache[amount];
	if (amount == 0) return 0;
	int result = Integer.MAX_VALUE;
	for (int coin : coins) {
		if (amount - coin < 0) continue;
		int sub_problem = recur(coins, amount - coin, cache);
		if (sub_problem == -1) continue;
		result = Math.min(result, sub_problem + 1);
	}
	return cache[amount] = (result == Integer.MAX_VALUE ? -1 : result);
}

//解法3： 动态规划		执行用时：12ms
//思路：通过解法1我们能够明确子问题, 因此状态方程为dp[i] = min(dp[i - coins[0~k]])
//		明确了状态方程, 剩下要做的就是一些边界条件的判断了
//时间复杂度：O(N*K)
//空间复杂度：O(N)
public int coinChange(int[] coins, int amount) {
	int[] dp = new int[amount + 1];
	for (int i = 1; i <= amount; i++) {
		int result = -1;
		for (int coin : coins) {
			if (i - coin >= 0 && dp[i - coin] != -1) {
				int sub_problem = dp[i - coin] + 1;
				result = result == -1 ? sub_problem : Math.min(result, sub_problem);
			}
		}
		dp[i] = result;
	}
	return dp[amount];
}

//解法4：BFS	执行用时：87ms
//思路：通过广度优先遍历F(N)的所有子问题, 若发现子问题F(N - coin[0~K]) == 0, 说明在当前层发现零钱兑换完毕, 兑换的数量就是当前的层数
//总结：一开始只通过Queue写BFS解法, 数据量一大就超时, 后来看别人的题解受到启发用了Set去重, 改写后现在勉强能够运行..
public int coinChange(int[] coins, int amount) {
	Queue<Integer> queue = new LinkedList<>();
	HashSet<Integer> set = new HashSet<>();
	queue.offer(amount);
	int level = 0;
	while (!queue.isEmpty()) {
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			int temp = queue.poll();
			if (temp == 0) return level;
			for (int coin : coins) {
				if (temp >= coin && !set.contains(temp - coin)) {
					set.add(temp - coin);
					queue.offer(temp - coin);
				}
			}
		}
		level++;
	}
	return -1;
}