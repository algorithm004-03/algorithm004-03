/**
* 方法1
* 比较好理解的
*/

func searchMatrix(matrix [][]int, target int) bool {
	l := len(matrix)
	if  l == 0 {
		return false
	}

	small := 0
	large := l * len(matrix[0]) -1

	for small <= large {
		mid := (small + large)/2
		row := mid / len(matrix[0])
		col := mid % len(matrix[0])

		val := matrix[row][col]

		if val == target {
			return true
		}

		if val > target {
			large = mid - 1
		} else {
			small = mid + 1
		}
	}

	return false
}

/**
 * 方法2
 * 二分查找
 */

func searchMatrix(matrix [][]int, target int) bool {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return false
	}

	n := len(matrix)
	m := len(matrix[0])
	if target < matrix[0][0] || target > matrix[n-1][m-1] {
		return false
	}

	var mid int
	low, high := 0, n-1
	for low <= high {
		mid = (low + high) / 2
		if matrix[mid][0] > target {
			high = mid - 1
		} else if matrix[mid][0] < target {
			low = mid + 1
		} else {
			return true
		}
	}

	left, right := 0, m-1
	for left <= right {
		mid = (left + right) / 2
		if matrix[high][mid] > target {
			right = mid - 1
		} else if matrix[high][mid] < target {
			left = mid + 1
		} else {
			return true
		}
	}

	return false
}