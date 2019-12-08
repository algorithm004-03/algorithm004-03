func countBits(num int) []int {
	res := make([]int, num+1)
	for i := 1; i <= num; i++ {
		res[i] = res[i>>1] + i&1
	}
	return res
}
