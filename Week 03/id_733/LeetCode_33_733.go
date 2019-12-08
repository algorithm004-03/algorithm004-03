func search(nums []int, target int) int {
	left, right := 0, len(nums)-1
	for left <= right {
		mid := left + (right-left)>>1
		if nums[mid] == target {
			return mid
		}

		if nums[mid] < target {
			if nums[mid] < nums[0] && target >= nums[0] {
				right = mid - 1
			} else {
				left = mid + 1
			}
		} else {
			if nums[mid] >= nums[0] && target < nums[0] {
				left = mid + 1
			} else {
				right = mid - 1
			}
		}
	}

	return -1
}
