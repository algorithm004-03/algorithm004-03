func maxProduct(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	res := nums[0]
	for i, prevMax, prevMin := 1, nums[0], nums[0]; i < len(nums); i++ {
		if nums[i] < 0 {
			prevMax, prevMin = prevMin, prevMax
		}

		prevMax = max(prevMax*nums[i], nums[i])
		prevMin = min(prevMin*nums[i], nums[i])
		res = max(res, prevMax)
	}

	return res
}

func max(x, y int) int  {
	if x > y {
		return x
	}

	return y
}

func min(x, y int) int {
	if x < y {
		return x
	}

	return y
}
