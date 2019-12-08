public class Solution
{
    public int LongestValidParentheses(string s)
    {
        if (s.Length < 2) return 0;
        var dp = new int[s.Length];
        if (s[1] == ')' && s[0] == '(')
            dp[1] = 2;

        for (int i = 2; i < s.Length; i++)
        {
            if (s[i] == ')')
            {
                if (s[i - 1] == '(')
                {
                    dp[i] = dp[i - 2] + 2;
                }
                else
                {
                    var left = i - 1 - dp[i - 1];
                    if (left >= 0 && s[left] == '(')
                    {
                        dp[i] = (left >= 1 ? dp[left - 1] : 0) + dp[i - 1] + 2;
                    }

                }
            }
        }
        return dp.Max();
    }
}