func removeDuplicates(nums []int) int {
    if len(nums) <= 1 {
        return len(nums)
    }
    
    lens, start := 1, nums[0]
    for i := 1; i < len(nums); i++ {
        if nums[i] != start {
            lens++
            nums[lens-1], start = nums[i], nums[i]
        }
    }
    return lens
}
