package week01

// 双指针法
func removeDuplicates(nums []int) int {
	snow, fast := 0, 1
	for ; fast < len(nums); fast++ {
		if nums[fast] != nums[fast-1] {
			snow++
			nums[snow] = nums[fast]
		}
	}

	return snow + 1
}
