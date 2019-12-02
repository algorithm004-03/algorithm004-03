func isValidSudoku(board [][]byte) bool {
	var target byte
	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			target = board[i][j]
			if target != '.' {
				for k := 0; k < 9; k++ {
					if k != j && board[i][k] != '.' && board[i][k] == target {
						return false
					}
					if i != k && board[k][j] != '.' && board[k][j] == target {
						return false
					}
				}
				for m := i / 3 * 3; m < (i/3+1)*3; m++ {
					for n := j / 3 * 3; n < (j/3+1)*3; n++ {
						if m != i && n != j && board[m][n] != '.' && board[m][n] == target {
							return false
						}
					}
				}
			}
		}
	}
	return true
}
