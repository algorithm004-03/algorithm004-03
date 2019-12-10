package com.hand.week5;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/11/2
 */
public class LeetCode_64_578 {

    /**
     * 二维数组
     * DP方程：grid[i, j]=grid[i, j]+Math.min(grid[i + 1][j], grid[i][j + 1])
     *
     * @param grid
     * @return
     */
//    public int minPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][] dp = new int[m][n];
//        for (int i = m - 1; i >= 0; --i) {
//            for (int j = n - 1; j >= 0; --j) {
//                if (i + 1 < m && j + 1 < n)
//                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
//                else if (i + 1 == m && j + 1 < n)
//                    dp[i][j] = grid[i][j] + dp[i][j + 1];
//                else if (j + 1 == n && i + 1 < m)
//                    dp[i][j] = grid[i][j] + dp[i + 1][j];
//                else
//                    dp[i][j] = grid[i][j];
//            }
//        }
//        return dp[0][0];
//    }

    /**
     * 优化成一维数组
     * DP方程：dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1])
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i + 1 < m && j + 1 < n)
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                else if (i + 1 == m && j + 1 < n)
                    dp[j] = grid[i][j] + dp[j + 1];
                else if (j + 1 == n && i + 1 < m)
                    dp[j] = grid[i][j] + dp[j];
                else
                    dp[j] = grid[i][j];
            }
        }
        return dp[0];
    }
}
