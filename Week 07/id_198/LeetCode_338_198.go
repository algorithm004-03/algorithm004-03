package leetcode

//利用奇偶特性
func countBits(num int) []int {

	rt := make([]int, num+1)
	rt[0] = 0
	for i := 1; i <= num; i++ {

		rt[i] = rt[i&(i-1)] + 1
	}
	return rt
}
