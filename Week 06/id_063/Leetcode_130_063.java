/*

 dfs搜索所有边界上面是O的点的相邻的O点，这些点保留为O，其他的O全部
 填成X

 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    static int[][] direc = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

    private boolean isValid(int rows, int cols, int i, int j) {
        return (i >= 0 && i < rows) && (j >= 0 && j < cols);
    }

    private void dfs(char[][] board, int cur_i, int cur_j) {
        int rows = board.length, cols = board[0].length;

        board[cur_i][cur_j] = '#';

        int new_i = 0, new_j = 0;
        for (int i = 0; i < 4; i++) {
            new_i = cur_i + direc[i][0];
            new_j = cur_j + direc[i][1];

            if (isValid(rows, cols, new_i, new_j) && board[new_i][new_j] == 'O') {
                dfs(board, new_i, new_j);
            }
        }
    }

    public void solve(char[][] board) {
        if ((board.length == 0) || (board[0].length == 0)) {
            return;
        }

        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }

            if (board[board.length-1][j] == 'O') {
                dfs(board, board.length - 1, j);
            }
        }

        for (int i = 1; i < board.length - 1; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }

            if (board[i][board[0].length-1] == 'O') {
                dfs(board, i, board[0].length-1);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
