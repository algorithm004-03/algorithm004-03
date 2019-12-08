/*
思路
动态规划

还是下面的状态转移方式，如果i,j 位置是障碍物，这种状态走到右下角的方法数为0
dp[i][j]表示从i, j位置走到右下角的方法数
显然有
dp[i][j] = sum ( dp[i, j+1], dp[i+1, j] )


 */


class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] dp = new int[n];

        // i = m-1时候先初始化种子
        dp[n-1] = (obstacleGrid[m-1][n-1] == 1) ? 0 : 1;
        for (int j = n - 2; j >= 0; j--) {
            dp[j] = (obstacleGrid[m-1][j] == 1) ? 0 : dp[j+1];
        }

        for (int i = m - 2; i >= 0; i--) {
            dp[n-1] = (obstacleGrid[i][n-1] == 1) ? 0 : dp[n-1];
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = (obstacleGrid[i][j] == 1) ? 0 : dp[j] + dp[j+1];
            }
        }

        return dp[0];
    }
}