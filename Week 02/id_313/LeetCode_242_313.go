package id313

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	// 直接支持unicode
	sr := []rune(s)
	tr := []rune(t)

	length := len(sr)
	c := make(map[rune]int, length)
	for k := range sr {
		c[sr[k]]++
		c[tr[k]]--
	}
	for _, v := range c {
		if v != 0 {
			return false
		}
	}
	return true
}
