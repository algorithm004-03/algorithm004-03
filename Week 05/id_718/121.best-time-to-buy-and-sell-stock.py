#
# @lc app=leetcode id=121 lang=python3
#
# [121] Best Time to Buy and Sell Stock
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        minp = float('inf')
        ret = 0
        for price in prices:
            minp = min(minp, price)
            ret = max(ret, price - minp)
        return ret
# @lc code=end

