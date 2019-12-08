func combine(n int, k int) [][]int {
	var res [][]int
	doCombine(n, k, make([]int, 0, k), &res)
	return res
}

func doCombine(n, k int, values []int, res *[][]int) {
	if k == 0 {
		r := make([]int, len(values))
		copy(r, values)
		*res = append(*res, r)
		return
	}

	for n > 0 {
		values = append(values, n)
		n--
		doCombine(n, k - 1, values, res)
		values = values[:len(values)-1]
	}
}

func combineV2(n int, k int) [][]int {
	var res [][]int
	values := make([]int, k)
	i := 0
	for i >= 0 {
		values[i]++
		if values[i] > n {
			i--
		} else if i == k-1 {
			r := make([]int, k)
			copy(r, values)
			res = append(res, r)
		} else {
			i++
			values[i] = values[i-1]
		}
	}

	return res
}
