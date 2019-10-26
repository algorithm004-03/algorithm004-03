package week01

// 双指针解法
func trap(height []int) int {
	left, right := 0, len(height)-1
	leftMax, rightMax := 0, 0
	r := 0

	for left < right {

		if height[left] < height[right] {

			cur := height[left]
			if cur < leftMax {
				r += leftMax - cur
			} else {
				leftMax = cur
			}

			left++

		} else {

			cur := height[right]
			if cur < rightMax {
				r += rightMax - cur
			} else {
				rightMax = cur
			}

			right--
		}
	}

	return r
}
