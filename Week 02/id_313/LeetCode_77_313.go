package id313

// 回溯，画图捋清回溯的过程
func combine(n int, k int) [][]int {
	combination := make([]int, k)
	ret := make([][]int, 0)
	var f func(int, int)
	f = func(index, begin int) {
		if index == k {
			tmp := make([]int, k)
			copy(tmp, combination)
			ret = append(ret, tmp)
			return
		}
		for i := begin; i <= n-(k-index)+1; i++ {
			combination[index] = i
			f(index+1, i+1)
		}
	}
	f(0, 1)
	return ret
}
