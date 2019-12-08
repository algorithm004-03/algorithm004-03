func twoSum(nums []int, target int) []int {
	m := make(map[int]int, len(nums))
	for i := 0; i < len(nums); i++ {
		if idx, ok := m[nums[i]]; ok {
			return []int{idx, i}
		}

		m[target-nums[i]] = i
	}

	return []int{}
}