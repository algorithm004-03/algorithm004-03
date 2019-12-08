package com.test.leetcode.week05;

import org.junit.Test;

import java.util.Arrays;


public class SolutionUniquePathWIthObs63 {


    @Test
    public void test1() {
        int[][] obstacleGrid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        int[][] obstacleGrid2 = {
                {0,0},
                {1,1},
                {0,0}
        };
        System.out.println(uniquePathsWithObstacles2(obstacleGrid));
        System.out.println(uniquePathsWithObstacles2(obstacleGrid2));
        System.out.println(uniquePathsWithObstacles3(obstacleGrid));
        System.out.println(uniquePathsWithObstacles3(obstacleGrid2));
        System.out.println(uniquePathsWithObstacles4(obstacleGrid));
        System.out.println(uniquePathsWithObstacles4(obstacleGrid2));

    }


    /**
     * 网格中可能有障碍物
     * 遇到障碍物：加0， 正常情况 是 dp[i, j] = dp[i + 1][j] + dp[i][j + 1]
     *
     * 子问题：把网格缩小
     * 状态数组：当前位置到达终点的可能的路径个数
     * dp方程：dp[i, j] = dp[i + 1][j] + dp[i][j + 1]
     *
     * 递归 -> 自顶向下 ->自下向上 -> 优化空间复杂度
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (row == 1 &&  col == 1) {
            return obstacleGrid[0][0] == 1 ? 0 : 1;
        }
        int[][] memo = new int[row][col];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        memo[row - 1][col - 1] = obstacleGrid[row - 1][col -1] == 1? 0: 1;
        for (int i = row - 2; i >= 0; i --) {
            if (obstacleGrid[i][col - 1] == 1) {
                memo[i][col - 1] = 0;
            } else {
                memo[i][col - 1] = memo[i + 1][col - 1];
            }
        }
        for (int i = col - 2; i >= 0; i --) {
            if (obstacleGrid[row - 1][i] == 1) {
                memo[row - 1][i] = 0;
            } else {
                memo[row - 1][i] = memo[row - 1][i + 1];
            }
        }
        return  help2(obstacleGrid, memo, 0, 0);
    }

    private int help2(int[][] obstacleGrid, int[][] memo, int row, int col) {
        // termination
        if (memo[row][col] > -1) {
            return memo[row][col];
        }
        if (obstacleGrid[row][col] == 1) {
            memo[row][col] = 0;
            return 0;
        }
        // process

        // drill down
        int right = help2(obstacleGrid, memo, row , col + 1);
        int below = help2(obstacleGrid, memo, row + 1 , col);
        // reverse
        memo[row][col] = right + below;
        return memo[row][col];
    }

    // 自下向上
    // 考虑障碍物在终点 考虑障碍物在最左边或者最下边 初始化需要注意
    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        // 考虑终点
        if (obstacleGrid[row - 1][col - 1] == 1) {
            return 0;
        }
        // 初始化两边的值
        int[][] memo = new int[row][col];
        memo[row - 1][col - 1]= 1;
        for (int i = row - 2;i >= 0; i --) {
            if (obstacleGrid[i][col - 1] != 1) {
                memo [i][col - 1] = memo[i + 1][col - 1];
            }
        }
        for (int i = col - 2; i >= 0; i --) {
            if (obstacleGrid[row - 1][i] != 1) {
                memo[row - 1][i] = memo[row - 1][i + 1];
            }
        }

        for (int r = row - 2; r >= 0; r --) {
            for (int c = col -2; c >= 0; c --) {
                if (obstacleGrid[r][c] != 1) {
                    memo[r][c] = memo[r][c + 1] + memo[r + 1][c];
                }
            }
        }
        return memo[0][0];
    }


    /**
     * 最简单写法
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles4(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (obstacleGrid[row - 1][col -1] == 1) {
            return 0;
        }
        int[] dp = new int[col];
        dp[col - 1] = 1;
        for (int i = col - 2; i >= 0; i --) {
            if (obstacleGrid[row - 1][i] != 1) {
                dp[i] = dp[i + 1];
            }
        }

        for (int r = row - 2; r >= 0; r --) {
            dp[col - 1] = obstacleGrid[r][col -1] == 1 ? 0 : dp[col - 1];
            for (int c = col - 2; c >= 0; c --) {
                if (obstacleGrid[r][c] != 1) {
                    dp[c] = dp[c] + dp[c + 1];
                } else {
                    dp[c] = 0;
                }
            }
        }
        return dp[0];
    }


}
