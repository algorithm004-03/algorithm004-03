func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	n := len(obstacleGrid)
	if n == 0 {
		return 0
	}

	m := len(obstacleGrid[0])
	if m == 0 {
		return 0
	}

	dp := make([]int, m)
	dp[0] = 1
	for i := 0; i < n; i++ {
		if obstacleGrid[i][0] == 1 {
			dp[0] = 0
		}

		for j := 1; j < m; j++ {
			if obstacleGrid[i][j] == 1 {
				dp[j] = 0
			} else {
				dp[j] += dp[j-1]
			}
		}
	}

	return dp[m-1]
}
