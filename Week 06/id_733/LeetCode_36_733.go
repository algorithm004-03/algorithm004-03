const (
	n = 9
	empty = '.'
)

func isValidSudoku(board [][]byte) bool {
	if len(board) != n || len(board[0]) != n {
		return false
	}

	cols := newSudokuRecorder()
	boxes := newSudokuRecorder()
	for i := 0; i < n; i++ {
		rows := make([]bool, n)
		for j := 0; j < n; j++ {
			if board[i][j] == empty {
				continue
			}

			idx, cIdx, bIdx := board[i][j]-'1', j, (i/3)*3+j/3
			if rows[idx] || cols[cIdx][idx] || boxes[bIdx][idx] {
				return false
			}

			rows[idx] = true
			cols[cIdx][idx] = true
			boxes[bIdx][idx] = true
		}
	}

	return true
}

func newSudokuRecorder() [][]bool {
	r := make([][]bool, n)
	for i := 0; i < n; i++ {
		r[i] = make([]bool, n)
	}

	return r
}
