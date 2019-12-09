package leetcode

func rabinkarpSearch(a, b string) int {
	xa := []rune(a)
	xb := []rune(b)
	m := len(xa)
	n := len(xb)
	for i := 0; i < m-n; i++ {

		j := 0
		for ; j < n; j++ {

			if xa[i+j] != xb[j] {

				break
			}
		}

		if j == n {
			return i
		}
	}

	return -1
}
