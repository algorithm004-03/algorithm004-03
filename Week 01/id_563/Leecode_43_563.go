func trap(height []int) int {
	left, right, sum, maxLeft, maxRight := 0, len(height)-1, 0, 0, 0
	for left <= right {
		if height[left] <= height[right] {
			if height[left] >= maxLeft {
				maxLeft = height[left]
			} else {
				sum += maxLeft - height[left]
			}
			left++
		} else {
			if height[right] >= maxRight {
				maxRight = height[right]
			} else {
				sum += maxRight - height[right]
			}
			right--
		}
	}
	return sum
}
