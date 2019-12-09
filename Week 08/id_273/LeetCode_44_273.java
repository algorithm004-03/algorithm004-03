//44. 通配符匹配

//解法1：DP		执行用时：15ms
//思路：解法参考10. 正则表达式匹配
//时间复杂度：O(m*n)
//空间复杂度：O(m*n)
public boolean isMatch(String s, String p) {
	boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
	dp[0][0] = true;
	for (int j = 1; j < dp[0].length; j++) {
		if (p.charAt(j - 1) == '*') {
			dp[0][j] = true;
		} else {
			break;
		}
	}
	for (int i = 1; i < dp.length; i++) {
		for (int j = 1; j < dp[0].length; j++) {
			int m = i - 1, n = j - 1;
			if (p.charAt(n) == '*') {
				dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
			} else if (s.charAt(m) == p.charAt(n) || p.charAt(n) == '?') {
				dp[i][j] = dp[i - 1][j - 1];
			}
		}
	}
	return dp[dp.length - 1][dp[0].length - 1];
}