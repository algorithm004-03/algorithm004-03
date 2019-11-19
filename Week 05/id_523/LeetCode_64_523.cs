public class Solution
{
    public int MinPathSum(int[,] grid)
    {
        var xLength = grid.GetLength(0);
        var yLength = grid.GetLength(1);

        for (int x = 0; x < xLength; x++)
        {
            for (int y = 0; y < yLength; y++)
            {
                if (x == 0 && y == 0)
                {
                    grid[x, y] = grid[x, y];
                }
                else if (x == 0)
                {
                    grid[x, y] = grid[x, y] + grid[x, y - 1];
                }
                else if (y == 0)
                {
                    grid[x, y] = grid[x, y] + grid[x - 1, y];
                }
                else
                {
                    grid[x, y] = grid[x, y] + Math.Min(grid[x - 1, y], grid[x, y - 1]);
                }
            }
        }

        return grid[xLength - 1, yLength - 1];
    }
}