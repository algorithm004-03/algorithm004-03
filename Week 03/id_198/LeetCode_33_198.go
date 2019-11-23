package leetcode

// 因为给定的目标数组在某个点有序的，因此使用二分法查找。
// 相较于nums完全有序的情况下，经过旋转的数组在使用二分法时应关注如何避免旋转点对于查找过程的影响.
// len(nums) == 1的判定是避免进入二分法查找过程，若nums的长度恰好为1，若存在目标值，则直接返回0；否则返回-1，避免进入不必要的循环（个人习惯，起始完全可以避免）
func search(nums []int, target int) int {

	nl := len(nums)
	if nl <= 0 {

		return -1
	}

	if nl == 1 {

		if nums[0] == target {

			return 0
		}

		return -1
	}

	l := 0
	r := nl - 1
	m := r / 2
	for l < r && l >= 0 {

		if nums[l] == target {

			return l
		}

		if nums[m] == target {

			return m
		}
		if nums[r] == target {

			return r
		}

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
		m = (l + r) / 2
	}

	return -1
}
