package id_313

func search(nums []int, target int) int {
	rotated := minIndex(nums)
	length := len(nums)
	left, right := 0, length-1
	for left <= right {
		mid := (left + right) / 2
		rotatedMid := (rotated + mid) % length
		if nums[rotatedMid] < target {
			left = mid + 1
		} else if nums[rotatedMid] > target {
			right = mid - 1
		} else {
			return rotatedMid
		}
	}
	return -1

}

func minIndex(nums []int) int {
	left, right := 0, len(nums)-1
	for left < right {
		mid := (left + right) / 2
		if nums[right] < nums[mid] {
			left = mid + 1
		} else {
			right = mid
		}
	}
	return left
}
