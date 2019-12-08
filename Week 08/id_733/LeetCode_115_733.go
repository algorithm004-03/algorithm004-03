func numDistinct(s string, t string) int {
	sLen, tLen := len(s), len(t)
	dp := make([][]int, 2)
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, sLen+1)
	}

	for j := 0; j <= sLen; j++ {
		dp[0][j] = 1
	}

	for i := 0; i < tLen; i++ {
		for j := 0; j < sLen; j++ {
			if t[i] == s[j] {
				dp[1][j+1] = dp[0][j] + dp[1][j]
			} else {
				dp[1][j+1] = dp[1][j]
			}
		}

		dp[0], dp[1] = dp[1], dp[0]
		dp[1][0] = 0
	}

	return dp[0][sLen]
}
