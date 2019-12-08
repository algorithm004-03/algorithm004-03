#
# @lc app=leetcode id=518 lang=python3
#
# [518] Coin Change 2
#

# @lc code=start
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        # dp[i][j] is to use first i coins to make amount j
        dp = [[0] * (amount+1) for _ in range(len(coins) + 1)]
        dp[0][0] = 1
        for i in range(1, len(coins) + 1):
            dp[i][0] = 1
            for j in range(1, amount+1):
                dp[i][j] = dp[i-1][j] + (dp[i][j-coins[i-1]] if j >= coins[i-1] else 0)
        return dp[-1][-1]
# @lc code=end

