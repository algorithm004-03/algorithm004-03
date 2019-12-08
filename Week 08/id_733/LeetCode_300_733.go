func lengthOfLIS(nums []int) int {
	dp := make([]int, len(nums))
	res := 0
	for i := 0; i < len(nums); i++ {
		for j := 0; j < i; j++ {
			if nums[i] > nums[j] {
				dp[i] = max(dp[i], dp[j])
			}
		}

		dp[i] += 1
		res = max(res, dp[i])
	}

	return res
}

func max(x, y int) int {
	if x > y {
		return x
	}

	return y
}

func lengthOfLISV2(nums []int) int {
	dp := make([]int, len(nums))
	l := 0
	for _, n := range nums {
		pos := searchInsertPos(dp, 0, l-1, n)
		if pos < 0 {
			continue
		}

		dp[pos] = n
		if l == pos {
			l++
		}
	}

	return l
}

func searchInsertPos(nums []int, left, right, target int) int {
	for left <= right {
		mid := left + (right-left)>>1
		value := nums[mid]
		if value == target {
			return -1
		}

		if value > target {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}

	return left
}
