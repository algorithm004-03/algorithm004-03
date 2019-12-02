func searchMatrix(matrix [][]int, target int) bool {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return false
	}

	left, right := 0, len(matrix)-1
	for left < right {
		mid := right - (right-left)>>1
		value := matrix[mid][0]
		if value == target {
			return true
		}

		if value < target {
			left = mid
		} else {
			right = mid - 1
		}
	}

	col := left
	left, right = 0, len(matrix[0])-1
	for left <= right {
		mid := left + (right-left)>>1
		value := matrix[col][mid]
		if value == target {
			return true
		}

		if value < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}

	return false
}

func searchMatrixV2(matrix [][]int, target int) bool {
	colLen := len(matrix)
	if colLen == 0 {
		return false
	}

	rowLen := len(matrix[0])
	left, right := 0, colLen*rowLen-1
	for left <= right {
		mid := left + (right-left)>>1
		col, row := mid/rowLen, mid%rowLen
		value := matrix[col][row]
		if value == target {
			return true
		}

		if value < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}

	return false
}
