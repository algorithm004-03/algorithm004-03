func search(nums []int, target int) int {
    left, right := 0, len(nums)-1
    
    for left <= right {
        mid := (left + right)/2
        if nums[mid] == target {
            return mid
        }
        
        if nums[left] <= nums[mid] && (target > nums[mid] || target < nums[left]) {
            left = mid + 1
        } else if (target > nums[mid] && target < nums[left]) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    
    return -1
}
