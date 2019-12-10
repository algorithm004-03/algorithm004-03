func longestCommonSubsequence(s1 string, s2 string) int {
	m, n, A, B:= len(s1), len(s2), []byte(s1), []byte(s2)
	cur, prev := make([]int, m+1), make([]int, m+1)

	for j := 0; j < n; j++ {
		for i := 0; i < m; i++ {
			maxLen := max(prev[i+1], cur[i])
			if A[i] == B[j] {
				cur[i+1] = max(maxLen, prev[i]+1)
			} else {
				cur[i+1] = maxLen
			}
		}
		cur, prev = prev, cur
	}
	return prev[m]
}

func max(a, b int) int {
	if a > b {return a}
	return b
}