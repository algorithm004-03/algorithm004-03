public class Solution
{
    public int NumIslands(char[][] grid)
    {

        var num = 0;
        for (int i = 0; i < grid.Length; i++)
        {
            for (int j = 0; j < grid[i].Length; j++)
            {
                if (grid[i][j] == '1')
                {
                    SinkIsland(i, j, grid);
                    num++;
                }
            }
        }
        return num;
    }

    private void SinkIsland(int a, int b, char[][] grid)
    {
        var queue = new Queue<Tuple<int, int>>();
        queue.Enqueue(new Tuple<int, int>(a, b));

        while (queue.Count() > 0)
        {
            var spot = queue.Dequeue();
            var i = spot.Item1;
            var j = spot.Item2;
            if (i >= 0 && j >= 0 && i < grid.Length && j < grid[i].Length && grid[i][j] == '1')
            {
                grid[i][j] = '0';
                queue.Enqueue(new Tuple<int, int>(i + 1, j));
                queue.Enqueue(new Tuple<int, int>(i - 1, j));
                queue.Enqueue(new Tuple<int, int>(i, j + 1));
                queue.Enqueue(new Tuple<int, int>(i, j - 1));

            }
        }
    }
}