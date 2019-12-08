package id_313

func jump(nums []int) int {
	length := len(nums)
	maxPos, end, step := 0, 0, 0
	for i := 0; i < length-1; i++ {
		maxPos = maxFunc(maxPos, i+nums[i])
		if i == end {
			end = maxPos
			step++
		}
	}
	return step
}

func maxFunc(a, b int) int {
	if a > b {
		return a
	}
	return b
}
