package id313

// 双指针 两边往中间走 主要是理解lMax 和 rMax
func trap(height []int) int {
	lMax := 0
	rMax := 0
	length := len(height)
	s := 0
	j := length - 1
	i := 0
	for i < j {
		lMax = max(lMax, height[i])
		rMax = max(rMax, height[j])
		if lMax < rMax {
			s += lMax - height[i]
			i++
		} else {
			s += rMax - height[j]
			j--
		}
	}
	return s
}

func max(m, n int) int {
	if m > n {
		return m
	}
	return n
}
