/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if(row == 0)
            return 0;
        int col = matrix[0].length;
        int[][] dp = new int[row+1][col+1];
        int max = 0;
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(matrix[i-1][j-1] == '1'){
                    int min = Math.min(dp[i-1][j], dp[i][j-1]);
                    dp[i][j]  = Math.min(min, dp[i-1][j-1])+1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }
}
// @lc code=end

