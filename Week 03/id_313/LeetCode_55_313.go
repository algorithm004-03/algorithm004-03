package id_313

func canJump(nums []int) bool {
	length := len(nums)
	pos := length - 1
	for i := length - 1; i >= 0; i-- {
		if i+nums[i] >= pos {
			pos = i
		}
	}
	return pos == 0
}
