package leetcode

func search(nums []int, target int) bool {

	nl := len(nums)
	if nl <= 0 {

		return false
	}

	l := 0
	r := nl - 1
	m := r / 2
	for l < r && l >= 0 {

		if nums[l] == target || nums[m] == target || nums[r] == target {

			return true
		}

		reduce := false
		for i := l + 1; i < len(nums) && nums[l] == nums[i]; i++ {

			l = i
			reduce = true
		}

		for i := r - 1; r > 0 && nums[r] == nums[i]; i-- {
			r = i
			reduce = true
		}

		if !reduce {

			if nums[l] < nums[m] {

				if target > nums[l] && target < nums[m] {

					r = m - 1
				} else {

					l = m + 1
				}

			} else {

				if target > nums[m] && target < nums[r] {

					l = m + 1
				} else {

					r = m - 1
				}

			}
		}

		m = (l + r) / 2
	}

	return false
}
