func numJewelsInStones(J string, S string) (ret int) {
	for _, c1 := range J {
		for _, c2 := range S {
			if c1 == c2 {
				ret++
			}
		}
	}
	return
}