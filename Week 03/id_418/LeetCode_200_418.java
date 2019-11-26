package com.ljg.leetcode.week03.a_02;

/**
 * NumberOfIslands
 */
public class NumberOfIslands {

    public static void main(String[] args) {

    }

    private boolean[][] visited;

    public int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0) {
            return 0;
        } 
        
        int num = 0;
        int len1 = grid.length;
        int len2 = grid[0].length;
        visited = new boolean[len1][len2];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                sink(grid, i, j);
                num++;
            }
        }
        return num;
    }

    private void sink(char[][] grid, int x, int y) {
        if (visited[x][y]) {
            return;
        }
        if (grid[x][y] == '0') {
            return;
        }

        visited[x][y] = true;

        if (x > 0 && grid[x - 1][y] == '1') {
            sink(grid, x - 1, y);
        }
        if (x < grid.length - 1 && grid[x + 1][y] == '1') {
            sink(grid, x + 1, y);
        }

        if (y > 0 && grid[x][y - 1] == '1') {
            sink(grid, x, y - 1);
        }
        if (y < grid[x].length - 1 && grid[x][y + 1] == '1') {
            sink(grid, x, y + 1);
        }

        grid[x][y] = '0';
    }
}