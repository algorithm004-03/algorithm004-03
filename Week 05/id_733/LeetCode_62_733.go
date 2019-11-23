func uniquePaths(m int, n int) int {
	if m <= 0 || n <= 0 {
		return 0
	}

	dp := make([]int, m)
	for j := range dp {
		dp[j] = 1
	}

	for i := 1; i < n; i++ {
		for j := 1; j < m; j++ {
			dp[j] += dp[j-1]
		}
	}

	return dp[m-1]
}
