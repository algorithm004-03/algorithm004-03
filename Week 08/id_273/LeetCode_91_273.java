//91. 解码方法

//解法1：DP		执行用时：1ms
public int numDecodings(String s) {
	int len = s.length();
	int[] dp = new int[len + 1];
	dp[len] = 1;
	dp[len - 1] = s.charAt(len - 1) - '0' == 0 ? 0 : 1;
	for (int i = len - 2; i >= 0; i--) {
		if (s.charAt(i) - '0' == 0) {
			dp[i] = 0;
		} else if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
			dp[i] = dp[i + 1] + dp[i + 2];
		} else {
			dp[i] = dp[i + 1];
		}
	}
	return dp[0];
}