func findAnagrams(s string, p string) []int {
	if len(s) < len(p) {
		return nil
	}

	var res []int
	a := newAnagramRecognizer(p)
	left, right := 0, 0
	for ; right < len(p)-1; right++ {
		a.push(s[right])
	}

	for ; right < len(s); right++ {
		a.push(s[right])
		if a.isAnagram() {
			res = append(res, left)
		}

		a.pop(s[left])
		left++
	}

	return res
}

type anagramRecognizer struct {
	counter []int
	total   int
}

func newAnagramRecognizer(target string) *anagramRecognizer {
	a := &anagramRecognizer{}
	a.counter = make([]int, int('z')+1)
	for _, r := range target {
		a.counter[r]++
		a.total++
	}

	return a
}

func (a *anagramRecognizer) push(r byte) {
	a.counter[r]--
	if a.counter[r] >= 0 {
		a.total--
	}
}

func (a *anagramRecognizer) pop(r byte) {
	a.counter[r]++
	if a.counter[r] > 0 {
		a.total++
	}
}

func (a *anagramRecognizer) isAnagram() bool {
	return a.total == 0
}
