func permuteUnique(nums []int) [][]int {
	var res [][]int
	var values []int
	sort.Ints(nums)
	used := make([]bool, len(nums))
	doPermuteUnique(&res, nums, used, values)
	return res
}

func doPermuteUnique(res *[][]int, nums []int, used []bool, values []int) {
	if len(values) == len(nums) {
		r := make([]int, len(values))
		copy(r, values)
		*res = append(*res, r)
		return
	}

	for i := 0; i < len(nums); i++ {
		if used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
			continue
		}

		values = append(values, nums[i])
		used[i] = true
		doPermuteUnique(res, nums, used, values)
		values = values[:len(values)-1]
		used[i] = false
	}
}
