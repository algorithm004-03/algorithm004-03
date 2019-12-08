/**
* 递归范本
*/

func resur(level int, param int) {
	//终结条件
	if level > MAX_LEVEL {return}

	//处理正确逻辑
	process(level, param)

	//递归
	recur(level+1, newParam)

	//存储正确状态
}


/**
* fib优化
*/

func fib (n int) int {
	if n < 2 {return n}

	memo := map[int]int{0: 0, 1: 1}
	for i := 2; i <= n; i++ {
		memo[i] = memo[i-1] + memo[i-2]
	}

	return memo[n]
}