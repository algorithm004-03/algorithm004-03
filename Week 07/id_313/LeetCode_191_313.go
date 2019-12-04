package id_313

func hammingWeight(num uint32) int {
	if num == 0 {
		return 0
	}
	ret := 0
	for num != 0 {
		num = num & (num - 1)
		ret++
	}
	return ret

}
