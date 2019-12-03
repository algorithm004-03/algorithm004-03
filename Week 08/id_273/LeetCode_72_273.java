//72. 编辑距离

//解法1：二维DP	执行用时：12ms
//思路：
public int minDistance(String word1, String word2) {
	int[][] dp = new int[word1.length() + 1][word2.length() + 1];
	for (int i = 0; i < dp.length; i++) {
		dp[i][0] = i;
	}
	for (int j = 0; j < dp[0].length; j++) {
		dp[0][j] = j;
	}
	for (int i = 1; i < dp.length; i++) {
		for (int j = 1; j < dp[0].length; j++) {
			if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
				dp[i][j] = dp[i - 1][j - 1];
				continue;
			}
			dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
		}
	}
	return dp[dp.length - 1][dp[0].length - 1];
}