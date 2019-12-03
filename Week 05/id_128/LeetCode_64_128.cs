//dp
public class Solution
{
    public int MinPathSum(int[][] grid)
    {
        var m = grid.Length;
        var n = grid[0].Length;
        if (m <= 0) return 0;
        if (n <= 0) return 0;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.Min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[m - 1][n - 1];
    }
}

//dp reduce dimension
public class Solution
{
    public int MinPathSum(int[][] grid)
    {
        var m = grid.Length;
        var n = grid[0].Length;
        if (m <= 0) return 0;
        if (n <= 0) return 0;

        var dp = grid[0];

        for (int i = 1; i < n; i++)
        {
            dp[i] += dp[i - 1];
        }
        for (int i = 1; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (j == 0) dp[j] += grid[i][j];
                else dp[j] = Math.Min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }
}