func numDecodings(s string) int {
	prev1, prev2 := 1, 1
	for i := 0; i < len(s); i++ {
		cur := 0
		if s[i] > '0' {
			cur += prev1
		}

		if i > 0 && (s[i-1] == '1' ||  (s[i-1] == '2' && s[i] <= '6')) {
			cur += prev2
		}

		if cur == 0 {
			return 0
		}

		prev1, prev2 = cur, prev1
	}

	return prev1
}
