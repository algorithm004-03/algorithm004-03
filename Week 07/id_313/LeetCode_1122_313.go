package id_313

func relativeSortArray(arr1 []int, arr2 []int) []int {
	count := [1001]int{}
	for _, a := range arr1 {
		count[a]++
	}

	ret := make([]int, 0, len(arr1))
	for _, b := range arr2 {
		for count[b] > 0 {
			ret = append(ret, b)
			count[b]--
		}
	}
	for i := 0; i < 1001; i++ {
		for count[i] > 0 {
			ret = append(ret, i)
			count[i]--
		}
	}

	return ret
}
