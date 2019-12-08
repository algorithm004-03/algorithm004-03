//1091. 二维矩阵中的最短路径


//解法1：BFS
int dir[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
public int shortestPathBinaryMatrix(int[][] grid) {
	int m = grid.length, n = grid[0].length;
	if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;
	Queue<int[]> queue = new LinkedList<>();
	queue.offer(new int[]{0, 0});
	boolean[][] visited = new boolean[m][n];
	visited[0][0] = true;
	int res = 0;
	while (!queue.isEmpty()) {
		int size = queue.size();
		while (size -- > 0) {
			int[] pop = queue.poll();
			if (pop[0] == m - 1 && pop[1] == n - 1) return res + 1;
			for (int i = 0; i < 8; i++) {
				int nextX = dir[i][0] + pop[0];
				int nextY = dir[i][1] + pop[1];
				if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY] && grid[nextX][nextY] != 1) {
					queue.offer(new int[]{nextX, nextY});
					visited[nextX][nextY] = true;
				}
			}
		}
		res++;
	}
	return -1;
}

