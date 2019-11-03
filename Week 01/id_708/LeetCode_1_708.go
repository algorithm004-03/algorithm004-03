package leetcode

func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for i := range nums {
		if v, ok := m[nums[i]]; ok == true {
			return []int{v, i}
		}
		m[target-nums[i]] = i
	}
	return []int{}
}
