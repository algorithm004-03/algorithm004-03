func isIsomorphic(s string, t string) bool {
	sMap := make([]int, 256)
	tMap := make([]int, 256)
	for i := range s {
		if sMap[s[i]] != tMap[t[i]] {
			return false
		}

		sMap[s[i]] = i + 1
		tMap[t[i]] = i + 1
	}

	return true
}
