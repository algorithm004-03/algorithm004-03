package leetcode

import "fmt"

func reversePairs(nums []int) int {

	if nums == nil || len(nums) == 0 {

		return 0
	}

	return mergeSort(nums, 0, len(nums)-1)
}

func mergeSort(nums []int, l, r int) int {

	fmt.Printf("l=%d;r=%d\n", l, r)
	if l >= r {
		return 0
	}
	mid := l + (r-l)>>1
	count := mergeSort(nums, l, mid) + mergeSort(nums, mid+1, r)
	cache := make([]int, r-l+1)
	i := l
	t := l
	c := 0
	for j := mid + 1; j <= r; j++ {

		for i <= mid && int64(nums[i]) <= 2*int64(nums[j]) {
			i++
		}
		for t <= mid && nums[t] < nums[j] {
			cache[c] = nums[t]
			c++
			t++
		}
		cache[c] = nums[j]
		count += (mid - i + 1)
		c++
	}
	for t <= mid {
		cache[c] = nums[t]
		c++
		t++
	}
	copy(nums, cache)
	return count
}
