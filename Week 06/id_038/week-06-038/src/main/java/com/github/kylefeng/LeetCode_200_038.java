package com.github.kylefeng;

/**
 * 200. 岛屿数量
 *
 * @author kylefeng
 * @time 2019/11/24 15:42
 */
public class LeetCode_200_038 {
    private static int n;
    private static int m;

    public static int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) {
            return 0;
        }
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    recur(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    private static void recur(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        recur(grid, i + 1, j);
        recur(grid, i - 1, j);
        recur(grid, i, j + 1);
        recur(grid, i, j - 1);
    }
}
