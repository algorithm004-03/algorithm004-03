func lemonadeChange(bills []int) bool {
	if (bills[0] != 5) {
		return false
	}

	change := make(map[int]int)
	for _, each := range bills {
		switch each {
		case 5:
			change[5] ++
		case 10:
			if  change[5] > 0 {
				change[10] ++
				change[5] --
			}
		case 20:
			if  change[10] > 0 && change[5] > 0 {
				change[20] ++
				change[10] --
				change[5] --
			} else if change[5] > 2{
				change[20] ++
				change[5] -= 3
			} else {
				return false
			}
		default:
			return false
		}
	}
	return true
}