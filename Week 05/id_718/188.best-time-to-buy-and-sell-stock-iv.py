#
# @lc app=leetcode id=188 lang=python3
#
# [188] Best Time to Buy and Sell Stock IV
#

# @lc code=start
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        n = len(prices)
        if not n: return 0
        if k > n / 2:
            return self.maxProfitII(prices)
        dp = [[0 for _ in prices] for _ in range(k + 1)]
        for i in range(1,k+1):
            localmax = dp[i-1][0] - prices[0]  # the part about jj
            for j in range(1,n):
                dp[i][j] = max(dp[i][j-1], prices[j] + localmax)
                localmax = max(localmax, dp[i-1][j] - prices[j])
        return dp[k][n-1]

    def maxProfitII(self, prices):
        price_diff = [x - y for x,y in zip(prices[1:], prices[:-1])]
        return sum(filter(lambda x: x > 0, price_diff))
"""
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        n = len(prices)
        if not n: return 0
        if k > n / 2:
            return self.maxProfitII(prices)
        profit = [[[0 for _ in range(2)] for _ in range(k+1)] for _ in range(n)]
        profit[0][0][0], profit[0][0][1] = 0, -prices[0]
        for j in range(1,k+1):
            profit[0][j][0], profit[0][j][1] = -float('inf'), -float('inf')
        # at time i, total trade j times, 0/1 - no stock at hand/one stock at hand
        for i in range(1, n):
            profit[i][0][0] = profit[i-1][0][0]
            profit[i][0][1] = max(profit[i-1][0][1], profit[i-1][0][0] - prices[i])
            for j in range(1, k+1):
                profit[i][j][0] = max(profit[i-1][j][0], profit[i-1][j-1][1] + prices[i]) # sell or do nothing, finish one trade
                profit[i][j][1] = max(profit[i-1][j][1], profit[i-1][j][0] - prices[i]) # buy or do nothing
        max_profit = [profit[n-1][j][0] for j in range(k+1)]
        return(max(max_profit))
    
    def maxProfitII(self, prices):
        price_diff = [x - y for x,y in zip(prices[1:], prices[:-1])]
        return sum(filter(lambda x: x > 0, price_diff))
"""
# @lc code=end

