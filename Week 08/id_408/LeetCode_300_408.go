func lengthOfLIS(nums []int) int {
	size := 0
	tail := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		if size == 0 || tail[size-1] < nums[i] {
			tail[size] = nums[i]
			size++
		} else {
			x, y := 0, size-1
			for x < y {
				mid := (x + y) / 2
				if tail[mid] < nums[i] {
					x = mid + 1
				} else {
					y = mid
				}
			}
			tail[x] = nums[i]
		}
	}
	return size

}
