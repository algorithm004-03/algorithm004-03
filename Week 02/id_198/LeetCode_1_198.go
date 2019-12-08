package leetcode

func twoSum(nums []int, target int) []int {

	m := make(map[int]int)
	rt := make([]int, 2)
	for i := 0; i < len(nums); i++ {

		num := nums[i]
		if index, ok := m[num]; ok {

			rt[0] = index
			rt[1] = i
			return rt
		}
		m[target-num] = i
	}
	return rt
}
