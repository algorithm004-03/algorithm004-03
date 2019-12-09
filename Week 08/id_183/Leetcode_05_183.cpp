/*
 * @lc app=leetcode id=5 lang=cpp
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution
{
public:
    string longestPalindrome(string s)
    {
        //判断空字符串的情况
        if (s == "")
        {
            return "";
        }
        string result("");
        int sSize = int(s.size());
        vector<bool> store(sSize, false);
        int start = 0, end = 0, maxLen = 0;
        //动态规划 store[i] 从上层向下层循环
        for (int j = 0; j < sSize; j++)
        {
            for (int i = 0; i <= j; i++)
            {
                //长度为1，2的情况单独考虑
                store[i] = (s[i] == s[j] && (j - i < 3 || store[i + 1]));
                if (store[i] && (j - i + 1) > maxLen)
                {
                    maxLen = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }

        result = s.substr(start, end - start + 1);
        return result;
    }
};
// @lc code=end

