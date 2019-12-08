func maximalRectangle(matrix [][]byte) int {
	m := len(matrix)
	if m == 0 {
		return 0
	}

	n := len(matrix[0])
	if n == 0 {
		return 0
	}

	height := make([]int, n)
	left := make([]int, n)
	right := make([]int, n)
	for j := 0; j < n; j++ {
		right[j] = n
	}

	res := 0
	for i := 0; i < m; i++ {
		for j, curRight := n-1, n; j >= 0; j-- {
			if matrix[i][j] == '1' {
				right[j] = min(right[j], curRight)
			} else {
				curRight = j
				right[j] = n
			}
		}

		for j, curLeft := 0, 0; j < n; j++ {
			if matrix[i][j] == '1' {
				left[j] = max(left[j], curLeft)
				height[j]++
				res = max(res, (right[j]-left[j])*height[j])
			} else {
				curLeft = j + 1
				left[j] = 0
				height[j] = 0
			}
		}
	}

	return res
}

func max(x, y int) int {
	if x > y {
		return x
	}

	return y
}

func min(x, y int) int {
	if x < y {
		return x
	}

	return y
}
