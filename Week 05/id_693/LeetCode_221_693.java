package id_693;

/**
 * @Desc 221. 最大正方形 https://leetcode-cn.com/problems/maximal-square/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/17
 */
public class LeetCode_221_693 {
    /*
        1、分解子问题：等于1 时 f(i)(j) = Math.min(f(i - 1)(j - 1),f(i - 1)(j),f(i)(j - 1)) + 1
        2、定义状态数组：df[i][j]
        3、DP方程：dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i][j - 1]),dp[i - 1][j - 1]) + 1
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }
}
