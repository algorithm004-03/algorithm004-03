package id313

// 多练 没啥可注释的了
func letterCombinations(digits string) []string {
	if digits == "" {
		return []string{}
	}
	s := map[uint8]string{
		2: "abc",
		3: "def",
		4: "ghi",
		5: "jkl",
		6: "mno",
		7: "pqrs",
		8: "tuv",
		9: "wxyz",
	}
	ret := make([]string, 0)
	var f func(string, string, int)
	f = func(digits, next string, index int) {
		if index == len(digits) {
			ret = append(ret, next)
			return
		}
		digit := digits[index]
		letter := s[digit-'0']
		for i := 0; i < len(letter); i++ {
			f(digits, next+string(letter[i]), index+1)
		}
		return
	}
	f(digits, "", 0)
	return ret
}
