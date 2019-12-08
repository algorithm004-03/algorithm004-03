#
# @lc app=leetcode id=322 lang=python3
#
# [322] Coin Change
#

# @lc code=start
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # i, j means use i coins, total amoung is j
        MAX = 100000000000000
        dp = [MAX for _ in range(amount+1)]
        dp[0] = 0
        for amt in range(1, amount + 1):
            for coin in coins:
                if amt - coin < 0:
                    continue
                dp[amt] = min(dp[amt], dp[amt-coin] + 1)
        if dp[amount] == MAX:
            return - 1
        return dp[amount]
        
# @lc code=end

