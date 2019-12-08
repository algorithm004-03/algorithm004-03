func minimumTotal(triangle [][]int) int {
	l := len(triangle)
	if l == 0 {
		return 0
	}

	dp := make([]int, len(triangle[l-1])+1)
	for i := l - 1; i >= 0; i-- {
		for j := range triangle[i] {
			dp[j] = min(dp[j], dp[j+1]) + triangle[i][j]
		}
	}

	return dp[0]
}

func min(x, y int) int {
	if x > y {
		return y
	}

	return x
}
