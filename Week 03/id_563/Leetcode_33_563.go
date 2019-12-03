/*
* 根据老师讲的正解
*/


func search(nums []int, target int) int {
	n := len(nums)
	l := 0
	r := n - 1

	for l <= r {
		if nums[l] == target {
			return l
		}

		if nums[r] == target {
			return r
		}

		mid := (l + r) / 2

		if nums[mid] == target {
			return mid
		}

		if nums[l] > nums[r] {
			l += 1
			r -= 1
		} else {
			if nums[mid] > target {
				r = mid - 1
			} else {
				l = mid + 1
			}
		}
	}

	return -1
}