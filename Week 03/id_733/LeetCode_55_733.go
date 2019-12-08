func canJump(nums []int) bool {
	reachable := len(nums) - 1
	for i := len(nums) - 2; i >= 0; i-- {
		if nums[i]+i >= reachable {
			reachable = i
		}
	}

	return reachable == 0
}
