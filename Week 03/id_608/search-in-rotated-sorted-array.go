package main

import (
	"fmt"
)

func main() {
	nums := []int{4, 5, 6, 7, 8, 9, 0, 1, 2}
	result := search(nums, 2)
	fmt.Println(result)
}

func search(nums []int, target int) int {
	count := len(nums)
	turnIndex := findTurnIndex(nums)
	result := -1
	if turnIndex == 0 {
		result = bsearch(nums, target, 0, count-1)
	} else {
		if target < nums[0] {
			result = bsearch(nums, target, turnIndex, count-1)
		} else if target > nums[0] {
			result = bsearch(nums, target, 0, turnIndex-1)
		} else {
			result = 0
		}
	}
	return result
}

func bsearch(nums []int, target int, left int, right int) int {
	if left > right {
		return -1
	}
	mid := (left + right) >> 1
	if nums[mid] == target {
		return mid
	} else {
		if nums[mid] < target {
			return bsearch(nums, target, mid+1, right)
		} else {
			return bsearch(nums, target, left, mid-1)
		}
	}
}

func findTurnIndex(nums []int) int {
	turnIndex := 0
	count := len(nums)
	for i := 1; i < count; i++ {
		if nums[i] < nums[i-1] {
			turnIndex = i
		}
	}
	return turnIndex
}
