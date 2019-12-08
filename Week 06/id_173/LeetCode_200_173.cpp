/*
 * 200. 岛屿数量
 */

class UnionFind {
private:
	vector<int> parent;
	vector<int> rank;
	int count;

public:
	UnionFind(vector<vector<char>>& grid) {
		count = 0;
		int rows = grid.size();
		int cols = grid[0].size();

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (grid[i][j] == '1') {
					parent.push_back(i*cols + j);
					count++;
				}
				else
					parent.push_back(-1);

				rank.push_back(0);
			}
		}
	}

	int Find(int p) {
		if (p != parent[p])
			parent[p] = Find(parent[p]);
		return parent[p];
	}

	void Union(int p, int q) {
		int rootP = Find(p);
		int rootQ = Find(q);
		
		if (rootP != rootQ) {
			if (rank[rootP] > rank[rootQ])
				parent[rootQ] = rootP;
			else if (rank[rootP] < rank[rootQ])
				parent[rootP] = rootQ;
			else {
				parent[rootQ] = rootP;
				rank[rootP]++;
			}

			count--;
		}
	}

	int GetCount() {
		return count;
	}
};

class Solution {
public:
	int numIslands(vector<vector<char>>& grid) {
		int rows = grid.size();
		if (rows == 0)
			return 0;
		int cols = grid[0].size();

		UnionFind uf(grid);

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (grid[i][j] == '1') {
					grid[i][j] = '0';
					if (i - 1 >= 0 && grid[i - 1][j] == '1')
						uf.Union(i*cols + j, (i - 1)*cols + j);
					if (i + 1 < rows && grid[i + 1][j] == '1')
						uf.Union(i*cols + j, (i + 1)*cols + j);
					if (j - 1 >= 0 && grid[i][j - 1] == '1')
						uf.Union(i*cols + j, i*cols + j - 1);
					if (j + 1 < cols && grid[i][j + 1] == '1')
						uf.Union(i*cols + j, i*cols + j + 1);
				}
			}
		}

		return uf.GetCount();
	}
};