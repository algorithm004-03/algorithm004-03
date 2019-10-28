package week01

// 引入 map, 空间换时间
func twoSum(nums []int, target int) []int {

	subToIndex := map[int]int{}

	for i, e := range nums {
		sub := target - e
		if index, ok := subToIndex[sub]; ok {
			return []int{index, i}
		}

		subToIndex[e] = i
	}

	return nil
}
