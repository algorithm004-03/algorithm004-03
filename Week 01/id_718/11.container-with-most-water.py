#
# @lc app=leetcode id=11 lang=python3
#
# [11] Container With Most Water
#

# @lc code=start
class Solution:
    def maxArea(self, height: List[int]) -> int:
        l, r = 0, len(height) - 1
        ret = 0
        while l < r:
            min_height = min(height[l], height[r])
            ret = max(ret, min_height * (r - l))
            if height[l] < height[r]:
                l += 1
            else:
                r -= 1
        return ret
# @lc code=end

