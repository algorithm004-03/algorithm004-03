/*
 * Enmotech.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 */

package com.github.kylefeng;

/**
 * 64. 最小路径和
 * <p>
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <pre>
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * </pre>
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author kylefeng
 * @time 2019/11/15 13:12
 */
public class LeetCode_64_038 {

    public static int solution_by_brutal(int[][] grid) {
        return recurCal(grid, 0, 0);
    }

    static int recurCal(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        return grid[i][j] + Math.min(recurCal(grid, i + 1, j), recurCal(grid, i, j + 1));
    }

    public static int solution_by_dp(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (i == m - 1 && j != n - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];

                } else if (j == n - 1 && i != m - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];

                } else if (j != n - 1 && i != m - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);

                } else {
                    dp[i][j] = grid[i][j];
                }

            }
        }

        return dp[0][0];
    }

}
