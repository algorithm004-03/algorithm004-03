public class Solution
{
    public int LongestCommonSubsequence(string text1, string text2)
    {
        if (String.IsNullOrEmpty(text1) || string.IsNullOrEmpty(text2))
            return 0;
        var m = text1.Length + 1;
        var n = text2.Length + 1;

        var opt = new int[m, n];
        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                if (text1[i - 1] == text2[j - 1])
                    opt[i, j] = 1 + opt[i - 1, j - 1];
                else
                    opt[i, j] = Math.Max(opt[i - 1, j], opt[i, j - 1]);
            }
        }
        return opt[m - 1, n - 1];
    }
}


//space optimzied
public class Solution
{
    public int LongestCommonSubsequence(string text1, string text2)
    {
        if (String.IsNullOrEmpty(text1) || string.IsNullOrEmpty(text2))
            return 0;
        var m = text1.Length + 1;
        var n = text2.Length + 1;

        var opt = new int[n];
        for (int j = 1; j < m; j++)
        {
            int tmp = 0;
            for (int i = 1; i < n; i++)
            {
                int prev = tmp;
                tmp = opt[i];
                if (text1[j - 1] == text2[i - 1])
                    opt[i] = 1 + prev;
                else
                    opt[i] = Math.Max(opt[i - 1], opt[i]);
            }
        }
        return opt[n - 1];
    }
}