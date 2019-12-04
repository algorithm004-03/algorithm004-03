public class Solution
{
    public int UniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int m = obstacleGrid.Length;
        if (m <= 0) return 0;
        int n = obstacleGrid[0].Length;
        if (n <= 0) return 0;

        var opt = new int[m];
        if (obstacleGrid[0][0] == 1)
            return 0;
        opt[0] = 1;

        for (int j = 0; j < n; j++)
        {
            for (int i = 0; i < m; i++)
            {
                if (obstacleGrid[i][j] == 1)
                {
                    opt[i] = 0;
                }
                else if (i > 0)
                {
                    opt[i] += opt[i - 1];
                }
            }
        }
        return opt[m - 1];
    }
}