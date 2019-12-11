class Solution(object):
    def maxProfit(self, prices):
        """
        买卖股票的最佳时机：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/submissions/

        :type prices: List[int]
        :rtype: int
        """
        # 最多只能完成一笔交易
        max_profit, min_price = 0, float('inf')
        for price in prices:
            if min_price > price:
                min_price = price
            else:
                max_profit = max(price - min_price, max_profit)
        return max_profit


