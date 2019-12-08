func canJump(nums []int) bool {
    flag := len(nums) - 1
    for i := len(nums)-1; i >= 0; i-- {
        if nums[i] + i >= flag {
            flag = i
        }
    }
    
    return flag == 0
}
