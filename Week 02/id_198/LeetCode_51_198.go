package leetcode

import "bytes"

//该解决方案基于其他改造，后续重新实现和优化
func solveNQueens(n int) [][]string {
	var res [][]string
	find(&res, n, []int{})
	res.for
	return res
}

func find(res *[][]string, n int, path []int) {
	if len(path) == n {
		var queenPrint []string
		for _, q := range path {
			var line bytes.Buffer
			for i := 0; i < n; i++ {
				if i+1 == q {

					line.WriteString("Q")
				} else {
					line.WriteString(".")
				}
			}
			queenPrint = append(queenPrint, line.String())
		}
		*res = append(*res, queenPrint)
		return
	}

	var pos = len(path) + 1
next:
	for step := 1; step <= n; step++ {
		for i, existStep := range path {
			existPos := i + 1
			if existPos+existStep == pos+step || existStep == step || existPos-existStep == pos-step {
				continue next
			}
		}
		path = append(path, step)
		find(res, n, path)
		path = path[:len(path)-1]
	}
}
