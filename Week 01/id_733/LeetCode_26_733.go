func removeDuplicates(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	end := 0
	for idx := 1; idx < len(nums); idx++ {
		if nums[end] != nums[idx] {
			end++
			nums[end] = nums[idx]
		}
	}

	return end + 1
}