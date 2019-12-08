func relativeSortArray(arr1 []int, arr2 []int) []int {
	stack, temp, exemp := []int{}, []int{}, make(map[int][]int)

	for i, i2 := range arr2 {
		for _, i1 := range arr1 {
			if i == 0 {
				exemp[i1] = append(exemp[i1], i1)
			}
			if i2 == i1 {
				delete(exemp, i1)
				stack = append(stack, i2)
			}
		}
	}

	for _, num := range exemp {
		temp = append(temp, num...)
	}
	sort.Ints(temp)

	return append(stack, temp...)
}