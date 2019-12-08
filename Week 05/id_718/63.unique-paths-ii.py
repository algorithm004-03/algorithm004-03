#
# @lc app=leetcode id=63 lang=python3
#
# [63] Unique Paths II
#

# @lc code=start
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        dp = obstacleGrid
        for i in range(len(dp)):
            for j in range(len(dp[0])):
                if i == 0 and j == 0:
                    dp[i][j] = 1 - dp[i][j]
                elif i == 0:
                    dp[i][j] = dp[i][j-1]  if dp[i][j] != 1 else 0
                elif j == 0:
                   dp[i][j] = dp[i-1][j]  if dp[i][j] != 1 else 0 
                else:
                    dp[i][j] = dp[i][j-1] + dp[i-1][j] if dp[i][j] !=1 else 0
        return dp[-1][-1] 
# @lc code=end

