func fib(N int) int {
	if N <= 1 {
		return N
	}

	prev2, prev1 := 0, 1
	for i := 2; i <= N; i++ {
		cur := prev1 + prev2
		prev1, prev2 = cur, prev1
	}

	return prev1
}
