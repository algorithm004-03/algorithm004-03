func jump(nums []int) int {
	steps := 0
	for i, curEnd, nextEnd := 0, 0, 0; i < len(nums) - 1; i++ {
		farthest := i + nums[i]
		if farthest > nextEnd {
			nextEnd = farthest
		}

		if i == curEnd {
			steps++
			curEnd = nextEnd
		}
	}

	return steps
}
