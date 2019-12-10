func reverseWords3(s string) string {
	str := []rune(s)
	for i := 0; i < len(s); i++ {
		left := i
		for i < len(s) && str[i] != ' ' {
			i++
		}

		for right := i - 1; left < right; {
			str[left], str[right] = str[right], str[left]
			left++
			right--
		}
	}

	return string(str)
}
