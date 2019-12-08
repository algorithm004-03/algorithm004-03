const IntMax = int(^uint(0) >> 1)

func coinChange(coins []int, amount int) int {
	memo := make([]int, amount+1)
	res := doCoinChange(coins, amount, memo)
	if res == IntMax {
		return -1
	}

	return res
}

func doCoinChange(coins []int, amount int, memo []int) int {
	if amount < 0 {
		return IntMax
	}

	if amount == 0 {
		return 0
	}

	if memo[amount] > 0 {
		return memo[amount]
	}

	m := IntMax
	for _, c := range coins {
		r := doCoinChange(coins, amount - c, memo)
		if r < m {
			m = r + 1
		}
	}

	memo[amount] = m
	return m
}

func coinChangeV2(coins []int, amount int) int {
	dp := make([]int, amount+1)
	for i := 1; i < len(dp); i++ {
		dp[i] = amount + 1
	}

	for i := 1; i <= amount; i++ {
		for _, c := range coins {
			if i < c {
				continue
			}

			if dp[i-c] < dp[i] {
				dp[i] = dp[i-c] + 1
			}
		}
	}

	if dp[amount] > amount {
		return -1
	}

	return dp[amount]
}
