/*
 * @lc app=leetcode.cn id=200 lang=cpp
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
private:
    int count = 0;
    vector<int> parent;

    void init(vector<vector<char>>& grid) {
        int r = grid.size();
        int c = grid[0].size();
        parent.resize(r * c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    parent[i * c + j] = i * c + j;
                    count++;
                }
            }
        }
    }

    int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    void _union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            parent[rootQ] = rootP;
            count--;
        }
    }

public:
    int numIslands(vector<vector<char>>& grid) {
        int r = grid.size();
        if (!r) return 0;
        int c = grid[0].size();
        
        init(grid);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    int old = i * c + j;
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        _union(old, (i - 1) * c + j);
                    }
                    if (i + 1 < r && grid[i + 1][j] == '1') {
                        _union(old, (i + 1) * c + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        _union(old, i * c + j - 1);
                    }
                    if (j + 1 < c && grid[i][j + 1] == '1') {
                        _union(old, i * c + j + 1);
                    }
                }
            }
        }
        return count;
    }
};
// @lc code=end

