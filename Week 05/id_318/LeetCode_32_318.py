#
# @lc app=leetcode id=32 lang=python3
#
# [32] Longest Valid Parentheses
#
# Test case: ")())((())())(()())"
# Expected Answer: 14
#
# @lc code=start
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        if len(s) > 0:
            dp = [0] * len(s)
        else:
            return 0
        res = 0
        for i in range(1, len(s)):
            if s[i] == ")":
                if s[i - 1] == "(":
                    dp[i] = dp[i - 2] + 2
                elif s[i - 1] == ")" and s[i - dp[i - 1] - 1] == "(":
                    dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2]
                if dp[i] > res:
                    res = dp[i]
        return res
# @lc code=end

