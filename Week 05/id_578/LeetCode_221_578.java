package com.hand.week5;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/11/2
 */
public class LeetCode_221_578 {
//    /**
//     * 二维数组
//     *
//     * @param matrix
//     * @return
//     */
//    public int maximalSquare(char[][] matrix) {
//        int m = matrix.length, n = m > 0 ? matrix[0].length : 0;
//        int[][] dp = new int[m + 1][n + 1];
//        int maxsqlen = 0;
//        for (int i = 1; i < m + 1; ++i) {
//            for (int j = 1; j < n + 1; ++j) {
//                if (matrix[i - 1][j - 1] == '1') {
//                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
//                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
//                }
//            }
//        }
//        return maxsqlen * maxsqlen;
//    }

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = m > 0 ? matrix[0].length : 0;
        int maxsqlen = 0, pre = 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i < m + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                int tmp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), pre) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                pre = tmp;
            }
        }
        return maxsqlen * maxsqlen;
    }
}
