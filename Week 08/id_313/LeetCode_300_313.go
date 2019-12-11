package id_313

func lengthOfLIS(nums []int) int {
	tails := make([]int, 0)
	length := len(nums)
	for i := 0; i < length; i++ {
		tlen := len(tails)
		if tlen == 0 {
			tails = []int{nums[i]}
			continue
		}
		if nums[i] > tails[tlen-1] {
			tails = append(tails, nums[i])
			continue
		}

		start, end, mid := 0, tlen-1, 0
		for start != end {
			mid = start + (end-start)/2
			if nums[i] > tails[mid] {
				start = mid + 1
			} else {
				end = mid
			}
		}
		tails[end] = nums[i]
	}
	return len(tails)
}
