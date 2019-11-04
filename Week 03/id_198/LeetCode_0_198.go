package leetcode

func searchRotatedIndex(nums []int) int {

	nl := len(nums)
	if nl < 2 {

		return -1
	}

	l := 0
	r := nl - 1
	m := r / 2
	for l < r && l >= 0 {

		if m > 0 && nums[m] < nums[m-1] {

			return m
		}
		if nums[m] > nums[m+1] {

			return m + 1
		}
		if nums[l] < nums[m] {

			l = m + 1

		} else {

			r = m - 1
		}
		m = (l + r) / 2
	}

	return -1
}
