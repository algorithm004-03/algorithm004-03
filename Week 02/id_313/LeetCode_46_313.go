package id313

// 回溯，状态重置
func solveNQueens(n int) [][]string {
	if n == 0 {
		return [][]string{}
	}
	ret := make([][]string, 0)
	cols := make([]bool, n)
	// 主对角线
	master := make([]bool, 2*n)
	// 副对角线
	slave := make([]bool, 2*n)
	board := make([]string, n)
	var f func(int, []bool, []bool, []bool, []string)
	f = func(row int, cols []bool, master []bool, slave []bool, board []string) {
		if row == n {
			tmp := make([]string, n)
			copy(tmp, board)
			ret = append(ret, tmp)
		}

		for col := 0; col < len(board); col++ {
			masterIndex := n + row - col
			slaveIndex := 2*n - row - col - 1
			if !cols[col] && !master[masterIndex] && !slave[slaveIndex] {
				b := make([]byte, n)
				for i := range b {
					b[i] = '.'
				}
				b[col] = 'Q'
				board[row] = string(b)
				cols[col], master[masterIndex], slave[slaveIndex] = true, true, true
				f(row+1, cols, master, slave, board)
				cols[col], master[masterIndex], slave[slaveIndex] = false, false, false
			}

		}
	}
	f(0, cols, master, slave, board)
	return ret
}
