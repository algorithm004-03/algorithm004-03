func longestPalindrome(s string) string {
	dp := make([][]bool, len(s))
	for i := range dp {
		dp[i] = make([]bool, len(s))
	}

	start, length := 0, 0
	for i := len(s) - 1; i >= 0; i-- {
		for j := i; j < len(s); j++ {
			dp[i][j] = s[i] == s[j] && (j-i < 3 || dp[i+1][j-1])
			if dp[i][j] {
				l := j - i + 1
				if l > length {
					length = l
					start = i
				}
			}
		}
	}

	return s[start : start+length]
}
