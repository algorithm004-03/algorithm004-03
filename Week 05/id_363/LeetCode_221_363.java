package com.test.leetcode.week05;

import org.junit.Test;


public class SolutionMaximalSquare221 {


    @Test
    public void test1() {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
        };
        char[][] matrix2 = {
                {'1'}
        };
        char[][] matrix3 = {
                {'0'}
        };
        System.out.println(maximalSquare(matrix));
        System.out.println(maximalSquare(matrix2));
        System.out.println(maximalSquare(matrix3));
    }

    /**
     * dp:
     * 1.子问题：二维数组变小
     * 状态数组 dp[r][c] 存储当前最大正方形的边长
     * dp方程
     *
     * dp[r][c] = Math.min(...) + 1
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        int maxLen = 0;
        for (int r = 0; r < row; r ++) {
            for (int c = 0; c < col; c ++) {
                if (matrix[r][c] == '1') {
                    dp[r + 1][c + 1] = Math.min(dp[r+ 1][c], Math.min(dp[r][c], dp[r][c + 1])) + 1;
                    maxLen = Math.max(maxLen, dp[r + 1][c + 1]);
                }
            }
        }
        return maxLen * maxLen;
    }



}
