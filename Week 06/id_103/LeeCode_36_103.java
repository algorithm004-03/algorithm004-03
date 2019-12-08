/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        //最外层循环，每次循环并非只是处理第i行，而是处理第i行、第i列以及第i个3x3的九宫格
        for(int i = 0; i < 9; i++){
            HashSet<Character> line = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for(int j = 0; j < 9; j++){
                if('.' != board[i][j] && !line.add(board[i][j]))
                    return false;
                if('.' != board[j][i] && !col.add(board[j][i]))
                    return false;
                int m = i/3*3+j/3;
                int n = i%3*3+j%3;
                if('.' != board[m][n] && !cube.add(board[m][n]))
                    return false;
            }
        }
        return true;
    }
}
// @lc code=end

