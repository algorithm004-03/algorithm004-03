func findMin(nums []int) int {
	left, right := 0, len(nums)-1
	for left < right {
		if nums[left] < nums[right] {
			break
		}

		mid := left + (right-left)>>1
		if nums[mid] < nums[0] {
			right = mid
		} else {
			left = mid + 1
		}
	}

	return nums[left]
}
