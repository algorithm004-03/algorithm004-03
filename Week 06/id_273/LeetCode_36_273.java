//36. 有效数独

//解法1：遍历	执行用时：2ms
public boolean isValidSudoku(char[][] board) {
	for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board.length; j++) {
			if (board[i][j] != '.' && !check(board, i, j)) return false;
		}
	}
	return true;
}

private boolean check(char[][] board, int i, int j) {
	char c = board[i][j];
	//col
	for (int m = i + 1; m < board.length; m++) {
		if (board[m][j] == c) return false;
	}
	//row
	for (int n = j + 1; n < board.length; n++) {
		if (board[i][n] == c) return false;
	}
	int temp1 = (i / 3) * 3;
	int temp2 = (j / 3) * 3;
	for (int m = temp1; m < temp1 + 3; m++) {
		for (int n = temp2; n < temp2 + 3; n++) {
			if (m != i && n != j && board[m][n] == c) return false;
		}
	}
	return true;
}