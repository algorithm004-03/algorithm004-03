package main

import "fmt"

func main3() {
	nums := []int{2, 2, 1, 1, 1, 2, 2}
	r := majorityElement(nums)
	fmt.Println(r)
}

func majorityElement(nums []int) int {
	lenth := len(nums)
	var count int
	var newElement int
	for i := 0; i < lenth; i++ {
		if count == 0 {
			newElement = nums[i]
		}
		if newElement == nums[i] {
			count++
		} else {
			count--
		}
	}
	return newElement
}
