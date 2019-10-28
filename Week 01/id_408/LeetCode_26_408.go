func removeDuplicates(nums []int) int {
	var j int = 0
	var repCnt = 0

	for i, v := range nums {
		rel := nums[:i]
		inStatus := isItemInSlice(rel, v)

		if inStatus == true {
			repCnt++
			if repCnt == 1 {
				j = i
			}
		} else {
			if repCnt > 0 {
				nums[j] = nums[i]
				j++
			}
		}
	}

	return (len(nums) - repCnt)
}

func isItemInSlice(nums []int, item int) bool {
	for _, v := range nums {
		if v == item {
			return true
		}
	}

	return false
}
