package com.test.leetcode.week05;

import org.junit.Test;


public class SolutionMinPathSum64 {


    @Test
    public void test1() {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(minPathSum(grid));
        System.out.println(minPathSum2(grid));
    }

    /**
     * DP:
     * 子问题:数组变小
     * 状态数组 存储当前点到右下角的路径的最小和
     * dp方程: dp[i][j] = Math.max(dp[i][j + 1] + dp[i + 1][j])
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[row - 1][col - 1] = grid[row - 1][col - 1];
        for (int c = col - 2; c >= 0; c --) {
            dp[row - 1][c] = dp[row - 1][c + 1] + grid[row - 1][c];
        }
        for (int r = row - 2; r >= 0; r --) {
            dp[r][col -1] = dp[r + 1][col - 1] + grid[r][col - 1];
        }
        for (int r = row - 2; r >= 0; r --) {
            for (int c = col - 2; c >= 0; c --) {
                dp[r][c] = Math.min(dp[r][c + 1], dp[r + 1][c]) + grid[r][c];
            }
        }
        return dp[0][0];
    }

    public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int[] dp = new int[col];
        dp[col - 1]= grid[row - 1][col - 1];
        for (int c = col - 2; c >= 0; c --) {
            dp[c] = dp[c + 1] + grid[row - 1][c];
        }
        for (int r = row - 2; r >= 0; r --) {
            for (int c = col - 1; c >= 0; c --) {
                if (c == col - 1) {
                    dp[c] = grid[r][c] + dp[c];
                } else {
                    dp[c] = Math.min(dp[c + 1], dp[c]) + grid[r][c];
                }
            }
        }
        return dp[0];
    }


}
