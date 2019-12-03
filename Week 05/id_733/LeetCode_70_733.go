func climbStairs(n int) int {
	if n == 1 {
		return 1
	}

	prev1, prev2 := 2, 1
	for i := 3; i <= n; i++ {
		cur := prev1 + prev2
		prev1, prev2 = cur, prev1
	}

	return prev1
}
