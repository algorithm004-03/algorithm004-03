package com.ljg.leetcode.week05.a03;

/**
 * MinimumPathSum
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] arrs = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

        MinimumPathSum mps = new MinimumPathSum();
        int minPathSum = mps.minPathSum(arrs);
        System.out.println("minPathSum: " + minPathSum);

    }

    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[][] arrs = new int[height][width];

        arrs[0][0] = grid[0][0];
        for (int i = 1; i < height; i++) {
            arrs[i][0] = grid[i][0] + arrs[i - 1][0];
        }
        for (int j = 1; j < width; j++) {
            arrs[0][j] = grid[0][j] + arrs[0][j - 1];
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                arrs[i][j] = Math.min(arrs[i][j - 1], arrs[i - 1][j]) + grid[i][j];
            }
        }

        return arrs[height - 1][width - 1];
    }
}