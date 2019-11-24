//36. 有效数独

//解法1：遍历	执行用时：2ms
//思路：遍历二维矩阵, 对每一个节点进行判断：
//		1. 同一列下是否存在相同字符
//		2. 同一行下是否存在相同字符
//		3. 所在3x3矩阵中是否存在相同字符
//时间复杂度：O(n^2 * 9)
//空间复杂度：O(1)
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