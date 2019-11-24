func findMin(nums []int) int {
	if len(nums) == 0 {
		return -1
	}
	i, j := 0, len(nums) - 1

	for i <= j{
		if nums[i] <= nums[j] {
			return nums[i]
		}
		mid := i + (j - i)/2
		if nums[mid] >= nums[i] {
			i = mid + 1
		} else {
			j = mid
		}
	}
	return -1
}