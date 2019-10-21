package main

import "fmt"

func rotate(nums []int, k int) {

	kk := k % len(nums)
	reverse(nums, 0, len(nums)-1)
	slice1 := nums[:kk]
	slice2 := nums[kk:]
	reverse(slice1, 0, kk-1)
	reverse(slice2, 0, len(nums)-kk-1)
}

func reverse(nums []int, start int, end int) {
	for start < end {

		tmp := nums[start]
		nums[start] = nums[end]
		nums[end] = tmp
		start++
		end--

	}
}
