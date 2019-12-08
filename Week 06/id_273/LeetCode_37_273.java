//37. 有效数独

//解法1：回溯 + 剪枝
public void solveSudoku(char[][] board) {
	// 三个布尔数组 表明 行, 列, 还有 3*3 的方格的数字是否被使用过
	boolean[][] rowUsed = new boolean[9][10];
	boolean[][] colUsed = new boolean[9][10];
	boolean[][][] boxUsed = new boolean[3][3][10];
	// 初始化
	for(int row = 0; row < board.length; row++){
		for(int col = 0; col < board[0].length; col++) {
			int num = board[row][col] - '0';
			if(1 <= num && num <= 9){
				rowUsed[row][num] = true;
				colUsed[col][num] = true;
				boxUsed[row/3][col/3][num] = true;
			}
		}
	}
	// 递归尝试填充数组
	recur(rowUsed, colUsed, boxUsed, board, 0, 0);
}

private boolean recur(boolean[][] rowsUsed, boolean[][] colsUsed, boolean[][][] boardUsed, char[][] board, int row, int col) {
	if (col == board.length) {
		col = 0;
		row++;
		if (row == board.length) {
			return true;
		}
	}
	if (board[row][col] == '.') {
		for (int num = 1; num <= 9; num++) {
			boolean canUsed = !(rowsUsed[row][num] || colsUsed[col][num] || boardUsed[row/3][col/3][num]);
			if(canUsed){
				rowsUsed[row][num] = true;
				colsUsed[col][num] = true;
				boardUsed[row/3][col/3][num] = true;
				board[row][col] = (char)(num + '0');

				if (recur(rowsUsed, colsUsed, boardUsed, board, row, col + 1)) {
				   return true;
				}
				board[row][col] = '.';

				rowsUsed[row][num] = false;
				colsUsed[col][num] = false;
				boardUsed[row/3][col/3][num] = false;
			}
		}
	} else {
		return recur(rowsUsed, colsUsed, boardUsed, board, row, col + 1);
	}
	return false;
}

//解法2：回溯 + 剪枝的不同实现		执行用时：18ms
//思路：遍历二维矩阵, 若遍历到一个'.', 可以进行填坑
//		从字符'1'开始, 向二维矩阵中填入字符, 若填入的字符不符合规则, 回溯之后继续试错字符'2'
public void solveSudoku(char[][] board) {
	if (board.length != 0 || board != null) {
		solve(board);
	}
}

private boolean solve(char[][] board) {
	for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board.length; j++) {
			if (board[i][j] == '.') {
				for (char c = '1'; c <= '9'; c++) {
					//判断二维矩阵中, index(i, j) 所在的行/列/3x3矩阵中是否存在字符c
					if (isValid(board, i, j, c)) {//如果不存在, 则进行相应的添加
						board[i][j] = c;
						if (solve(board)) return true;//递归执行填坑操作, 若到最后能够全部填完return true
						board[i][j] = '.';//若填坑失败, 回溯之后填入新的数
					}
				}
				return false;
			}
		}
	}
	return true;
}

private boolean isValid(char[][] board, int row, int col, char c) {
	for(int i = 0; i < board.length; i++) {
		if(board[i][col] != '.' && board[i][col] == c) return false; //check row
		if(board[row][i] != '.' && board[row][i] == c) return false; //check column
		if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&
				board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
	}
	return true;
}