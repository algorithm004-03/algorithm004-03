package id_313

func lemonadeChange(bills []int) bool {
	var five, ten int
	for _, bill := range bills {
		switch bill {
		case 5:
			five++
		case 10:
			five--
			ten++
		default:
			if ten > 0 {
				five--
				ten--
			} else {
				five -= 3
			}

		}
		if ten < 0 || five < 0 {
			return false
		}
	}

	return true
}
