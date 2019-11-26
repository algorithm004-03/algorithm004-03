package id313

// 重点 排序数组 不需要考虑数组中超出长度后面的元素 快慢指针
func removeDuplicates(nums []int) int {
	length := len(nums)
	j := 0
	for i := 1; i < length; i++ {
		if nums[i] != nums[j] {
			j++
			nums[j] = nums[i]
		}
	}
	return j + 1
}
