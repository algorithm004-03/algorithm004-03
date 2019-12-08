package leetcode

func maxCoins(nums []int) int {

	max := func(a, b int) int {

		if a > b {

			return a
		}
		return b
	}

	v := []int{1}
	v = append(v, nums...)
	v = append(v, 1)
	n := len(nums)
	dp := make([][]int, n+2)
	for i := 0; i < n+2; i++ {

		dp[i] = make([]int, n+2)
	}
	for s := 1; s <= n; s++ {
		for i := 1; i+s-1 <= n; i++ {
			j := i + s - 1
			for k := i; k <= j; k++ {

				dp[i][j] = max(dp[i][j], v[i-1]*v[k]*v[j+1]+dp[i][k-1]+dp[k+1][j])
			}
		}
	}
	return dp[1][n]
}
