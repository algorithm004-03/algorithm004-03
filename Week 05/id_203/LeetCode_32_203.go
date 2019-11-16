package week05

//我的解法
//func longestValidParentheses(s string) int {
//	maxans, n := 0, len(s)
//	dp := make([]int, n)
//
//	for i := 1; i < n; i++ {
//		if s[i] == ')' {
//			if s[i] == '(' {
//				if i >= 2 {
//					dp[i] = dp[i - 2] + 2
//				} else {
//					dp[i] = 2
//				}
//			} else if i - dp[i - 1] > 0 && s[i - dp[i - 1] - 1] == '(' {
//				dp[i] = dp[i - 1] + 2
//				if (i - dp[i - 1]) >= 2 {
//					dp[i] = dp[i - dp[i - 1] - 2]
//				}
//			}
//			maxans = Max(maxans, dp[i])
//		}
//
//	}
//
//	return maxans
//}

// 国际站的解法
func longestValidParentheses(s string) int {
	if len(s) == 0 {
		return 0
	}
	n, left, max := len(s), 0, 0
	dp := make([]int, n)

	for i := 0; i < n; i++ {
		if s[i] == '(' {
			left++
		} else if left > 0 {
			dp[i] = dp[i-1] + 2
			if i-dp[i] > 0 {
				dp[i] += dp[i-dp[i]]
			}
			max = Max(max, dp[i])
			left--
		}
	}

	return max
}

func Max(a, b int) int {
	if a > b {
		return a
	}
	return b
}