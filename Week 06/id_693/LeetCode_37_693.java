package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc 37. 解数独	https://leetcode-cn.com/problems/sudoku-solver/
 * @Date 2019/11/24
 */
public class LeetCode_37_693 {
    //回溯+dfs 解法
    class Solution {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] area = new boolean[9][9];
        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0 ;j < 9;j++) {
                    if (board[i][j] != '.') {
                        int areaIndex = (i / 3) * 3 + (j / 3);
                        int val = board[i][j] - '0' - 1;
                        row[i][val] = true;
                        col[j][val] = true;
                        area[areaIndex][val] = true;
                    }
                }
            }
            dfs(board,0,0);
        }
        private boolean dfs(char[][] board,int r,int c) {
            if (c == 9) {
                r++;
                c=0;
                if (r== 9) {
                    return true;
                }
            }
            if (board[r][c] != '.') {
                return dfs(board,r,c+1);
            }
            int areaIndex = (r / 3) * 3 + (c / 3);
            for (char k = '1'; k <= '9' ;k++) {
                int val = k - '0' - 1;
                if (!row[r][val] && !col[c][val] && !area[areaIndex][val]) {
                    row[r][val] = true;
                    col[c][val] = true;
                    area[areaIndex][val] = true;
                    board[r][c] = k;
                    if (dfs(board,r,c + 1)){
                        return true;
                    };
                    row[r][val] = false;
                    col[c][val] = false;
                    area[areaIndex][val] = false;
                    board[r][c] = '.';
                }
            }
            return false;
        }
    }
}
