const (
	n = 9
	numCnt = n * n
	empty = '.'
)

func solveSudoku(board [][]byte) {
	if len(board) != n || len(board[0]) != n {
		return
	}

	rows := newSudokuRecorder()
	cols := newSudokuRecorder()
	boxes := newSudokuRecorder()
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if board[i][j] != empty {
				k := board[i][j] - '1'
				rows[i][k] = true
				cols[j][k] = true
				boxes[(i/3)*3 + j/3][k] = true
			}
		}
	}

	doSolveSudoku(board, 0, rows, cols, boxes)
}

func doSolveSudoku(board [][]byte, idx int, rows, cols, boxes [][]bool) bool {
	if idx >= numCnt {
		return true
	}

	i, j := idx/n, idx%n
	if board[i][j] != empty {
		return doSolveSudoku(board, idx+1, rows, cols, boxes)
	}

	for k := 0; k < n; k++ {
		if rows[i][k] || cols[j][k] {
			continue
		}

		bIdx := (i/3)*3 + j/3
		if boxes[bIdx][k] {
			continue
		}

		board[i][j] = byte('1' + k)
		rows[i][k] = true
		cols[j][k] = true
		boxes[bIdx][k] = true
		if doSolveSudoku(board, idx+1, rows, cols, boxes) {
			return true
		}

		rows[i][k] = false
		cols[j][k] = false
		boxes[bIdx][k] = false
	}

	board[i][j] = empty
	return false
}

func newSudokuRecorder() [][]bool {
	r := make([][]bool, n)
	for i := 0; i < n; i++ {
		r[i] = make([]bool, n)
	}

	return r
}
