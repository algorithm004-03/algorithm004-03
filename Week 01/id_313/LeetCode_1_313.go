package id313

// 一遍哈希表通过哈希判断是否重复
func twoSum(nums []int, target int) []int {
	l := len(nums)
	m := make(map[int]int, 0)
	for i := 0; i < l; i++ {
		s := target - nums[i]
		if v, ok := m[s]; ok && v != i {
			return []int{i, v}
		}
		m[nums[i]] = i

	}
	return []int{0, 0}

}
