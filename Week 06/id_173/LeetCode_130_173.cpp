/*
 * 130. 被围绕的区域
 */

class UnionFind {
private:
	vector<int> parent;

public:
	UnionFind(int n) {
		for (int i = 0; i < n; ++i)
			parent.push_back(i);
	}

	int Find(int p) {
		if (p != parent[p])
			parent[p] = Find(parent[p]);
		return parent[p];
	}

	void Union(int p, int q) {
		int rootP = Find(p);
		int rootQ = Find(q);

		if (rootP != rootQ)
			parent[rootQ] = rootP;
	}
};

class Solution {
public:
	void solve(vector<vector<char>>& board) {
		int rows = board.size();
		if (rows == 0) return;
		int cols = board[0].size();

		UnionFind uf(rows*cols + 1);

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (board[i][j] == 'O') {
					if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1)
						uf.Union(rows*cols, i*cols + j);
					else {
						if (i - 1 >= 0 && board[i - 1][j] == 'O')
							uf.Union(i*cols + j, (i - 1)*cols + j);
						if (i + 1 < rows && board[i + 1][j] == 'O')
							uf.Union(i*cols + j, (i + 1)*cols + j);
						if (j - 1 >= 0 && board[i][j - 1] == 'O')
							uf.Union(i*cols + j, i*cols + j - 1);
						if (j + 1 < cols && board[i][j + 1] == 'O')
							uf.Union(i*cols + j, i*cols + j + 1);
					}
				}
			}
		}

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (board[i][j] == 'O' && (uf.Find(i*cols + j) != uf.Find(rows*cols)))
					board[i][j] = 'X';
			}
		}
	}
};