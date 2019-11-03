package leetcode

func twoSum(nums []int, target int) []int {
	dict := make(map[int]int)

	res := make([]int, 2)
	for i := 0; i < len(nums); i++ {
		if x, ok := dict[nums[i]]; ok {
			res = []int{x, i}
		} else {
			dict[target-nums[i]] = i
		}
	}

	return res
}