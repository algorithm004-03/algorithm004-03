package main

import "fmt"

func main2() {
	nums := []int{2, 7, 11, 15}
	r := twoSum(nums, 9)
	fmt.Println(r)
}

func twoSum(nums []int, target int) []int {
	lenth := len(nums)
	hash := make(map[int]int)
	var result []int
	for i := 0; i < lenth; i++ {
		sub := target - nums[i]
		if _, ok := hash[nums[i]]; ok {
			result = append(result, hash[nums[i]], i)
			break
		} else {
			hash[sub] = i
		}
	}
	return result
}
