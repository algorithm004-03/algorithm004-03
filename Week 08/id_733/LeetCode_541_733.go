func reverseStr(s string, k int) string {
	str := []rune(s)
	for i := 0; i < len(str); i += 2 * k {
		left, right := i, i+k-1
		if right >= len(str) {
			right = len(str) - 1
		}

		for left < right {
			str[left], str[right] = str[right], str[left]
			left++
			right--
		}
	}

	return string(str)
}
