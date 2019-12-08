func countBits(num int) []int {
	ans, i, b := make([]int, num+1), 0, 1

	for b <= num {
		for i < b && i + b <= num {
			ans[i+b] = ans[i] + 1
			i++
		}
		i = 0
		b <<= 1
	}
	return ans
}
