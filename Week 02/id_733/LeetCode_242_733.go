func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	stats := make([]int, 26)
	for _, c := range s {
		stats[c-'a']++
	}

	for _, c := range t {
		idx := c - 'a'
		stats[idx]--
		if stats[idx] < 0 {
			return false
		}
	}

	return true
}