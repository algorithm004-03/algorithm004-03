func isMatch(s string, p string) bool {
	dp := make([][]bool, len(s)+1)
	for i := range dp {
		dp[i] = make([]bool, len(p)+1)
	}

	dp[0][0] = true
	for j := 0; j < len(p); j++ {
		if p[j] == '*' {
			dp[0][j+1] = true
		} else {
			break
		}
	}

	for i := 0; i < len(s); i++ {
		for j := 0; j < len(p); j++ {
			if p[j] == '*' {
				dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1]
			} else {
				dp[i+1][j+1] = dp[i][j] && (s[i] == p[j] || p[j] == '?')
			}
		}
	}

	return dp[len(s)][len(p)]
}
