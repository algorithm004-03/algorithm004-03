package main

import "fmt"

func twoSum(nums []int, target int) []int {
	var numMap map[int]int
	numMap = make(map[int]int)
	for i := 0; i < len(nums); i++ {
		var difference = target - nums[i]
		if v, ok := numMap[difference]; ok {
			return []int{v, i}
		}
		_, oks := numMap[nums[i]]
		if oks {
			continue
		}
		numMap[nums[i]] = i
	}

	return []int{}
}

func main() {
	var nums = []int{2, 3, 4, 4, 0, 1, 8, 5, 6, 5, 6, 7, 8}
	fmt.Println(twoSum(nums, 9))
}
