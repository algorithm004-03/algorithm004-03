package main

import "fmt"

func main() {
	matrix := [][]int{
		{1, 3, 5, 7},
		{10, 11, 16, 20},
		{23, 30, 34, 50},
	}
	result := searchMatrix(matrix, 11)
	fmt.Println(result)
}

func searchMatrix(matrix [][]int, target int) bool {
	for _, value := range matrix {
		l := len(value)
		if l == 0 {
			return false
		}
		if target >= value[0] && target <= value[l-1] {
			left := 0
			right := l - 1
			for left <= right {
				mid := (left + right) / 2
				if target == value[mid] {
					return true
				} else {
					if target < value[mid] {
						right = mid - 1
					} else {
						left = mid + 1
					}
				}
			}
		}
	}
	return false
}
