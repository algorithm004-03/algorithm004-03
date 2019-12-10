func reverseOnlyLetters(S string) string {
	str := []rune(S)
	for i, j := 0, len(str)-1; i < j; {
		if !unicode.IsLetter(str[i]) {
			i++
			continue
		}

		if !unicode.IsLetter(str[j]) {
			j--
			continue
		}

		str[i], str[j] = str[j], str[i]
		i++
		j--
	}

	return string(str)
}
