func myAtoi(str string) int {
	i, neg := 0, false
	for ; i < len(str); i++ {
		if str[i] == ' ' {
			continue
		}

		if str[i] == '-' {
			neg = true
			i++
		} else if str[i] == '+' {
			i++
		}

		break
	}

	var num int32
	for ; i < len(str); i++ {
		digit := int32(str[i]) - '0'
		if digit < 0 || digit > 9 {
			break
		}

		if num > math.MaxInt32/10 || (num == math.MaxInt32/10 && digit > math.MaxInt32%10) {
			if neg {
				return math.MinInt32
			}

			return math.MaxInt32
		}

		num = num*10 + digit
	}

	if neg {
		num *= -1
	}

	return int(num)
}
