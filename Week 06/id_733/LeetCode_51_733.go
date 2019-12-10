const (
	queen = 'Q'
	empty = '.'
)

func solveNQueens(n int) [][]string {
	res := make([][]string, 0)
	if n <= 0 {
		return res
	}

	board := make([][]rune, n)
	for i := range board {
		board[i] = make([]rune, n)
		for j := range board[i] {
			board[i][j] = empty
		}
	}

	cols := make([]bool, n)
	leftSlash := make([]bool, n*2)
	rightSlash := make([]bool, n*2)
	doSolveNQueens(board, &res, 0, n, cols, leftSlash, rightSlash)
	return res
}

func doSolveNQueens(board [][]rune, res *[][]string, row, n int,
	cols, leftSlash, rightSlash []bool) {
	if row == n {
		r := make([]string, n)
		for i, v := range board {
			r[i] = string(v)
		}

		*res = append(*res, r)
		return
	}

	for i := 0; i < n; i++ {
		cIdx, lsIdx, rsIdx := i, row+i, row-i+n
		if cols[cIdx] || leftSlash[lsIdx] || rightSlash[rsIdx] {
			continue
		}

		board[row][i] = queen
		cols[cIdx] = true
		leftSlash[lsIdx] = true
		rightSlash[rsIdx] = true

		doSolveNQueens(board, res, row+1, n, cols, leftSlash, rightSlash)

		board[row][i] = empty
		cols[cIdx] = false
		leftSlash[lsIdx] = false
		rightSlash[rsIdx] = false
	}
}
