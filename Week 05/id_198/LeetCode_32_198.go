package leetcode

//
func longestValidParentheses(s string) int {

	max := func(i, j int) int {

		if i > j {

			return i
		}

		return j
	}
	rt := 0
	t := []rune(s)
	dp := make([]int, len(t))
	for i := 1; i < len(t); i++ {
		if t[i] == ')' {
			if t[i-1] == '(' {
				if i >= 2 {

					dp[i] += dp[i-2] + 2
				} else {
					dp[i] += 2
				}
			} else if i-dp[i-1] > 0 && s[i-dp[i-1]-1] == '(' {

				if i-dp[i-1] >= 2 {

					dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2
				} else {

					dp[i] = dp[i-1] + 2
				}
			}
			rt = max(rt, dp[i])
		}
	}
	return rt
}
