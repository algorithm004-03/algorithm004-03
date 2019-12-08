func uniquePaths(m int, n int) int {
	opt := make([]int, m)
	opt[0] = 1
	for i := 0; i < n; i++ {
		for j := 1; j < len(opt); j++ {
			opt[j] += opt[j-1]
		}
	}
	return opt[len(opt)-1]
}
