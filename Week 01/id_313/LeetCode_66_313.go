package id313

// 高精度加法问题 注意进位 神奇的加1
func plusOne(digits []int) []int {
	length := len(digits)
	for i := length - 1; i >= 0; i-- {
		digits[i]++
		digits[i] %= 10
		if digits[i] != 0 {
			return digits
		}
	}
	digits = make([]int, length+1)
	digits[0] = 1
	return digits
}
