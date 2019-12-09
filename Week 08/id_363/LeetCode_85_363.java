package com.test.leetcode.week08;

import org.junit.Test;


public class SolutionMaxmimalRectangle85 {


    @Test
    public void test1() {
        char[][] matrix = {
                  {'1','0','1','0','0'},
                  {'1','0','1','1','1'},
                  {'1','1','1','1','1'},
                  {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
    }

    /**
     * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     * 输入:
     * [
     *   {'1','0','1','0','0'},
     *   {'1','0','1','1','1'},
     *   {'1','1','1','1','1'},
     *   {'1','0','0','1','0'}
     * ]
     * 输出: 6
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int maxArea = 0, row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int r = 0; r < row; r ++) {
            for (int c = 0; c < col; c ++) {
                if (matrix[r][c] == '1') {
                    dp[r][c] = c == 0 ? 1 : dp[r][c - 1] + 1;
                }
                int width = dp[r][c];
                for (int k = r; k >= 0; k --) {
                    width = Math.min(width, dp[k][c]);
                    maxArea = Math.max(maxArea, width * (r - k + 1));
                }
            }
        }
        return maxArea;
    }

}
