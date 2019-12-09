/*
 * @lc app=leetcode id=130 lang=cpp
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
public:
    
    
     void solve(vector<vector<char>>& board) {
        if (board.size() == 0) return;
        int row = board.size();
        int col = board[0].size();
        vector<vector<bool>> visited;
        visited.resize(row);
        for (int j=0; j < row; j++) {
            visited[j].resize(col);//每行为c列
        }

        for (int j=0; j<col; j++) {
            if (board[0][j] == 'O') {
                dfs(visited, 0, j, board);
            }
            if (board[row-1][j] == 'O') {
                dfs(visited, row-1, j, board);
            }
        }

        for (int i=1; i<row-1; i++) {
            if (board[i][0] == 'O') {
                dfs(visited, i, 0, board);
            }
            if (board[i][col-1] == 'O') {
                dfs(visited, i, col-1, board);
            }
        }

        for (int i =0; i < row; i++) {
            for (int j=0; j < col; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }
    
    void dfs(vector<vector<bool>> &visited, int i, int j, vector<vector<char>>& board) {
        if (i < 0 || i >= board.size() || j < 0 || j >= board[0].size() || visited[i][j] == true || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '*';
        visited[i][j] = true;
        dfs(visited, i-1, j, board);
        dfs(visited, i+1, j, board);
        dfs(visited, i, j - 1, board);
        dfs(visited, i, j + 1, board);
    }
};

// @lc code=end

