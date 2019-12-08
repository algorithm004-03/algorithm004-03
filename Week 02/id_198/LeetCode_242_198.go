package leetcode

func isAnagram(s string, t string) bool {

	if len(s) != len(t) {

		return false
	}
	sr := []rune(s)
	tr := []rune(t)

	counter := [26]int{}
	for i := 0; i < len(sr); i++ {

		counter[sr[i]-'a'] = counter[sr[i]-'a'] + 1
		counter[tr[i]-'a'] = counter[tr[i]-'a'] - 1
	}
	for i := 0; i < len(counter); i++ {

		if counter[i] != 0 {

			return false
		}
	}

	return true
}
