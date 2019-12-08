package id313

// 要考虑 k 大于数组长度的情况 切割成两个部分，分别反转 再对整个数组反转
func rotate(nums []int, k int) {
	length := len(nums)
	k %= length
	reverse(nums, 0, length-k-1)
	reverse(nums, length-k, length-1)
	reverse(nums, 0, length-1)
}

func reverse(nums []int, start, end int) {
	for start < end {
		nums[start], nums[end] = nums[end], nums[start]
		start++
		end--
	}
}
