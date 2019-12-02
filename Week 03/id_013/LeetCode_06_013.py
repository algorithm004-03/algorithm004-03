"""
第六题：122. 买卖股票的最佳时机 II
"""

class Solution(object):
    def maxProfit(self, prices):
        profit = 0
        for day in range(len(prices)-1):
            differ = prices[day+1] - prices[day]
            if differ > 0:
                profit += differ
        return profit