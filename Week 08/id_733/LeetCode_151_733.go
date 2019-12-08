func reverseWords(s string) string {
	res := make([]byte, len(s)+1)
	i, idx := len(s)-1, 0
	for {
		for i >= 0 && s[i] == ' ' {
			i--
		}

		if i < 0 {
			break
		}

		end := i
		for {
			i--
			if i < 0 || s[i] == ' ' {
				break
			}
		}

		for k := i + 1; k <= end; k++ {
			res[idx] = s[k]
			idx++
		}

		res[idx] = ' '
		idx++
	}

	if idx == 0 {
		return ""
	}

	return string(res[:idx-1])
}
