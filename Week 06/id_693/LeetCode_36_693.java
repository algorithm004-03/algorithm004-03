package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc 36.有效的数独    https://leetcode-cn.com/problems/valid-sudoku/
 * @Date 2019/11/24
 */
public class LeetCode_36_693 {
    class Solution {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        // 分9个区域，（行/3）* 3 + （列 / 3） 表示当前区域
        boolean[][] area = new boolean[9][9];

        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        int areaIndex = (i / 3) * 3 + (j / 3);
                        int val = board[i][j] - '0' - 1;
                        if (area[areaIndex][val] || row[i][val] || col[j][val]) {
                            return false;
                        } else {
                            area[areaIndex][val] = true;
                            row[i][val] = true;
                            col[j][val] = true;
                        }
                    }
                }
            }
            return true;
        }
    }
}
