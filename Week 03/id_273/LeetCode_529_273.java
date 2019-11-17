//扫雷游戏

//解法1：深度优先递归DFS	执行用时击败100%
//思路：根据题目要求, 首先判断click坐标下的方块是否存在地雷, 若存在地雷则修改方块为‘X’
//		若该坐标下不存在地雷, 就需要对周围的方块进行判断是否存在地雷, 并记录周围地雷数
//			若周围存在地雷, 将该坐标方块修改为地雷数count
//			若周围不存在地雷, 将该坐标方块标记为已挖掘‘B’
//		对该坐标周围未挖掘的方块‘E’递归执行上述步骤, 直到无更多方块可被揭露
public char[][] updateBoard(char[][] board, int[] click) {
	int m = board.length;//长
	int n = board[0].length;//宽
	int row = click[0];
	int col = click[1];
	//如果地雷被挖出, 游戏结束, 该坐标修改为‘X’
	if (board[row][col] == 'M') board[row][col] = 'X';
	else {
		int count = 0;//记录周围的地雷数目
		//通过两次遍历获取周围所有格子的坐标 观察周围是否有格子存在地雷
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (i == 0 && j == 0) continue;
				int r = row + i, c = col + j;
				if (r < 0 || c < 0 || r >= m || c >= n) continue;//越界判断
				if (board[r][c] == 'M' || board[r][c] == 'X') count++;
			}
		}
		//若方块周围存在地雷, 那么该方块‘E’设置为地雷数count
		if (count > 0) {
			board[row][col] = (char)(count + '0');
		} else {
			//若不存在地雷, 那么该方块‘E’设置为已挖过区域‘B’
			board[row][col] = 'B';
			//通过两次遍历获取周围所有格子的坐标, 若存在未挖过格子‘E’, 对其递归上述步骤
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (i == 0 && j == 0) continue;
					int r = row + i;
					int c = col + j;
					if (r < 0 || c < 0 || r >= m || c >= n) continue;
					if (board[r][c] == 'E') updateBoard(board, new int[]{r, c});
				}
			}
		}
	}
	return board;
}