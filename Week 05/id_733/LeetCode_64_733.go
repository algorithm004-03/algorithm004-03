func minPathSum(grid [][]int) int {
	n := len(grid)
	if n == 0 {
		return 0
	}

	m := len(grid[0])
	if m == 0 {
		return 0
	}

	dp := make([]int, m)
	dp[0] = grid[0][0]
	for j := 1; j < m; j++ {
		dp[j] = dp[j-1] + grid[0][j]
	}

	for i := 1; i < n; i++ {
		dp[0] += grid[i][0]
		for j := 1; j < m; j++ {
			dp[j] = min(dp[j-1], dp[j]) + grid[i][j]
		}
	}

	return dp[m-1]
}

func min(x, y int) int {
	if x > y {
		return y
	}

	return x
}
