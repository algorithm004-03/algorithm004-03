/*
 * @lc app=leetcode.cn id=70 lang=golang
 *
 * [70] 爬楼梯
 */

// @lc code=start
func climbStairs(n int) int {
	if n < 3 {
		return n
	}

	f1, f2, ret := 1, 2, 0
	for index := 3; index <= n; index++ {
		ret = f1 + f2
		f1, f2 = f2, ret
	}

	return ret
}

// @lc code=end
