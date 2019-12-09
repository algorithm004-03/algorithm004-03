func relativeSortArray(arr1 []int, arr2 []int) []int {
	counter := make([]int, 1001)
	for _, num := range arr1 {
		counter[num]++
	}

	idx := 0
	for _, num := range arr2 {
		for counter[num] > 0 {
			arr1[idx] = num
			idx++
			counter[num]--
		}
	}

	for num := range counter {
		for counter[num] > 0 {
			arr1[idx] = num
			idx++
			counter[num]--
		}
	}

	return arr1
}
