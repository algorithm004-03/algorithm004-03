class Solution(object):
    def maxProfit(self, prices):
        """
        买卖股票的最佳时机2： https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
        
        :type prices: List[int]
        :rtype: int
        """
        result = 0
        for i in range(len(prices) - 1):
            if prices[i] < prices[i + 1]:
                result += prices[i + 1] - prices[i]
        return result
