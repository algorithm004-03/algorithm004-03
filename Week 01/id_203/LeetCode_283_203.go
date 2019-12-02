package leetcode

func moveZeroes(nums []int) {
	j := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			if i != j {
				nums[j] = nums[i]
				nums[i] = 0
			}
			j++
		}
	}

}
