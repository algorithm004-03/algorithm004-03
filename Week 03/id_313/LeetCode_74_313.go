package id_313

func searchMatrix(matrix [][]int, target int) bool {
	m := len(matrix)
	if m == 0 {
		return false
	}
	n := len(matrix[0])
	mid, element := 0, 0
	left, right := 0, m*n-1
	for left <= right {
		mid = (left + right) / 2
		element = matrix[mid/n][mid%n]
		if element == target {
			return true
		} else {
			if target < element {
				right = mid - 1
			} else {
				left = mid + 1
			}
		}
	}
	return false
}
