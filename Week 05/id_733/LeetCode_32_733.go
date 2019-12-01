func longestValidParentheses(s string) int {
	res := 0
	dp := make([]int, len(s)+1)
	for i := 1; i < len(s); i++ {
		dpIdx := i + 1
		if s[i] == '(' {
			dp[dpIdx] = 0
		} else if s[i-1] == '(' {
			dp[dpIdx] = dp[dpIdx-2] + 2
		} else {
			idx := i - 1 - dp[i]
			if idx >= 0 && s[idx] == '(' {
				dp[dpIdx] = dp[i] + dp[idx] + 2
			}
		}

		if dp[dpIdx] > res {
			res = dp[dpIdx]
		}
	}

	return res
}
