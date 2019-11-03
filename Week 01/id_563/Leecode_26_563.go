func removeDuplicates(nums []int) int {
    l := len(nums)
    if l < 2 {
        return l
    }
    i := 1
	for _, v := range nums[1:] {
		if v == nums[i-1] {
			continue
		}
		nums[i] = v
		i++
	}
	return i
}
