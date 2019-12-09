/*
 * @lc app=leetcode.cn id=115 lang=csharp
 *
 * [115] 不同的子序列
 */

// @lc code=start
public class Solution
{
    public int NumDistinct(string s, string t)
    {
        int[,] dp = new int[t.Length + 1, s.Length + 1];
        for (int j = 0; j < s.Length + 1; j++) dp[0, j] = 1;
        for (int i = 1; i < t.Length + 1; i++)
        {
            for (int j = 1; j < s.Length + 1; j++)
            {
                if (t[i - 1] == s[j - 1]) dp[i, j] = dp[i - 1, j - 1] + dp[i, j - 1];
                else dp[i, j] = dp[i, j - 1];
            }
        }
        return dp[t.Length, s.Length];
    }
}
// @lc code=end

