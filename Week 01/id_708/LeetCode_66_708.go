package leetcode

func plusOne(digits []int) []int {
	carray := 1
	for i := len(digits) - 1; i >= 0 && carray != 0; i-- {
		sum := digits[i] + carray
		digits[i] = sum % 10
		carray = sum / 10
	}
	if carray != 0 {
		temp := []int{1}
		temp = append(temp, digits...)
		return temp
	}
	return digits
}
