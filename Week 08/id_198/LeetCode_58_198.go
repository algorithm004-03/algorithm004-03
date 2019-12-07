package leetcode

func lengthOfLastWord(s string) int {

	x := 0
	chars := []rune(s)
	for i := 0; i < len(chars); i++ {

		if chars[i] == ' ' {

			x = 0
			continue
		}
		x++
	}
	return x
}
