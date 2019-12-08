package leetcode

//https://leetcode-cn.com/problems/trapping-rain-water
//接雨水: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
func trap(height []int) int {

	if len(height) < 1 {

		return 0
	}

	left := 0
	right := len(height) - 1
	ans := 0

	leftMax := 0
	rightMax := 0

	for left < right {

		if height[left] < height[right] {

			if height[left] >= leftMax {

				leftMax = height[left]
			} else {
				ans += (leftMax - height[left])
			}
			left++
		} else {

			if height[right] > rightMax {

				rightMax = height[right]
			} else {
				ans += (rightMax - height[right])
			}
			right--
		}
	}
	return ans
}
