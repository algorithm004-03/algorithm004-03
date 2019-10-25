package id313

// 快慢指针
func moveZeroes(nums []int) {
	length := len(nums)
	j := 0
	for i := 0; i < length; i++ {
		if nums[i] != 0 {
			nums[j], nums[i] = nums[i], nums[j]
			j++
		}
	}
}
