#
# @lc app=leetcode id=120 lang=python3
#
# [120] Triangle
#

# @lc code=start
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        dp, n = triangle[-1], len(triangle)
        for i in range(n-2, -1, -1):
            for j in range(len(triangle[i])):
                dp[j] = min(dp[j], dp[j+1]) + triangle[i][j]
        return dp[0]
# @lc code=end
'''
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        dp = triangle
        for i in range(len(triangle) -2, -1, -1):
            for j in range(len(triangle[i])):
                dp[i][j] = min(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j]
        return dp[0][0]
'''

