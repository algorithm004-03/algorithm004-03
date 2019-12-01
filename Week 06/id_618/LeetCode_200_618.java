/**
 * 深度搜索
 */
class Solution1 {

	// 方向向量
	private int[][] directions = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	private int rows;
	private int cols;

	private char[][] grid;
	private boolean[][] visited;

	public int numIslands(char[][] grid) {
		this.grid = grid;
		this.rows = grid.length;

		if (rows == 0) {
			return 0;
		}

		this.cols = grid[0].length;
		this.visited = new boolean[rows][cols];

		int islandCount = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (!this.isIsland(i, j)) {
					continue;
				}

				if (this.isVisited(i, j)) {
					continue;
				}

				islandCount++;

				this.visit(i, j);
			}
		}

		return islandCount;

	}

	private boolean inGrid(int i, int j) {
		return i > -1 && j > -1 && i < this.rows && j < this.cols;
	}

	private boolean isIsland(int i, int j) {
		return this.grid[i][j] == '1';
	}

	private boolean isVisited(int i, int j) {
		return this.visited[i][j];
	}

	private void visit(int i, int j) {
		this.visited[i][j] = true;

		for (int k = 0; k < this.directions.length; k++) {
			int nextI = i + directions[k][0];
			int newxtJ = j + directions[k][1];

			if (!this.inGrid(nextI, newxtJ)) {
				continue;
			}

			if (!this.isIsland(nextI, newxtJ)) {
				continue;
			}

			if (this.isVisited(nextI, newxtJ)) {
				continue;
			}

			this.visit(nextI, newxtJ);
		}

	}
}

/**
 * 广度搜索
 */
class Solution2 {

	private int rows;
	private int cols;

	private char[][] grid;
	private boolean[][] visited;

	private Deque<Location> queue = new LinkedList<>();

	// 方向向量
	private int[][] directions = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	private boolean inGrid(int i, int j) {
		return i > -1 && j > -1 && i < this.rows && j < this.cols;
	}

	private boolean isIsland(int i, int j) {
		return this.grid[i][j] == '1';
	}

	private boolean isVisited(int i, int j) {
		return this.visited[i][j];
	}

	public int numIslands(char[][] grid) {
		this.grid = grid;
		this.rows = grid.length;

		if (rows == 0) {
			return 0;
		}

		this.cols = grid[0].length;
		this.visited = new boolean[rows][cols];

		int islandCount = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (!this.isIsland(i, j)) {
					continue;
				}

				if (this.isVisited(i, j)) {
					continue;
				}

				islandCount++;

				LinkedList<Location> queue = new LinkedList<>();
				queue.addLast(new Location(i, j));

				this.visited[i][j] = true;

				while (!queue.isEmpty()) {
					Location location = queue.removeFirst();
					int x = location.x;
					int y = location.y;

					for (int k = 0; k < 4; k++) {
						int nextX = x + directions[k][0];
						int nextY = y + directions[k][1];

						if (!this.inGrid(nextX, nextY)) {
							continue;
						}

						if (!this.isIsland(nextX, nextY)) {
							continue;
						}

						if (this.isVisited(nextX, nextY)) {
							continue;
						}

						queue.addLast(new Location(nextX, nextY));
						this.visited[nextX][nextY] = true;
					}
				}
			}
		}

		return islandCount;
	}

	private class Location {
		int x;
		int y;

		Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

/**
 * 并查集
 * 
 * @author hangwen
 *
 */
class Solution3 {
	// 方向向量
	private int[][] directions = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	private int rows;
	private int cols;

	private char[][] grid;
	private boolean[][] visited;

	private boolean inGrid(int i, int j) {
		return i > -1 && j > -1 && i < this.rows && j < this.cols;
	}

	public int numIslands(char[][] grid) {
		this.grid = grid;

		if (grid.length == 0) {
			return 0;
		}

		this.rows = grid.length;
		this.cols = grid[0].length;

		UnionFind uf = new UnionFind(grid);

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (isIand(i, j)) {
					grid[i][j] = '0';

					for (int k = 0; k < 4; k++) {
						int nextI = i + directions[k][0];
						int nextJ = j + directions[k][1];

						if (!this.inGrid(nextI, nextJ)) {
							continue;
						}

						if (!this.isIand(nextI, nextJ)) {
							continue;
						}

						uf.union(i * cols + j, nextI * cols + nextJ);

					}
				}
			}
		}

		return uf.getCount();
	}

	private boolean isIand(int i, int j) {
		return grid[i][j] == '1';
	}

	class UnionFind {
		int count;
		int[] parent;
		int[] rank;

		public UnionFind(char[][] grid) {
			this.count = 0;
			int rows = grid.length;
			int cols = grid[0].length;

			this.parent = new int[rows * cols];
			this.rank = new int[rows * cols];

			for (int i = 0; i < rows; ++i) {
				for (int j = 0; j < cols; ++j) {
					int location = i * cols + j;

					if (grid[i][j] == '1') {
						parent[location] = location;
						++count;
					}

					rank[location] = 0;
				}
			}
		}

		public int find(int i) { // path compression
			if (parent[i] != i)
				parent[i] = find(parent[i]);
			return parent[i];
		}

		public int getCount() {
			return count;
		}

		public void union(int x, int y) { // union with rank
			int rootX = find(x);
			int rootY = find(y);

			if (rootX == rootY) {
				return;
			}

			if (rank[rootX] > rank[rootY]) {
				parent[rootY] = rootX;
			} else if (rank[rootX] < rank[rootY]) {
				parent[rootX] = rootY;
			} else {
				parent[rootY] = rootX;
				rank[rootX] += 1;
			}

			--count;
		}
	}
}