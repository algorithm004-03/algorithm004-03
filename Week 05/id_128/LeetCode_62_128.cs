//recursion with memo
public class Solution
{
    public int UniquePaths(int m, int n)
    {
        if (m <= 0 || n <= 0) return 0;
        if (m == 1) return n;
        if (n == 1) return m;
        int memo = new int[m][n];
        _UniquePaths(0, 0, m, n, memo);
    }

    private int _UniquePaths(int i, int j, int m, int n, int[][] memo)
    {
        if (i >= m || j >= n) return 0;
        if (memo[i][j] != 0)
            return memo[i][j];
        return _UniquePaths(i + 1, j) + _UniquePaths(i, j + 1);
    }
}

//dp
public class Solution
{
    public int UniquePaths(int m, int n)
    {
        if (m <= 0 || n <= 0) return 0;
        if (m == 1 || n == 1) return 1;
        var opt = new int[m, n];

        for (int j = 0; j < n; j++)
            opt[0, j] = 1;
        for (int i = 0; i < m; i++)
            opt[i, 0] = 1;

        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                opt[i, j] = opt[i - 1, j] + opt[i, j - 1];
            }
        }
        return opt[m - 1, n - 1];
    }

}

//dp space optimized
public class Solution
{
    public int UniquePaths(int m, int n)
    {
        if (m <= 0 || n <= 0) return 0;
        if (m == 1 || n == 1) return 1;
        var opt = new int[m];

        for (int i = 0; i < m; i++)
            opt[i] = 1;

        for (int j = 1; j < n; j++)
        {
            for (int i = 1; i < m; i++)
            {
                opt[i] = opt[i - 1] + opt[i];
            }
        }
        return opt[m - 1];
    }

}