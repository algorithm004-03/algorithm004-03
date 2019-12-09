package id_313

import "math"

func myAtoi(str string) int {
	b := []byte(str)
	s := 1
	n := 0
	i := 0

	for i < len(b) && b[i] == ' ' {
		i++
	}

	if i < len(b) && (b[i] == '+' || b[i] == '-') {
		if b[i] == '+' {
			s = 1
		} else {
			s = -1
		}
		i++
	}

	if i < len(b) && (b[i] == '0') {
		i++
	}

	for i < len(b) {
		if b[i] >= '0' && b[i] <= '9' {
			n *= 10
			n += int(b[i] - '0')
			if s == 1 && n >= math.MaxInt32 {
				return math.MaxInt32
			} else if s == -1 && n >= math.MaxInt32+1 {
				return math.MinInt32
			}
		} else {
			break
		}
		i++
	}

	n *= s

	return n
}
