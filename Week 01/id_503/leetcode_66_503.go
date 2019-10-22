package week01

func plusOne(digits []int) []int {

	for i := len(digits) - 1; i >= 0; i-- {
		digits[i]++
		digits[i] %= 10
		if digits[i] != 0 {
			return digits
		}
	}

	newDigits := make([]int, len(digits)+1)
	newDigits[0] = 1

	return newDigits
}
