/*
 * @lc app=leetcode.cn id=300 lang=csharp
 *
 * [300] 最长上升子序列
 */

// @lc code=start
public class Solution
{
    public class Solution
    {
        public void ReverseString(char[] s)
        {
            int n = s.Length;
            char tmp;
            for (int i = 0; i < n >> 1; i++)
            {
                tmp = s[i];
                s[i] = s[n - 1 - i];
                s[n - 1 - i] = tmp;
            }
        }

    }
}
// @lc code=end

