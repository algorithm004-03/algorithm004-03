//115. 不同子序列

//解法1：DP 	执行用时：10ms
//思路：
public int numDistinct(String s, String t) {
	int[][] dp = new int[t.length() + 1][s.length() + 1];
	for (int j = 0; j < dp[0].length; j++) {
		dp[0][j] = 1;
	}
	for (int i = 1; i < dp.length; i++) {
		for (int j = 1; j < dp[0].length; j++) {
			int m = i - 1, n = j - 1;
			if (t.charAt(m) == s.charAt(n)) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
			} else {
				dp[i][j] = dp[i][j - 1];
			}
		}
	}
	return dp[dp.length - 1][dp[0].length - 1];
}