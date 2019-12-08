/*
 * @lc app=leetcode.cn id=50 lang=golang
 *
 * [50] Pow(x, n)
 */

// @lc code=start
package leetCode

func myPow(x float64, n int) float64 {
	if x == 0 {
		return 0
	}
	if n == 0 || x == 1 {
		return 1
	}
	if n < 0 {
		x = 1 / x
		n = -n
	}
	helf := myPow(x, n/2)
	if n%2 == 1 {
		return helf * helf * x
	} else {
		return helf * helf
	}
}

// @lc code=end
