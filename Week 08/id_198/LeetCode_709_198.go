package leetcode

//大写变小写、小写变大写 : ASCII码 ^= 32
//大写变小写、小写变小写 : ASCII码 |= 32
//小写变大写、大写变大写 : ASCII码 &= -33

func toLowerCase(str string) string {

	chars := []rune(str)
	for i := 0; i < len(chars); i++ {

		chars[i] |= 32
	}
	return string(chars)
}
