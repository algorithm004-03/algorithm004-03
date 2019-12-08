func moveZeros(nums []int) {
	for i, idx := 0, 0; i < len(nums); i++ {
		if nums[i] == 0 {
			continue
		}

		nums[i], nums[idx] = nums[idx], nums[i]
		idx++
	}
}
