const (
	five = 5
	ten = 10
)

func lemonadeChange(bills []int) bool {
	fiveCnt, tenCnt := 0, 0
	for _, bill := range bills {
		if bill == five {
			fiveCnt++
		} else if bill == ten {
			tenCnt++
			fiveCnt--
		} else if tenCnt > 0 {
			tenCnt--
			fiveCnt--
		} else {
			fiveCnt -= 3
		}

		if fiveCnt < 0 {
			return false
		}
	}

	return true
}
