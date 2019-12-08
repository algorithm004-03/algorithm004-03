func maxSubArray(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	res := nums[0]
	for i, prev := 1, nums[0]; i < len(nums); i++ {
		var cur int
		if prev < 0 {
			cur = nums[i]
		} else {
			cur = prev + nums[i]
		}

		if cur > res {
			res = cur
		}

		prev = cur
	}

	return res
}
