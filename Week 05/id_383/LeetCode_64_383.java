import java.util.Stack;

public class LeetCode_64_383 {

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = rows - 1; i > -1; i--) {
            for (int j = cols - 1; j > -1; j--) {
                if (i == rows - 1 && j == cols - 1) {
                    dp[i][j] = grid[i][j];
                } else if (i == rows - 1 && j != cols - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (j == cols - 1 && i != rows - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

}
