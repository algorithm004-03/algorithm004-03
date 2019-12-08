/*
 * @lc app=leetcode id=32 lang=cpp
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
public:
    int longestValidParentheses(string s) {
        //if string is empty ,return 0
        if(s.empty())
        {
            return 0;
        }
        int size = s.size();
        int res = 0;
        vector<int> dp(size);
        for(int i =1;i<size; ++i)
        {
            if(s[i]==')')
            {
                int pre = i - dp[i-1] - 1;
                if(pre >= 0 && s[pre] == '(')
                {
                    dp[i] = dp[i-1] + 2;
                    if(pre > 0)
                    {
                        dp[i] += dp[pre-1];
                    }
                    res = max(res,dp[i]);
                }
            }
           
        }
         return res;
    }
};
// @lc code=end

