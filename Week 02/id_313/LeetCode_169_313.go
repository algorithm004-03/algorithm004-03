package id313

// 摩尔投票
func majorityElement(nums []int) int {
	count, candidate := 1, nums[0]
	for _, v := range nums[1:] {
		if count == 0 {
			candidate = v
			count = 1
		} else if v == candidate {
			count++
		} else {
			count--
		}
	}
	return candidate
}
