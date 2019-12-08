func rob(nums []int) int {
	prev1, prev2 := 0, 0
	for _, n := range nums {
		cur := max(prev1, prev2+n)
		prev1, prev2 = cur, prev1
	}

	return prev1
}

func max(x, y int) int {
	if x > y {
		return x
	}

	return y
}
