func twoSum(nums []int, target int) []int {
    m := make(map[int]int, len(nums))
    
    for k,v := range nums {
        diff := target - v
        if idx, ok := m[diff]; ok {
            return []int{idx, k}
        }
        m[v] = k
    }
    
    return nil
}
