package com.hand.week3;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/11/2
 */
public class LeetCode_200_578 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int num = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    num++;
                    helper(i, j, grid);
                }
            }
        }
        return num;
    }

    private void helper(int i, int j, char[][] grid) {
        int maxI = grid.length;
        int maxJ = grid[0].length;
        if (i < 0 || j < 0 || i >= maxI || j > maxJ || grid[i][j] == '0') return;
        grid[i][j] = '0';
        helper(i + 1, j, grid);
        helper(i - 1, j, grid);
        helper(i, j + 1, grid);
        helper(i, j - 1, grid);
    }
}
