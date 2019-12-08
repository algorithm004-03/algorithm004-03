class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 划分子问题
        // 找出状态数组
        // 找出状态转移方程
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (isValidGrid(obstacleGrid, i, j)) {
                    if (i == m-1 && j == n-1) dp[i][j] = 1;
                    else if (i == m-1) dp[i][j] = dp[i][j+1];
                    else if (j == n-1) dp[i][j] = dp[i+1][j];
                    else dp[i][j] = dp[i+1][j] + dp[i][j+1];
                } else dp[i][j] = 0;
                // System.out.printf("%d, %d, %d\n", i, j, dp[i][j]);
            }
        }
        return dp[0][0];
    }

    private boolean isValidGrid(int[][] obstacleGrid, int row, int col) {
        return obstacleGrid[row][col] == 0;
    }
}