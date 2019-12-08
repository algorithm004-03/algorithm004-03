/** 这题不太懂 */
func solveNQueens(n int) [][]string {
	result = make([][]string, 0)
	board := make([][]byte, n)
	for i := 0; i < n; i++ {
		board[i] = make([]byte, n)
		for j := 0; j < n; j++ {
			board[i][j] = '.'
		}
	}
	helper(board, 0, 0, 0, 0)
	return result
}

func helper(board [][]byte, row int, colBit, leftBit, rightBit int) {
	n := len(board)
	if row == n {
		dst := make([]string, n)
		for i, v := range board {
			dst[i] = string(v)
		}
		result = append(result, dst)
		return
	}
	for i := 0; i < n; i++ {
		bit := 1 << uint(n-i-1)
		if colBit&bit == 0 && leftBit&bit == 0 && rightBit&bit == 0 {
			board[row][i] = 'Q'
			helper(board, row+1, colBit|bit, (leftBit|bit)<<1, (rightBit|bit)>>1)
			board[row][i] = '.'
		}
	}
}

var result [][]string