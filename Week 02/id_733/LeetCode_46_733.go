func permute(nums []int) [][]int {
	var res [][]int
	var values []int
	used := make([]bool, len(nums))
	doPermute(&res, nums, used, values)
	return res
}

func doPermute(res *[][]int, nums []int, used []bool, values []int) {
	if len(values) == len(nums) {
		r := make([]int, len(nums))
		copy(r, values)
		*res = append(*res, r)
		return
	}

	for i := 0; i < len(nums); i++ {
		if used[i] {
			continue
		}

		values = append(values, nums[i])
		used[i] = true
		doPermute(res, nums, used, values)
		values = values[:len(values)-1]
		used[i] = false
	}
}
