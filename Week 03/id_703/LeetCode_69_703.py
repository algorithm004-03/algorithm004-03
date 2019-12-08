#
# @lc app=leetcode.cn id=69 lang=python3
#
# [69] x 的平方根
#

# @lc code=start
class Solution:
    def mySqrt(self, x: int) -> int:
        left = 0
        right = x // 2 + 1
        while left < right:
            mid = (left + right + 1) >> 1
            square = mid * mid
            if square > x:
                right = mid - 1
            else:
                left = mid
        return left
    
        
# @lc code=end

