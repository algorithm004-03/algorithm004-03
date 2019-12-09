func plusOne(digits []int) []int {
	if len(digits) == 0 {
		return []int{}
	}

	res := make([]int, len(digits))
	i := len(digits) - 1
	for ; i >= 0; i-- {
		if digits[i] < 9 {
			res[i] = digits[i] + 1
			break
		}

		res[i] = 0
	}

	for i--; i >= 0; i-- {
		res[i] = digits[i]
	}

	if res[0] == 0 {
		res = make([]int, len(res)+1)
		res[0] = 1
	}

	return res
}