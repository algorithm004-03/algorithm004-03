package id_313

func maxProfit(prices []int) int {
	length := len(prices)
	ret := 0
	for i := 0; i < length-1; i++ {
		m := prices[i+1] - prices[i]
		if m > 0 {
			ret += m
		}
	}
	return ret
}
