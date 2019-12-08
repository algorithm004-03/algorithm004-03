class Solution(object):
    def maxProfit(self, prices):
        """
        买卖股票的最佳时机：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
        
        :type prices: List[int]
        :rtype: int
        """
        # 完全模拟交易过程
        # result = 0
        # keep = None
        # for i in range(len(prices) - 1):
        #     if keep is not None and keep < prices[i]:
        #         result += prices[i] - keep
        #         keep = None
        #     if prices[i] < prices[i + 1]:
        #         keep = prices[i]
        # if keep is not None:
        #     result += prices[-1] - keep
        # return result
        
        # 提炼出交易过程的关键：
        result = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]:
                result += prices[i] - prices[i - 1]
        return result
        
        
        
        
        
        
        
        
        
        
        