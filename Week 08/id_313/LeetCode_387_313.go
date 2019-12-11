package id_387

func firstUniqChar(s string) int {
	rec := make([]int, 26)
	for _, bs := range s {
		rec[bs-'a']++
	}

	for i, bs := range s {
		if rec[bs-'a'] == 1 {
			return i
		}
	}

	return -1
}
