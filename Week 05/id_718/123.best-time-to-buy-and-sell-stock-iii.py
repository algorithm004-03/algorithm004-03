#
# @lc app=leetcode id=123 lang=python3
#
# [123] Best Time to Buy and Sell Stock III
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices or not len(prices):
            return 0
        n = len(prices)
        first, second = [0] * n, [0] * n
        minp = prices[0]
        for i in range(1, n):
            first[i] = max(first[i-1], prices[i] - minp)
            minp = min(minp, prices[i])
        maxp = prices[-1]
        for i in range(n-2,0,-1):
            second[i] = max(second[i+1], maxp - prices[i])
            maxp = max(maxp, prices[i])
        ret = 0
        for i in range(1,n):
            ret = max(ret, first[i]+second[i])
        return(ret)
# @lc code=end

