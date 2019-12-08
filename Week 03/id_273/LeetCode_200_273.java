//200. 岛屿数量

//解法1：深度优先		执行用时：2ms
//思路：遍历二维数组, 每遍历到一个为‘1’的坐标, 深度优先递归将它自身与周围相邻的‘1’全部转换为‘0’, 这样第二次遍历时就可以排除掉第一次记录的岛屿
//		相当于每递归一次就是将一个岛屿炸沉, 递归的次数就是岛屿的数量
int[][] moves = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
int count = 0;
public int numIslands(char[][] grid) {
	for (int i = 0; i < grid.length; i++) {
		for (int j = 0; j < grid[0].length; j++) {
			if (grid[i][j] == '1') {
				dfs(grid, i, j);
				count++;
			}
		}
	}
	return count;
}

private void dfs(char[][] grid, int i, int j) {
	if (grid[i][j] == '#' || c != '1') return;
	grid[i][j] = '#';
	for (int[] move : moves) {
		int x = move[0] + i;
		int y = move[1] + j;
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) continue;
		dfs(grid, x, y);
	}
}


//解法2：并查集		执行用时：5ms
//思路：我们把二维矩阵中的每个岛屿都想象成一组联通图, 只需要计算联通图的个数就可以得知二维坐标中有几个岛屿
//		为此, 可以通过并查集进行实现：
//		1. 将二维矩阵中所有方块作为独立集合存入并查集
//		2. 依次判断每个方块是否是陆地, 若是陆地, 那么就将该方块与4联通的周围4个方块进行并查集的合并操作
//		3. 最后计算并查集中不相交的联通图数即可
public int numIslands(char[][] grid) {
	if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
	int[][] dis = new int[][]{{1, 0}, {0, -1}};
	UnionFind uf = new UnionFind(grid);
	for (int i = 0; i < grid.length; i++) {
		for (int j = 0; j < grid[0].length; j++) {
			if (grid[i][j] == '1') {
				for (int[] d : dis) {
					int x = i + d[0];
					int y = j + d[1];
					if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
						int id1 = i * grid[0].length + j;
						int id2 = x * grid[0].length + y;
						uf.union(id1, id2);
					}
				}
			}
		}
	}
	return uf.count;
}

class UnionFind {
	int[] parent;
	int count;

	public UnionFind(char[][] grid) {
		this.parent = new int[grid.length * grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					int id = i * grid[0].length + j;
					parent[id] = id;
					count++;
				}
			}
		}
	}

	public void union(int node1, int node2) {
		int x = find(node1);
		int y = find(node2);
		if (x != y) {//merge x and y
			parent[x] = y;
			count--;
		}
	}

	private int find(int node) {
		while (node != parent[node]) {
			parent[node] = parent[parent[node]];
			node = parent[node];
		}
		return node;
	}
}