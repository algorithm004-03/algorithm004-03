//818. 赛车

//解法1：DP		执行用时：7ms
//思路：
public int racecar(int target) {
	int[] dp = new int[target + 1];
	for (int i = 1; i <= target; i++) {
		dp[i] = Integer.MAX_VALUE;
		for (int forward = 1; (1 << forward) - 1 < i * 2; forward++) {
			int j = (1 << forward) - 1;
			if (i == j) {
				dp[i] = forward;
			} else if (j > i) {
				dp[i] = Math.min(dp[i], dp[j - i] + forward + 1);
			} else {
				for (int back = 0; back < forward; back++) {
					int k = (1 << back) - 1;
					dp[i] = Math.min(dp[i], dp[i - j + k] + forward + 2 + back);
				}
			}
		}
	}
	return dp[target];
}