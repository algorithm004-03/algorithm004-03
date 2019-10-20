/*
 * @lc app=leetcode.cn id=283 lang=golang
 *
 * [283] 移动零
 */

// @lc code=start
func moveZeroes(nums []int) {
	lastIndex := 0
	for index, value := range nums {
		if value == 0 {
			continue
		}

		nums[lastIndex], nums[index] = nums[index], nums[lastIndex]
		lastIndex++
	}
}

// @lc code=end
