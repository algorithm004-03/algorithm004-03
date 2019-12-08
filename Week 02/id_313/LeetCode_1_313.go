package id313

// 使用map方式存储遍历数据
func twoSum(nums []int, target int) []int {
	m := make(map[int]int, 0)
	for k, num := range nums {
		v := target - num
		if vv, ok := m[v]; ok && vv != k {
			return []int{k, vv}
		}
		m[num] = k

	}
	return []int{}
}
