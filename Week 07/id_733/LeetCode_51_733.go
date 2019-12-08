const (
	queen = 'Q'
	empty = '.'
)

func solveNQueens(n int) [][]string {
	if n <= 0 {
		return nil
	}

	board := make([][]rune, n)
	for i := 0; i < n; i++ {
		board[i] = make([]rune, n)
		for j := 0; j < n; j++ {
			board[i][j] = empty
		}
	}

	res := make([][]string, 0)
	doSolveNQueens(board, &res, n, 0, 0, 0, 0)
	return res
}

func doSolveNQueens(board [][]rune, res *[][]string, n, row, col, leftSlash, rightSlash int) {
	if row >= n {
		r := make([]string, n)
		for i := 0; i < n; i++ {
			r[i] = string(board[i])
		}

		*res = append(*res, r)
	}

	pos := col | leftSlash | rightSlash
	for i := 0; i < n; i++ {
		mask := 1 << uint(i)
		if pos&mask > 0 {
			continue
		}

		board[row][i] = queen
		doSolveNQueens(board, res, n, row+1, col|mask, (leftSlash|mask)<<1, (rightSlash|mask)>>1)
		board[row][i] = empty
	}
}
