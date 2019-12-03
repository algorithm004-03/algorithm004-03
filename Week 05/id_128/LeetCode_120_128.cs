
//dp bottom up. reuse input array
public class Solution
{
    public int MinimumTotal(IList<IList<int>> triangle)
    {
        if (triangle is null) return 0;
        if (triangle.Count() <= 0) return 0;
        if (triangle[0].Count() <= 0) return 0;

        for (int row = triangle.Count() - 2; row >= 0; row--)
        {
            for (int col = 0; col < triangle[row].Count(); col++)
            {
                triangle[row][col] += Math.Min(triangle[row + 1][col], triangle[row + 1][col + 1]);
            }
        }
        return triangle[0][0];
    }
}

//dp bottom up. reduce dimension
public class Solution
{
    public int MinimumTotal(IList<IList<int>> triangle)
    {
        if (triangle is null) return 0;
        if (triangle.Count() <= 0) return 0;
        if (triangle[0].Count() <= 0) return 0;

        var dp = triangle[triangle.Count() - 1];
        for (int row = triangle.Count() - 2; row >= 0; row--)
        {
            for (int col = 0; col < triangle[row].Count(); col++)
            {
                dp[col] = triangle[row][col] + Math.Min(dp[col], dp[col + 1]);
            }
        }
        return dp[0];
    }
}

//dp top down
public class Solution
{
    public int MinimumTotal(IList<IList<int>> triangle)
    {
        if (triangle is null) return 0;
        if (triangle.Count() <= 0) return 0;
        if (triangle[0].Count() <= 0) return 0;

        for (int row = 1; row < triangle.Count(); row++)
        {
            for (int col = 0; col < triangle[row].Count(); col++)
            {
                if (col == 0)
                    triangle[row][col] += triangle[row - 1][col];
                else if (col == triangle[row].Count() - 1)
                    triangle[row][col] += triangle[row - 1][col - 1];
                else
                    triangle[row][col] += Math.Min(triangle[row - 1][col], triangle[row - 1][col - 1]);
            }
        }

        var res = Int32.MaxValue;
        foreach (var i in triangle[triangle.Count() - 1])
        {
            res = i < res ? i : res;
        }
        return res;
    }
}

//recursive with memo
public class Solution
{
    public int MinimumTotal(IList<IList<int>> triangle)
    {
        if (triangle is null) return 0;
        if (triangle.Count() <= 0) return 0;
        if (triangle[0].Count() <= 0) return 0;

        var memo = new bool[triangle.Count()][];
        for (int i = 0; i < triangle.Count(); i++)
        {
            memo[i] = new bool[triangle[i].Count()];
        }
        return _MinimumTotal(triangle, 0, 0, memo);
    }

    private int _MinimumTotal(IList<IList<int>> triangle, int row, int col, bool[][] memo)
    {
        if (row >= triangle.Count() - 1)
        {
            return triangle[row][col];
        }

        if (!memo[row][col])
        {
            memo[row][col] = true;
            triangle[row][col] += Math.Min(_MinimumTotal(triangle, row + 1, col),
                               _MinimumTotal(triangle, row + 1, col + 1));
        }
        return triangle[row][col];
    }
}