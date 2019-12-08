package id_313

func countBits(num int) []int {
	ret := make([]int, num+1)
	for i := 1; i <= num; i++ {
		ret[i] = ret[i&(i-1)] + 1
	}
	return ret
}
