package week01

// 双指针法
func moveZeroes(nums []int) {

	nonZeroIndex := 0
	for i := range nums {
		if nums[i] != 0 {
			nums[nonZeroIndex], nums[i] = nums[i], nums[nonZeroIndex]
			nonZeroIndex++
		}
	}
}
