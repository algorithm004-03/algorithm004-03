#
# @lc app=leetcode id=69 lang=python3
#
# [69] Sqrt(x)
#

# @lc code=start
class Solution:
    def mySqrt(self, x: int) -> int:
        if x == 0 or x == 1:
            return x
        # binary search
        l, r = 1, x
        while l < r:
            mid = l + (r-l) // 2
            if mid * mid <= x < (mid + 1) * (mid + 1):
                return mid
            if mid * mid > x:
                r = mid 
            else:
                l = mid 
# @lc code=end

