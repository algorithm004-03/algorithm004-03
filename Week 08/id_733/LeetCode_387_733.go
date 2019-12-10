func firstUniqChar(s string) int {
	count := make([]int, 26)
	for _, r := range s {
		count[r-'a']++
	}

	for i, r := range s {
		if count[r-'a'] == 1 {
			return i
		}
	}

	return -1
}
