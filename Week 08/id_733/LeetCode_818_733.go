const IntMax = int(^uint(0) >> 1)

func racecar(target int) int {
	dp := make([]int, target+1)
	for i := 1; i <= target; i++ {
		dp[i] = IntMax
		j, cnt := 1, 1
		for j < i {
			rev, revCnt := 0, 0
			for rev < j {
				dp[i] = min(dp[i], cnt+revCnt+2+dp[i-(j-rev)])
				revCnt++
				rev = 1<<uint(revCnt) - 1
			}

			cnt++
			j = 1<<uint(cnt) - 1
		}

		if i == j {
			dp[i] = min(dp[i], cnt)
		} else {
			dp[i] = min(dp[i], cnt+1+dp[j-i])
		}
	}

	return dp[target]
}

func min(x, y int) int {
	if x < y {
		return x
	}

	return y
}
