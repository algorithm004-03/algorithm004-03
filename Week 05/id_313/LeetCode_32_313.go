package main

func longestValidParentheses(s string) int {
	max := 0
	length := len(s)
	dp := make([]int, len(s))
	bytes := []byte(s)
	left := byte('(')  // 转换成 byte
	right := byte(')') // 同上
	for i := 1; i < length; i++ {
		if bytes[i] == left {
			dp[i] = 0
		} else if bytes[i] == right {
			if bytes[i-1] == left {
				if i > 1 {
					dp[i] = dp[i-2] + 2
				} else {
					dp[i] = 2
				}
			} else {
				if i-dp[i-1]-1 >= 0 && bytes[i-dp[i-1]-1] == left {
					dp[i] = dp[i-1] + 2
					if i-dp[i-1] >= 2 {
						dp[i] += dp[i-dp[i-1]-2]
					}
				} else {
					dp[i] = 0
				}
			}
		}
		if max < dp[i] {
			max = dp[i]
		}
	}
	return max
}
